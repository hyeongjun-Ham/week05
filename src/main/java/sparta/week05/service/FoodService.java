package sparta.week05.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sparta.week05.dto.FoodRequestDto;
import sparta.week05.dto.FoodResponseDto;
import sparta.week05.model.Food;
import sparta.week05.model.Restaurant;
import sparta.week05.repository.FoodRepository;
import sparta.week05.repository.RestaurantRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FoodService {

    private final FoodRepository foodRepository;
    private final RestaurantRepository restaurantRepository;


    public ResponseEntity validateRegister(Long restaurantId, List<FoodRequestDto> requestDto) {
        //가게 있는지 체크
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(
                () -> new IllegalArgumentException("가게가 존재하지 않습니다.")
        );
        List<Food> addList = new ArrayList<>();

        try {
            int foodListSize = restaurant.getFoods().size();
            for (FoodRequestDto foodRequestDto : requestDto) {
                //메뉴이름, 가격 유효성 체크
                validPrice(foodRequestDto);

                Food food = new Food(restaurant, foodRequestDto);
//                addList.add(food);
                restaurant.addFoods(food);
            }
            validDuplicationMenu(foodListSize,requestDto.size(),restaurant.getFoods().size());
        } catch (Exception e) {
//            addList.clear();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

//        foodRepository.saveAll(addList);

        restaurantRepository.save(restaurant);
        return new ResponseEntity(HttpStatus.OK);
    }

    //중복된 메뉴 체크
    public void validDuplicationMenu(Long restaurantId, FoodRequestDto requestDto) {
        List<Food> menu = foodRepository.findAllByRestaurantId(restaurantId);
        for (Food food : menu) {
            String checkDuple = food.getName();
            if (requestDto.getName().equals(checkDuple)) {
                throw new IllegalArgumentException("중복 된 메뉴가 있습니다.");
            }
        }
    }

    public void validDuplicationMenu(int orginalSize, int addSize, int resultSize) {
        if (orginalSize + addSize != resultSize) {
            throw new IllegalArgumentException("중복 된 메뉴가 있습니다.");
        }
    }

    //가격 유효성 체크
    public void validPrice(FoodRequestDto requestDto) {
        int price = requestDto.getPrice();
        if (price < 100 || price > 1000000) {
            throw new IllegalArgumentException("100원 ~ 1,000,000원 사이로 입력해주세요");
        } else if (price % 100 != 0) {
            throw new IllegalArgumentException("100원 단위로 입력해 주세요");
        }
    }

    // 메뉴 전체 보여주기
    public List<FoodResponseDto> showMenu(Long restaurantId) {
        return foodRepository.findAllByRestaurantId(restaurantId)
                .stream()
                .map(FoodResponseDto::new)
                .collect(Collectors.toList());
    }
}

package sparta.week05.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sparta.week05.dto.FoodRequestDto;
import sparta.week05.dto.FoodResponseDto;
import sparta.week05.model.Food;
import sparta.week05.repository.FoodRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FoodService {

    private final FoodRepository foodRepository;

    public void registerFood(Long restaurantId, FoodRequestDto requestDto) {

        validDuplicationMenu(restaurantId, requestDto);
        validPrice(requestDto);
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

    //가격 유효성 체크
    public void validPrice(FoodRequestDto requestDto) {
            Long price = requestDto.getPrice();
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

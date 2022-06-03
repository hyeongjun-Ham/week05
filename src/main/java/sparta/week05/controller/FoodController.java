package sparta.week05.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sparta.week05.dto.FoodRequestDto;
import sparta.week05.dto.FoodResponseDto;
import sparta.week05.model.Food;
import sparta.week05.model.Restaurant;
import sparta.week05.repository.FoodRepository;
import sparta.week05.repository.RestaurantRepository;
import sparta.week05.service.FoodService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FoodController {

    private final FoodService foodService;
    private final FoodRepository foodRepository;
    private final RestaurantRepository restaurantRepository;

    //메뉴 등록
    @PostMapping("/restaurant/{restaurantId}/food/register")
    public Food registerFood(@PathVariable Long restaurantId, @RequestBody FoodRequestDto requestDto) {
        //가게 있는지 체크
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(
                () -> new IllegalArgumentException("가게가 존재하지 않습니다.")
        );
        //메뉴이름, 가격 유효성 체크
        foodService.registerFood(restaurantId, requestDto);

        Food food = new Food(restaurant, requestDto);

        return foodRepository.save(food);
    }


    //가게에 있는 메뉴 전체 조회
    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<FoodResponseDto> showMenu(@PathVariable Long restaurantId) {
        return foodService.showMenu(restaurantId);
    }

}

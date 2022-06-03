package sparta.week05.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sparta.week05.dto.FoodResponseDto;
import sparta.week05.dto.OrderRequestDto;
import sparta.week05.model.Orders;
import sparta.week05.model.Restaurant;
import sparta.week05.repository.FoodRepository;
import sparta.week05.repository.RestaurantRepository;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final FoodRepository foodRepository;
    private final RestaurantRepository restaurantRepository;

    private final FoodService foodService;

    public void order(OrderRequestDto requestDto) {
        Long restaurantId = requestDto.getRestaurantId();
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(
                () -> new IllegalArgumentException("가게가 없습니다.")
        );
        HashMap<Long, Long> map = new HashMap<>();


        List<FoodResponseDto> menu = foodService.showMenu(requestDto.getRestaurantId()); // 메뉴에 id, name, price 있음
        requestDto.getFoods();

        Orders order = new Orders(restaurant.getName());
    }
}

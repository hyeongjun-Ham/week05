package sparta.week05.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sparta.week05.dto.RestaurantDto;
import sparta.week05.model.Restaurant;
import sparta.week05.repository.RestaurantRepository;
import sparta.week05.service.RestaurantService;

import java.util.List;

@RestController // Controller + ResponseBody
@RequiredArgsConstructor  //final 이나 @NonNull 필드 값만 파라미터로 받는 생성자 만듬
public class RestaurantController {

    public final RestaurantService restaurantService;

    public final RestaurantRepository restaurantRepository;

    //음식점 등록
    @PostMapping("/restaurant/register")
    public Restaurant registerRestaurant(@RequestBody RestaurantDto requestDto){
        Restaurant restaurant = restaurantService.registerRestaurant(requestDto);
        return restaurantRepository.save(restaurant);
    }

    //음식점 조회
    @GetMapping("/restaurants")
    public List<Restaurant> showRestaurantList() {
       return restaurantRepository.findAll();
    }
}

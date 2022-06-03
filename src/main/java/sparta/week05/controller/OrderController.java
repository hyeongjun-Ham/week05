package sparta.week05.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sparta.week05.dto.OrderRequestDto;
import sparta.week05.model.Order;
import sparta.week05.repository.FoodRepository;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final FoodRepository foodRepository;

    @PostMapping("/order/request")
    public Order order(@RequestBody OrderRequestDto requestDto) {

    }
}

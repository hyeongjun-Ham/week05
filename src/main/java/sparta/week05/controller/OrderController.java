package sparta.week05.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sparta.week05.dto.OrderRequestDto;
import sparta.week05.repository.FoodRepository;
import sparta.week05.service.OrderService;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final FoodRepository foodRepository;

    private final OrderService orderService;
    @PostMapping("/order/request")
    public void order(@RequestBody OrderRequestDto requestDto) {
        orderService.order(requestDto);
    }
}

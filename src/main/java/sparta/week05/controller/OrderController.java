package sparta.week05.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sparta.week05.dto.OrderRequestDto;
import sparta.week05.model.Orders;
import sparta.week05.service.OrderService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    @PostMapping("/order/request")
    public Orders order(@RequestBody OrderRequestDto requestDto) {
        return orderService.addOrderMenu(requestDto);
    }

    @GetMapping("/orders")
    public List<Orders> showOrders() {
        return orderService.getOrderRepository().findAll();
    }
}

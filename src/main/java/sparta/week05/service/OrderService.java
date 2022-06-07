package sparta.week05.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sparta.week05.dto.OrderRequestDetailDto;
import sparta.week05.dto.OrderRequestDto;
import sparta.week05.model.OrderMenu;
import sparta.week05.model.Orders;
import sparta.week05.model.Restaurant;
import sparta.week05.repository.FoodRepository;
import sparta.week05.repository.OrderRepository;
import sparta.week05.repository.RestaurantRepository;

import java.util.ArrayList;

@Service
@Getter
@RequiredArgsConstructor
public class OrderService {

    private final FoodRepository foodRepository;
    private final RestaurantRepository restaurantRepository;
    private final OrderRepository orderRepository;

    public Orders addOrderMenu(OrderRequestDto requestDto) {
        Long restaurantId = requestDto.getRestaurantId();
        ArrayList<OrderRequestDetailDto> foods = requestDto.getFoods();
        //레스토랑 찾는 과정
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(
                () -> new IllegalArgumentException("가게가 없습니다.")
        );
        //레스토랑 이름
        String restaurantName = restaurant.getName();

        //최소금액
        int minOrderPrice = restaurant.getMinOrderPrice();

        //배달료
        int deliveryFee = restaurant.getDeliveryFee();

        // 주문 음식 가격의 합계산
        int totalOrderPrice = 0;
        for (OrderRequestDetailDto orderRequestDetailDto : foods) {
            Long id = orderRequestDetailDto.getId();

            int eachPrice = foodRepository.findById(id).get().getPrice();
            int quantity = orderRequestDetailDto.getQuantity();

            int price = eachPrice * quantity;

            totalOrderPrice += price;
        }
        //최종 결제 금액
        int totalPrice = deliveryFee + totalOrderPrice;

        //유효성 검증
        for (OrderRequestDetailDto food : foods) {
            //주문 갯수 확인
            int quantity = food.getQuantity();

            if (quantity < 1 || quantity > 100) {
                throw new IllegalArgumentException("1개 ~ 100개 사이로 주문해 주세요");
            }
        }
        if (totalOrderPrice < minOrderPrice) {
            throw new IllegalArgumentException("최소 주문가격 이상 주문해야 합니다.");
        }
        Orders orders = new Orders(restaurantName,deliveryFee,totalPrice);

        //주문 저장

        for (int i = 0; i < foods.size(); i++) {
            Long id = foods.get(i).getId();

            String name = foodRepository.findById(id).get().getName();
            int eachPrice = foodRepository.findById(id).get().getPrice();
            int quantity = foods.get(i).getQuantity();

            int price = eachPrice * quantity;
        OrderMenu orderMenu = new OrderMenu(name,orders,quantity,price);

        orders.addFood(orderMenu);
        }

        return orderRepository.save(orders);
    }
}



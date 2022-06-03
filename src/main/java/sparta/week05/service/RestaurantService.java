package sparta.week05.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sparta.week05.dto.RestaurantDto;
import sparta.week05.model.Restaurant;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    public Restaurant registerRestaurant(RestaurantDto requestDto) {
        validRestaurant(requestDto);
        return new Restaurant(requestDto);
    }

    //음식점 유효성 검사
    public void validRestaurant(RestaurantDto requestDto) {
        int minOrderPrice = requestDto.getMinOrderPrice();
        int deliveryFee = requestDto.getDeliveryFee();

        if (minOrderPrice<1000 || minOrderPrice>100000){
            throw new IllegalArgumentException("1,000원 ~ 100,000원 사이로 입력해 주세요");
        } else if (minOrderPrice%100 != 0) {
            throw new IllegalArgumentException("100원 단위로 입력해 주세요");
        } else if (deliveryFee<0 || deliveryFee>10000) {
            throw new IllegalArgumentException("0원 ~ 10,000원 사이로 입력해 주세요");
        } else if (deliveryFee % 500 != 0) {
            throw new IllegalArgumentException("500원 단위로 입력해 주세요");
        }
    }

}

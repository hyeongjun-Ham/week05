package sparta.week05.dto;

import lombok.Getter;

@Getter
public class RestaurantDto {

    private Long id;

    private String name;

    private int minOrderPrice;

    private int deliveryFee;

//    public RestaurantDto(Restaurant restaurant) {
//        this.id = restaurant.getId();
//        this.name = restaurant.getName();
//        this.minOrderPrice = restaurant.getMinOrderPrice();
//        this.deliveryFee = restaurant.getDeliveryFee();
//    }
}

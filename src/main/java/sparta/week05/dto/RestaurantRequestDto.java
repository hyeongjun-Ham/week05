package sparta.week05.dto;

import lombok.Getter;

@Getter
public class RestaurantRequestDto {

    private String name;

    private Long minOrderPrice;

    private Long deliveryFee;

}

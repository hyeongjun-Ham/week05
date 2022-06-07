package sparta.week05.dto;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class OrderRequestDto {

    private Long restaurantId;

    private ArrayList<OrderRequestDetailDto> foods;

}

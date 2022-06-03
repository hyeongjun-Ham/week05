package sparta.week05.dto;

import lombok.Getter;

import java.util.List;


@Getter
public class OrderResponseDto {

    private String restaurantName;
    private String name;
    private Long quantity;
    private Long price;

}

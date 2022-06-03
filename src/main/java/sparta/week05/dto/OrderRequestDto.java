package sparta.week05.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class OrderRequestDto {

    private Long restaurantId;
    private Long id;
    private Long quantity;

}

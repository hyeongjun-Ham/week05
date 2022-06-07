package sparta.week05.dto;

import lombok.Getter;
import lombok.Setter;
import sparta.week05.model.Food;

@Getter
@Setter
public class FoodResponseDto {

    private Long id;
    private String name;
    private int price;

    public FoodResponseDto(Food food) {
        this.id = food.getId();
        this.name = food.getName();
        this.price= food.getPrice();
    }
}


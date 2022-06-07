package sparta.week05.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import sparta.week05.dto.FoodRequestDto;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private Long restaurantId;

    public Food(Long restaurantId, FoodRequestDto requestDto) {
        this.restaurantId = restaurantId;
        this.name = requestDto.getName();
        this.price = requestDto.getPrice();
    }
}

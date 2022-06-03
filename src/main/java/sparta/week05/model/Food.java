package sparta.week05.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column
    private String name;

    @Column
    private Long price;

    @ManyToOne
    @JoinColumn
    @JsonIgnore //무한루프를 타지 않게한다.
    private Restaurant restaurant;

    public Food(Restaurant restaurant, FoodRequestDto requestDto) {
        this.restaurant = restaurant;
        this.name = requestDto.getName();
        this.price = requestDto.getPrice();
    }
}

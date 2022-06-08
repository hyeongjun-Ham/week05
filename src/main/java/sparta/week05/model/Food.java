package sparta.week05.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sparta.week05.dto.FoodRequestDto;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"name","resaurant"})})
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Max(10000)
    @Min(1000)
    private int price;

    @ManyToOne
    @JoinColumn
    @JsonIgnore //무한루프 끊기
    private Restaurant restaurant;

    public Food(Restaurant restaurant, FoodRequestDto requestDto) {
        this.restaurant = restaurant;
        this.name = requestDto.getName();
        this.price = requestDto.getPrice();
    }
}

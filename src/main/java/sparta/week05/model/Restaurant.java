package sparta.week05.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import sparta.week05.dto.RestaurantDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter //게터 써야 완료 후 보내줄 때 정상적인 JSON 형태로 보임
@NoArgsConstructor // 파라미터 없는 기본 생성자 생성
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int minOrderPrice;

    @Column(nullable = false)
    private int deliveryFee;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Food> foods = new ArrayList<>();

    public void addFoods(Food food) {
        if (foods.stream().filter(e -> e.getName().equals(food.getName())).count() == 0) {
            foods.add(food);
        }
    }

    public Restaurant(RestaurantDto requestDto) {
        this.name = requestDto.getName();
        this.minOrderPrice = requestDto.getMinOrderPrice();
        this.deliveryFee = requestDto.getDeliveryFee();
    }
}

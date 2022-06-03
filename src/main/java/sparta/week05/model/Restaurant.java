package sparta.week05.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import sparta.week05.dto.RestaurantRequestDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter //게터 써야 완료 후 보내줄 때 정상적인 JSON형태로 보임
@NoArgsConstructor // 파라미터 없는 기본 생성자 생성
public class Restaurant {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long minOrderPrice;

    @Column(nullable = false)
    private Long deliveryFee;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.REMOVE)
    List<Food> foods = new ArrayList<>();

    public Restaurant(RestaurantRequestDto requestDto) {
        this.name = requestDto.getName();
        this.minOrderPrice = requestDto.getMinOrderPrice();
        this.deliveryFee = requestDto.getDeliveryFee();
    }
}

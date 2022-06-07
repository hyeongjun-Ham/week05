package sparta.week05.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String restaurantName;

    @Column(nullable = false)
    private int deliveryFee;

    @Column(nullable = false)
    private int totalPrice;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
    private List<OrderMenu> foods = new ArrayList<>();

    public Orders(String restaurantName,int deliveryFee,int totalPrice){
        this.restaurantName = restaurantName;
        this.deliveryFee = deliveryFee;
        this.totalPrice = totalPrice;
    }

    public void addFood(OrderMenu orderMenu) {
        this.foods.add(orderMenu);
    }
}

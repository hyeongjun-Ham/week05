package sparta.week05.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String restaurantName;

    private String name;

    private Long quantity;

    private Long price;

    private Long deliveryFee;

    private Long totalPrice;

    public Orders(String name) {
    }
}

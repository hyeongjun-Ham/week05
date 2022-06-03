package sparta.week05.model;

import javax.persistence.*;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String restaurantName;

    @Column
    private String foods;

    private String name;

    private Long quantity;

    private Long price;

    private Long deliveryFee;

    private Long totalPrice;

}

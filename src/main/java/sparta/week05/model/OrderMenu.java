package sparta.week05.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class OrderMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private int quantity;

    @Column
    private int price;

    @ManyToOne
    @JoinColumn
    @JsonIgnore //무한루프 끊기
    private Orders orders;

    public OrderMenu(String name,Orders orders,int quantity, int price){
        this.name = name;
        this.orders = orders;
        this.quantity = quantity;
        this.price = price;
    }
}

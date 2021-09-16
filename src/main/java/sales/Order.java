package sales;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "myOrder")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "product")
    private String product;

    @Column(name = "price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client myClient;

    public Order() {}

    public Order(String product, double price) {
        this.product = product;
        this.price = price;
    }

}

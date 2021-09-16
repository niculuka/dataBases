package sales;

import classes.PostComment;
import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "myClient")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name_client")
    private String name_client;

    @Column(name = "phone_client")
    private String phone_client;

    @OneToMany( mappedBy = "myClient",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Order> orders = new ArrayList<>();

    public Client() {}

    public Client(String name_client, String phone_client) {
        this.name_client = name_client;
        this.phone_client = phone_client;
    }

    public void addOrder(Order myOrder) {
        orders.add(myOrder);
    }
}

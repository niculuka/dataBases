package classes;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name = "coffee_origin")
    private String coffee_origin;

    public Products() {}

    public Products(int id, String name, double price, String coffee_origin) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.coffee_origin = coffee_origin;
    }

    public Products(String name, double price, String coffee_origin) {
        this.name = name;
        this.price = price;
        this.coffee_origin = coffee_origin;
    }

    public int getId() {
        return id;
    }

    public Products setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Products setName(String name) {
        this.name = name;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public Products setPrice(double price) {
        this.price = price;
        return this;
    }

    public String getCoffee_origin() {
        return coffee_origin;
    }

    public Products setCoffee_origin(String coffee_origin) {
        this.coffee_origin = coffee_origin;
        return this;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", coffee_origin='" + coffee_origin + '\'' +
                '}';
    }
}

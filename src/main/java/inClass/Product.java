package inClass;

public class Product {
    private int id;
    private String name;
    private double price;
    private String coffee_origin;

    public Product() {}

    public Product(int id, String name, double price, String coffee_origin) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.coffee_origin = coffee_origin;
    }

    public int getId() {
        return id;
    }

    public Product setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public Product setPrice(double price) {
        this.price = price;
        return this;
    }

    public String getCoffee_origin() {
        return coffee_origin;
    }

    public Product setCoffee_origin(String coffee_origin) {
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

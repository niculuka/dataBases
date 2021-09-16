package inClass;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        try {
            Statement stmt = ConfigurationUtil.getConnection().createStatement();
            String sql = "select * from products";
            ResultSet rs = stmt.executeQuery(sql);

            List<Product> productsList = new ArrayList<>();

            while (rs.next()) {
                Product product = new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getString("coffee_origin"));
                productsList.add(product);
            }
            stmt.close();
            rs.close();


            for (Product product : productsList) {
                System.out.println(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("=========================================================================================");


        ProductRepository productRepository = new ProductRepository();

//        System.out.println("------------------------------- I N S E R T ----------------------------");
//        Product product1 = new Product(29, "cappuccino", 1.50, "Acasa");
//        if (productRepository.insertProduct(product1) > 0) {
//            System.out.println("Insert successful: " + product1);
//        }

        System.out.println("------------------------------- I N S E R T ----------------------------");

        productRepository.updateProduct(10, "cappuccino-white");
        productRepository.updateProduct(11, "cappuccino-black");

    }
}

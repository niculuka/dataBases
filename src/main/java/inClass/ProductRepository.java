package inClass;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductRepository {
    public int insertProduct(Product product) {
        String sql = "insert into products values(?, ?, ?, ?)";
        try (PreparedStatement stmt = ConfigurationUtil.getConnection().prepareStatement(sql)){
            stmt.setInt(1, product.getId());
            stmt.setString(2, product.getName());
            stmt.setDouble(3, product.getPrice());
            stmt.setString(4, product.getCoffee_origin());
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
//      Modul manual de insert:
//        sql = "INSERT INTO products VALUES (" +
//                product.getId() + ", " + product.getName() + ", " + product.getPrice() + ", " +  product.getCoffee_origin() + " )";

        return 0;
    }
    //  update students set name_students = 'AAA' where name_students = 'Tilica';
    public void updateProduct(int id, String name) {
        String sql = "UPDATE products SET name = '" + name + "' WHERE id = " + id + ";";
        System.out.println(sql);
        try (PreparedStatement stmt = ConfigurationUtil.getConnection().prepareStatement(sql)) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

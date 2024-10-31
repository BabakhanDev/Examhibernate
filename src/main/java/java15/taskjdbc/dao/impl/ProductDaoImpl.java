package java15.taskjdbc.dao.impl;

import java15.taskjdbc.config.DatabaseConnect;
import java15.taskjdbc.models.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    Connection conn = DatabaseConnect.getConnection();

    @Override
    public void createProductTable() {
        String sql = """
                        CREATE TABLE IF NOT EXISTS products
                (id serial primary key,
                name varchar(50),
                rating varchar(50),
                price  int)
                """;
        try (Statement statement = conn.createStatement()) {
            statement.execute(sql);
            System.out.println("Successfully created table Employees !");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void addProduct(Product product) {
        String sql = "INSERT INTO products (name,rating,price)VALUES(?,?,?)";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getRating());
            preparedStatement.setInt(3, product.getPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Product getProductById(Long id) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products WHERE id = ?";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product
                        (resultSet.getLong("id"),
                                resultSet.getString("name"),
                                resultSet.getString("rating"),
                                resultSet.getInt("price")
                        );
                products.add(product);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return products.isEmpty() ? null : products.get(0);
    }

    @Override
    public String updateProduct(Product product) {
        String sql = """
                update products set name = ?, rating = ?, price = ? where id = ?""";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getRating());
            preparedStatement.setInt(3, product.getPrice());
            preparedStatement.executeUpdate();
            System.out.println("Successfully updated Product !");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "not updated";
    }

    @Override
    public void deleteProduct(Long id) {
        String sql = """
                DELETE FROM products 
                WHERE product_id = ?""";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setLong(1, id);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Product deleted successfully.");
            } else {
                System.out.println("No product found with the specified ID.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Product> sortProduct(String ascOrDesc) {
        List<Product> products = new ArrayList<>();
        String query = "select * from jobs order by rating" + (ascOrDesc.equalsIgnoreCase("asc") ? "asc" : "desc");
        try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                products.add(new Product(
                        resultSet.getString("name"),
                        resultSet.getString("rating"),
                        resultSet.getInt("price")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return products;
    }

    @Override
    public Product getProdWithPrice(int min, int max) {
            List<Product> products = new ArrayList<>();
            String sql = """
            SELECT * FROM products WHERE price >= ? AND price <= ?
          """;
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setInt(1, min);
                preparedStatement.setInt(2, max);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    products.add(new Product(
                            resultSet.getString("name"),
                            resultSet.getString("rating"),
                            resultSet.getInt("price")
                    ));
                }
                if (!products.isEmpty()) {
                    return products.get(0);
                } else {
                    System.out.println("No products found in the specified price range.");
                }

            } catch (SQLException e) {
                System.out.println("Database error: " + e.getMessage());
            }
            return null;
        }

    }

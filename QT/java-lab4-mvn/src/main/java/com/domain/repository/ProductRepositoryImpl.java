package com.domain.repository;

import com.domain.exception.ProductNotAvailableException;
import com.domain.model.Product;
import com.domain.repository.util.MySQLConnection;

import java.sql.*;
import java.util.ArrayList;

public class ProductRepositoryImpl implements ProductRepository {

    // functionality related to repository handling
    // Encapsulating the productName
    private String productName;

    // constructors are methods with same class name
    // purpose : initialize
    //  constructor without parameter is a default constructor
    // called automatically with new keyword
    public ProductRepositoryImpl() {
        System.out.println("ProductRepositoryImpl instantiated ....");
        productName = "Fullstack Development";
    }

    public String log() {
        return "Log";
    }
    public String getProductNameFromRepository() {
        return productName;
    }

    public Product getProductObject() {

        //Product meaningProduct = null;
        //Product meaningProduct = new Product();
        Product meaningProduct = new Product(1,"Man's search for Meaning",50.5f);
        try {
        //meaningProduct.setProductId(1);
        //meaningProduct.setProductName("Man's search for Meaning");
        //meaningProduct.setPrice(50.50f);
        } catch (NullPointerException nullPointerException) {
            System.out.println("Secret Log : " + nullPointerException);
            System.out.println("Hi <<Person>>, please try after some time!");
        }

//		return meaningProduct;
        // consider the product is not available
        // instantiate the user defined exception
        try {
            if (meaningProduct == null) {
                ProductNotAvailableException productNotAvailableException = new ProductNotAvailableException();
                throw productNotAvailableException;
            }
        }

        catch (ProductNotAvailableException productNotAvailableException) {
            System.out.println("Sorry, the product you are looking for is not avaibable..");
        }
        return null;
    }

    public ArrayList<Product> getProducts() {
        ArrayList<Product> products = new ArrayList<Product>();
        Product product = new Product(1,"Hello World",50.0f);
        products.add(product);
        return products;
    }

    public ArrayList getProductsFromDB() {
        Connection connection = MySQLConnection.getConnection();
        ArrayList<Product> products = new ArrayList<Product>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM PRODUCTS");
            while (resultSet.next()) {
                products.add(new Product(resultSet.getInt(1),resultSet.getString(2),resultSet.getFloat("price")));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return products;
    }

    public boolean insertProductsIntoDB(Product product) {
        int rows = 0;
        Connection connection = MySQLConnection.getConnection();
        try {
            Statement statement = connection.createStatement();
            String query = String.format("INSERT INTO PRODUCTS VALUES (%d,'%s',%f)",product.getProductId(),product.getProductName(),product.getPrice());
            rows = statement.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        if (rows > 0) return true;
        return false;
    }

    public boolean updateProductsIntoDB(Product product) {
        int rows = 0;
        Connection connection = MySQLConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE PRODUCTS SET PRODUCT_NAME=?, PRICE=? WHERE PRODUCT_ID=?");
            preparedStatement.setString(1,product.getProductName());
            preparedStatement.setFloat(2,product.getPrice());
            preparedStatement.setInt(3,product.getProductId());
            rows = preparedStatement.executeUpdate();
        } catch (SQLException ex) {

        }
        if (rows > 0) return true;
        return false;
    }

    public boolean deleteProductsIntoDB(int productId) {
        int rows = 0;
        Connection connection = MySQLConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM PRODUCTS WHERE PRODUCT_ID=?");
            preparedStatement.setInt(1,productId);
            rows = preparedStatement.executeUpdate();

            /*
            Statement statement = connection.createStatement();
            String query = String.format("DELETE FROM PRODUCTS WHERE PRODUCT_ID=%d",productId);
            rows = statement.executeUpdate(query);
            */
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        if (rows > 0) return true;
        return false;
    }
}
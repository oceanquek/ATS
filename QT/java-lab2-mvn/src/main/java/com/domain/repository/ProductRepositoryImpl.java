package com.domain.repository;

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

    public Product getProductObject(int productID) {

        Product product = null;

        Connection connection = MySQLConnection.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM PRODUCTS WHERE ID=%d",productID));
            if (resultSet.next()) {
                product = new Product(resultSet.getInt(1),resultSet.getString(2),resultSet.getFloat("price"));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return product;
    }

    public ArrayList<Product> getProducts() {
        ArrayList<Product> products = new ArrayList<>();
        Product product = new Product(1,"Hello World",50.0f);
        products.add(product);
        return products;
    }

    @Override
    public ArrayList getProductsFromDB() {
        Connection connection = MySQLConnection.getConnection();
        ArrayList<Product> products = new ArrayList<>();
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

    @Override
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

    @Override
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

    @Override
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
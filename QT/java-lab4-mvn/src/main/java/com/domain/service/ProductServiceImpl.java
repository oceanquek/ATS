package com.domain.service;

import com.domain.model.Product;
import com.domain.repository.ProductRepository;
import com.domain.repository.ProductRepositoryImpl;

import java.util.ArrayList;

public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepositoryImpl;
    private LoggerService loggerService;

    public ProductServiceImpl() {
        System.out.println("ProductServiceImpl instantiated...");
        productRepositoryImpl = new ProductRepositoryImpl();
        loggerService = new LoggerService();
    }

    public Product getProductObject() {
        return productRepositoryImpl.getProductObject();
    }

    public ArrayList<Product> getProducts() {
        return productRepositoryImpl.getProducts();
    }

    public ArrayList<Product> getProductsFromDB() {
        return productRepositoryImpl.getProductsFromDB();
    }

    public boolean insertProductsIntoDB(Product product) {
        return productRepositoryImpl.insertProductsIntoDB(product);
    }

    public boolean deleteProductsIntoDB(int productID) {
        return productRepositoryImpl.deleteProductsIntoDB(productID);
    }

    public boolean updateProductsIntoDB(Product product) {
        return productRepositoryImpl.updateProductsIntoDB(product);
    }


    public void log() {
        loggerService.logForService();
    }
}

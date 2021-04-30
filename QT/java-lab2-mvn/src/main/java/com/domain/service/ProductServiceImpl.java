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

    @Override
    public Product getProductObject() {
        return productRepositoryImpl.getProductObject();
    }

    @Override
    public ArrayList<Product> getProducts() {
        return productRepositoryImpl.getProducts();
    }

    @Override
    public ArrayList<Product> getProductsFromDB() {
        return productRepositoryImpl.getProductsFromDB();
    }

    @Override
    public boolean insertProductsIntoDB(Product product) {
        return productRepositoryImpl.insertProductsIntoDB(product);
    }

    @Override
    public boolean deleteProductsIntoDB(int productID) {
        return productRepositoryImpl.deleteProductsIntoDB(productID);
    }

    @Override
    public boolean updateProductsIntoDB(Product product) {
        return productRepositoryImpl.updateProductsIntoDB(product);
    }


    public void log() {
        loggerService.logForService();
    }
}

package com.domain.service;

import com.domain.model.Product;

import java.util.ArrayList;

public interface ProductService {
    public Product getProductObject(int productID);
    public ArrayList<Product> getProducts();
    public ArrayList<Product> getProductsFromDB();
    public boolean insertProductsIntoDB(Product product);
    public boolean deleteProductsIntoDB(int productID);
    public boolean updateProductsIntoDB(Product product);
}

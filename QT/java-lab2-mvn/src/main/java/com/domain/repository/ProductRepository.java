package com.domain.repository;

import com.domain.model.Product;

import java.util.ArrayList;

public interface ProductRepository {
    public Product getProductObject();
    public ArrayList<Product> getProducts();
    public ArrayList<Product> getProductsFromDB();
    public boolean insertProductsIntoDB(Product product);
    public boolean deleteProductsIntoDB(int productId);
    public boolean updateProductsIntoDB(Product product);
}

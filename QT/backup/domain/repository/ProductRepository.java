package com.domain.repository;

import java.util.ArrayList;

public interface ProductRepository {
    public Product getProductObject(int productID);
    public ArrayList<Product> getProducts();
    public ArrayList<Product> getProductsFromDB();
    public boolean insertProductsIntoDB(Product product);
    public boolean deleteProductsIntoDB(int productId);
    public boolean updateProductsIntoDB(Product product);
}

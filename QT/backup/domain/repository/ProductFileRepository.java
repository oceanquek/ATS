package com.domain.repository;

import java.util.ArrayList;

public interface ProductFileRepository {
    public abstract ArrayList getProducts();
    public Product getProduct();
    public int insertProduct(Product product);
    public int insertArrayListToFile(ArrayList products);
    public ArrayList<Product> getArrayListFromFile();
    public int updateArrayListToFile(Product product);
    public int deleteProductFromFile(int index);
}

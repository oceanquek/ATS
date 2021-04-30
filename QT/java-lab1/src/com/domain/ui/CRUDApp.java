package com.domain.ui;

import com.domain.model.Product;
import com.domain.repository.ProductFileRepository;
import com.domain.repository.ProductFileRepositoryImpl;
import com.domain.service.ProductService;
import com.domain.service.ProductServiceImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class CRUDApp {

    private static void getProducts() {
        ProductService productService = new ProductServiceImpl();
        ArrayList<Product> products = productService.getProductsFromDB();

        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i));
        }
    }

    private static void saveFiles() {
        ProductService productService = new ProductServiceImpl();
        ArrayList<Product> products = productService.getProductsFromDB();

        File productFile = new File("products.txt");
        try {
            FileOutputStream stream = new FileOutputStream(productFile);
            for (int i = 0;i < products.size();i++) {
                //stream.write();
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }

    }

    private static void insertProduct() {
        Product product = new Product(4, "Gravity Falls", 7.99f);
        ProductService productService = new ProductServiceImpl();
        boolean output = productService.insertProductsIntoDB(product);
        System.out.println(output);
    }

    private static void deleteProducts() {

        ProductService productService = new ProductServiceImpl();
        boolean output = productService.deleteProductsIntoDB(4);
        System.out.println(output);
    }

    private static void updateProducts() {
        Product product = new Product(4, "Gravity Falls", 7.49f);
        ProductService productService = new ProductServiceImpl();
        boolean output = productService.insertProductsIntoDB(product);
        System.out.println(output);
    }

    private static void getProductFromFile() {
        ProductFileRepository productFileRepository = new ProductFileRepositoryImpl();
        Product product = productFileRepository.getProduct();
    }

    public static void main(String[] args) {
        //deleteProducts();
        //getProducts();
        //updateProducts();
        //getProducts();
        //insertProduct();

        //insertArrayListToFile();
        //getArrayListFromFile();
        //updateArrayListToFile();

        getArrayListFromFile();
        updateArrayListToFile();
        getArrayListFromFile();
    }

    private static void deleteProductFromArrayList() {
        ProductFileRepository productFileRepository = new ProductFileRepositoryImpl();
        productFileRepository.deleteProductFromFile(1);
    }

    private static void getArrayListFromFile() {
        ProductFileRepository productFileRepository = new ProductFileRepositoryImpl();
        ArrayList<Product> products = productFileRepository.getArrayListFromFile();

        for (int i = 0;i < products.size();i++) {
            System.out.println(products.get(i));
        }
    }

    private static void insertArrayListToFile() {
        ArrayList products = new ArrayList();
        Product product = new Product(1,"Iron Man",19.99f);
        products.add(product);
        ProductFileRepository productFileRepository = new ProductFileRepositoryImpl();
        productFileRepository.insertArrayListToFile(products);
    }

    private static void updateArrayListToFile() {
        ProductFileRepository productFileRepository = new ProductFileRepositoryImpl();
        Product product = new Product(2,"Friday Night Lights",9.99f);
        productFileRepository.updateArrayListToFile(product);
    }
}

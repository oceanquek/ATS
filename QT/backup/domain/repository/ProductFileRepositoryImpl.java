package com.domain.repository;

import java.io.*;
import java.util.ArrayList;

public class ProductFileRepositoryImpl implements ProductFileRepository {
    @Override
    public ArrayList<Product> getProducts() {
        return null;
    }

    @Override
    public int insertProduct(Product product) {
        int objectSaved = 0;
        File productFile = new File("product.dat");
        try {
            FileOutputStream fileOutputStream =  new FileOutputStream(productFile);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(product);
            objectSaved = 1;
            System.out.println("Saved : " + objectSaved);
            return objectSaved;
        }
        catch (IOException exception) {
            System.out.println(exception);
            objectSaved = 0;
            return objectSaved;
        }
    }

    @Override
    public int insertArrayListToFile(ArrayList products) {
        int objectSaved = 0;
        File productFile = new File("productsList.dat");
        try {
            FileOutputStream fileOutputStream =  new FileOutputStream(productFile);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(products);
            objectSaved = products.size();
            System.out.println("Saved : " + objectSaved);
            return objectSaved;
        }
        catch (IOException exception) {
            System.out.println(exception);
            objectSaved = 0;
            return objectSaved;
        }
    }

    @Override
    public ArrayList<Product> getArrayListFromFile() {
        ArrayList<Product> products = null;
        File productFile = new File("productsList.dat");
        try {
            FileInputStream fileInputStream = new FileInputStream(productFile);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object object = objectInputStream.readObject();
            products = (ArrayList<Product>) object;
        } catch (IOException | ClassNotFoundException exception) {
            System.out.println(exception);
        }
        return products;

    }

    @Override
    public int updateArrayListToFile(Product product) {
        int objectSaved = 0;
        File productFile = new File("productsList.dat");
        ArrayList<Product> products = getArrayListFromFile();
        products.add(product);
        try {
            FileOutputStream fileOutputStream =  new FileOutputStream(productFile);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(products);
            objectSaved = products.size();
            System.out.println("Saved : " + objectSaved);
            return objectSaved;
        }
        catch (IOException exception) {
            System.out.println(exception);
            objectSaved = 0;
            return objectSaved;
        }
    }

    @Override
    public int deleteProductFromFile(int index) {
        int objectSaved = 0;
        File productFile = new File("productsList.dat");
        ArrayList<Product> products = getArrayListFromFile();
        products.remove(index);
        try {
            FileOutputStream fileOutputStream =  new FileOutputStream(productFile);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(products);
            objectSaved = products.size();
            System.out.println("Saved : " + objectSaved);
            return objectSaved;
        }
        catch (IOException exception) {
            System.out.println(exception);
            objectSaved = 0;
            return objectSaved;
        }
    }

    @Override
    public Product getProduct() {
        Product product = null;
        File productFile = new File("product.dat");
        try {
            FileInputStream fileInputStream = new FileInputStream(productFile);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object object = objectInputStream.readObject();
            product = (Product)object;
        } catch (IOException | ClassNotFoundException exception) {
            System.out.println(exception);
        }
        return product;
    }
}

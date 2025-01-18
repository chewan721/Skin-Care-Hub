package com.skincare.controller.datastructure;

import com.skincare.model.ProductModel;
import java.util.List;

public class ArrayList {
    private List<ProductModel> productList;

    public ArrayList() {
        productList = new java.util.ArrayList<>();
    }

    public List<ProductModel> getProductList() {
        return productList;
    }

    public void addProduct(ProductModel product) {
        productList.add(product);
    }

    public void updateProduct(int index, ProductModel product) {
        productList.set(index, product);
    }

    public void removeProduct(int index) {
        productList.remove(index);
    }

    public ProductModel getProduct(int index) {
        return productList.get(index);
    }

    public List<ProductModel> getAllProducts() {
        return new java.util.ArrayList<>(productList);
    }
    
    public boolean isProductIdExists(int productId) {
        for (ProductModel product : productList) {
            if (product.getProductID() == productId) {
                return true;
            }
        }
        return false;
    }
}
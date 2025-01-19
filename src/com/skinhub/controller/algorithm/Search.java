package com.skinhub.controller.algorithm;

import com.skinhub.model.ProductModel;
import java.util.List;

public class Search {

    // Binary search for product name
    public ProductModel searchByName(String searchValue, List<ProductModel> productList, int left, int right) {
        if (right < left) {
            return null;
        }
        int mid = (left + right) / 2;
        if (searchValue.compareToIgnoreCase(productList.get(mid).getProductName()) == 0) {
            return productList.get(mid);
        } else if (searchValue.compareToIgnoreCase(productList.get(mid).getProductName()) < 0) {
            return searchByName(searchValue, productList, left, mid - 1);
        } else {
            return searchByName(searchValue, productList, mid + 1, right);
        }
    }

    // Linear search for product ID
    public ProductModel searchById(int searchValue, List<ProductModel> productList) {
        for (ProductModel product : productList) {
            if (product.getProductID() == searchValue) {
                return product;
            }
        }
        return null;
    }

    // Linear search for product brand
    public ProductModel searchByBrand(String searchValue, List<ProductModel> productList) {
        for (ProductModel product : productList) {
            if (product.getBrand().equalsIgnoreCase(searchValue)) {
                return product;
            }
        }
        return null;
    }

    // Linear search for product category
    public ProductModel searchByCategory(String searchValue, List<ProductModel> productList) {
        for (ProductModel product : productList) {
            if (product.getCategory().equalsIgnoreCase(searchValue)) {
                return product;
            }
        }
        return null;
    }
}
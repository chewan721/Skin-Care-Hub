/**
 * The Search class provides methods to search for products in a list 
 * based on different attributes: name, brand, and category. 
 * It utilizes binary search for names in sorted lists and linear search 
 * for brands and categories in unsorted lists.
 */
package com.skinhub.controller.algorithm;

import com.skinhub.model.ProductModel;
import java.util.List;

public class Search {

    /**
     * Performs a binary search for a product by its name in a sorted list.
     *
     * @param searchValue The name of the product to search for.
     * @param productList The sorted list of products to search within.
     * @param left The starting index of the search range.
     * @param right The ending index of the search range.
     * @return The ProductModel if found, otherwise null.
     */
    public ProductModel searchByName(String searchValue, List<ProductModel> productList, int left, int right) {
        if (right < left) {
            return null; // Base case: value not found
        }
        int mid = (left + right) / 2;
        if (searchValue.compareToIgnoreCase(productList.get(mid).getProductName()) == 0) {
            return productList.get(mid); // Product found
        } else if (searchValue.compareToIgnoreCase(productList.get(mid).getProductName()) < 0) {
            return searchByName(searchValue, productList, left, mid - 1); // Search left half
        } else {
            return searchByName(searchValue, productList, mid + 1, right); // Search right half
        }
    }

    /**
     * Performs a linear search for a product by its brand in an unsorted list.
     *
     * @param searchValue The brand of the product to search for.
     * @param productList The list of products to search within.
     * @return The ProductModel if found, otherwise null.
     */
    public ProductModel searchByBrand(String searchValue, List<ProductModel> productList) {
        for (ProductModel product : productList) {
            if (product.getBrand().equalsIgnoreCase(searchValue)) {
                return product; // Product found
            }
        }
        return null; // Product not found
    }

    /**
     * Performs a linear search for a product by its category in an unsorted list.
     *
     * @param searchValue The category of the product to search for.
     * @param productList The list of products to search within.
     * @return The ProductModel if found, otherwise null.
     */
    public ProductModel searchByCategory(String searchValue, List<ProductModel> productList) {
        for (ProductModel product : productList) {
            if (product.getCategory().equalsIgnoreCase(searchValue)) {
                return product; // Product found
            }
        }
        return null; // Product not found
    }
}
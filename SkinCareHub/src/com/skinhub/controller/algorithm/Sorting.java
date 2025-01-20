/**
 * The Sorting class provides methods to sort a list of ProductModel objects 
 * based on different attributes: product ID, product name, and price. 
 * It implements various sorting algorithms: Selection Sort for product ID, 
 * Insertion Sort for product name, and Merge Sort for price. 
 * The sorting can be done in either ascending or descending order based on 
 * the specified parameter.
 */
package com.skinhub.controller.algorithm;

import com.skinhub.model.ProductModel;
import java.util.ArrayList;
import java.util.List;

public class Sorting {

     /**
     * Sorts a list of ProductModel objects by product ID using Selection Sort.
     *
     * @param unsortedData The list of ProductModel objects to be sorted.
     * @param isDesc If true, sorts in descending order; if false, sorts in ascending order.
     * @return A sorted list of ProductModel objects.
     */
    public List<ProductModel> sortByProductId(List<ProductModel> unsortedData, boolean isDesc) {
        List<ProductModel> dataToSort = new ArrayList<>(unsortedData);

        for (int i = 0; i < dataToSort.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < dataToSort.size(); j++) {
                if (isDesc) {
                    if (dataToSort.get(j).getProductID() > dataToSort.get(minIndex).getProductID()) {
                        minIndex = j;
                    }
                } else {
                    if (dataToSort.get(j).getProductID() < dataToSort.get(minIndex).getProductID()) {
                        minIndex = j;
                    }
                }
            }
            ProductModel temp = dataToSort.get(minIndex);
            dataToSort.set(minIndex, dataToSort.get(i));
            dataToSort.set(i, temp);
        }
        return dataToSort;
    }

    
 /**
     * Sorts a list of ProductModel objects by product name using Insertion Sort.
     * @param unsortedData The list of ProductModel objects to be sorted.
     * @param isDesc If true, sorts in descending order; if false, sorts in ascending order.
     * @return A sorted list of ProductModel objects.
     */
    public List<ProductModel> sortByProductName(List<ProductModel> unsortedData, boolean isDesc) {
        List<ProductModel> dataToSort = new ArrayList<>(unsortedData);

        for (int i = 1; i < dataToSort.size(); i++) {
            ProductModel key = dataToSort.get(i);
            int j = i - 1;

            while (j >= 0 && (isDesc ? dataToSort.get(j).getProductName().compareTo(key.getProductName()) < 0
                                      : dataToSort.get(j).getProductName().compareTo(key.getProductName()) > 0)) {
                dataToSort.set(j + 1, dataToSort.get(j));
                j = j - 1;
            }
            dataToSort.set(j + 1, key);
        }
        return dataToSort;
    }

    /**
     * Sorts a list of ProductModel objects by price using Merge Sort.
     *
     * @param unsortedData The list of ProductModel objects to be sorted.
     * @param isDesc If true, sorts in descending order; if false, sorts in ascending order.
     * @return A sorted list of ProductModel objects.
     */
    public List<ProductModel> sortByPrice(List<ProductModel> unsortedData, boolean isDesc) {
        if (unsortedData.size() <= 1) {
            return unsortedData;
        }

        int mid = unsortedData.size() / 2;
        List<ProductModel> left = new ArrayList<>(unsortedData.subList(0, mid));
        List<ProductModel> right = new ArrayList<>(unsortedData.subList(mid, unsortedData.size()));

        return merge(sortByPrice(left, isDesc), sortByPrice(right, isDesc), isDesc);
    }

    /**
     * Merges two sorted lists of ProductModel objects into one sorted list.
     *
     * @param left The left sorted list.
     * @param right The right sorted list.
     * @param isDesc If true, merges in descending order; if false, merges in ascending order.
     * @return A merged and sorted list of ProductModel objects.
     */
    private List<ProductModel> merge(List<ProductModel> left, List<ProductModel> right, boolean isDesc) {
        List<ProductModel> merged = new ArrayList<>();
        int leftIndex = 0, rightIndex = 0;

        // Merge the two lists based on the desired order
        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (isDesc ? left.get(leftIndex).getPrice() >= right.get(rightIndex).getPrice()
                       : left.get(leftIndex).getPrice() <= right.get(rightIndex).getPrice()) {
                merged.add(left.get(leftIndex++));
            } else {
                merged.add(right.get(rightIndex++));
            }
        }
        // Add any remaining elements from the left list
        while (leftIndex < left.size()) {
            merged.add(left.get(leftIndex++));
        }

        // Add any remaining elements from the right list
        while (rightIndex < right.size()) {
            merged.add(right.get(rightIndex++));
        }

        return merged;
    }
}

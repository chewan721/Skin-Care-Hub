package com.skinhub.controller.algorithm;

import com.skinhub.model.ProductModel;
import java.util.ArrayList;
import java.util.List;

public class Sorting {

    // Selection Sort for productId (integer)
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

    // Insertion Sort for productName (string)
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

    // Merge Sort for price (double)
    public List<ProductModel> sortByPrice(List<ProductModel> unsortedData, boolean isDesc) {
        if (unsortedData.size() <= 1) {
            return unsortedData;
        }

        int mid = unsortedData.size() / 2;
        List<ProductModel> left = new ArrayList<>(unsortedData.subList(0, mid));
        List<ProductModel> right = new ArrayList<>(unsortedData.subList(mid, unsortedData.size()));

        return merge(sortByPrice(left, isDesc), sortByPrice(right, isDesc), isDesc);
    }

    private List<ProductModel> merge(List<ProductModel> left, List<ProductModel> right, boolean isDesc) {
        List<ProductModel> merged = new ArrayList<>();
        int leftIndex = 0, rightIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (isDesc ? left.get(leftIndex).getPrice() >= right.get(rightIndex).getPrice()
                       : left.get(leftIndex).getPrice() <= right.get(rightIndex).getPrice()) {
                merged.add(left.get(leftIndex++));
            } else {
                merged.add(right.get(rightIndex++));
            }
        }

        while (leftIndex < left.size()) {
            merged.add(left.get(leftIndex++));
        }

        while (rightIndex < right.size()) {
            merged.add(right.get(rightIndex++));
        }

        return merged;
    }


}
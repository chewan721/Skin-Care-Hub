package com.skincare.util;

import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 * Utility class for validating product fields.
 */
public class Validation {
    private static final Pattern PRODUCT_PRICE_PATTERN = Pattern.compile("\\d+(\\.\\d{1,2})?");
    private static final Pattern PRODUCT_WEIGHT_PATTERN = Pattern.compile("[1-9]\\d{0,2}");
    private static final Pattern PRODUCT_BRAND_PATTERN = Pattern.compile("[a-zA-Z ]+");
    private static final Pattern PRODUCT_CATEGORY_PATTERN = Pattern.compile("[a-zA-Z ]+");

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static boolean isValidProductId(String productId) {
        return productId.matches("\\d{5}");
    }

    public static boolean isValidProductName(String productName) {
        return productName.matches("[a-zA-Z ]+");
    }

    public static boolean isValidProductPrice(String productPrice) {
        if (isNullOrEmpty(productPrice)) {
            return false;
        }
        try {
            double price = Double.parseDouble(productPrice);
            return price > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isValidProductWeight(String productWeight) {
        return !isNullOrEmpty(productWeight) && PRODUCT_WEIGHT_PATTERN.matcher(productWeight).matches();
    }

    public static boolean isValidProductBrand(String productBrand) {
        return !isNullOrEmpty(productBrand) && PRODUCT_BRAND_PATTERN.matcher(productBrand).matches();
    }

    public static boolean isValidProductCategory(String productCategory) {
        return !isNullOrEmpty(productCategory) && PRODUCT_CATEGORY_PATTERN.matcher(productCategory).matches();
    }

    public static boolean validateProductInput(String productId, String productName, String productPrice, String productWeight, String productBrand, String productCategory) {
        StringBuilder errorMessage = new StringBuilder();

        // Check for empty fields
        if (isNullOrEmpty(productId) || isNullOrEmpty(productName) || isNullOrEmpty(productPrice) || isNullOrEmpty(productWeight) || isNullOrEmpty(productBrand) || isNullOrEmpty(productCategory)) {
            JOptionPane.showMessageDialog(null, "Please fill in all the fields.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        // Detailed validation
        if (!isValidProductId(productId)) {
            errorMessage.append("Invalid Product ID. It should be exactly 5 digits.\n");
        }
        if (!isValidProductName(productName)) {
            errorMessage.append("Invalid Product Name. It should contain only alphabets and spaces.\n");
        }
        if (!isValidProductPrice(productPrice)) {
            errorMessage.append("Invalid Product Price. It should be a positive number greater than zero.\n");
        }
        if (!isValidProductWeight(productWeight)) {
            errorMessage.append("Invalid Product Weight. It should be between 1 and 999 and should not start with zero.\n");
        }
        if (!isValidProductBrand(productBrand)) {
            errorMessage.append("Invalid Product Brand. It should contain only alphabets and spaces.\n");
        }
        if (!isValidProductCategory(productCategory)) {
            errorMessage.append("Invalid Product Category. It should contain only alphabets and spaces.\n");
        }

        if (errorMessage.length() > 0) {
            JOptionPane.showMessageDialog(null, errorMessage.toString(), "Validation Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }
}
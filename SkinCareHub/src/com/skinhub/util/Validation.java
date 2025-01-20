package com.skinhub.util;

import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 * Utility class for validating product fields.
 * This class provides various static methods to validate different attributes of a product,
 * such as product ID, product name, product price, product weight, product brand, and product category.
 */
public class Validation {
    // Regular expression pattern for validating product price (e.g., 12.34)
    private static final Pattern PRODUCT_PRICE_PATTERN = Pattern.compile("\\d+(\\.\\d{1,2})?");
    
    // Regular expression pattern for validating product weight (e.g., 100)
    private static final Pattern PRODUCT_WEIGHT_PATTERN = Pattern.compile("[1-9]\\d{0,2}");
    
    // Regular expression pattern for validating product brand (e.g., "BrandName")
    private static final Pattern PRODUCT_BRAND_PATTERN = Pattern.compile("[a-zA-Z ]+");
    
    // Regular expression pattern for validating product category (e.g., "CategoryName")
    private static final Pattern PRODUCT_CATEGORY_PATTERN = Pattern.compile("[a-zA-Z ]+");

    /**
     * Checks if a string is null or empty.
     * 
     * @param str the string to check
     * @return true if the string is null or empty, false otherwise
     */
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    /**
     * Validates the product ID.
     * 
     * @param productId the product ID to validate
     * @return true if the product ID is valid (5 digits), false otherwise
     */
    public static boolean isValidProductId(String productId) {
        return productId.matches("\\d{5}");
    }

    /**
     * Validates the product name.
     * 
     * @param productName the product name to validate
     * @return true if the product name is valid (only letters and spaces), false otherwise
     */
    public static boolean isValidProductName(String productName) {
        return productName.matches("[a-zA-Z ]+");
    }

    /**
     * Validates the product price.
     * 
     * @param productPrice the product price to validate
     * @return true if the product price is valid (positive number), false otherwise
     */
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

    /**
     * Validates the product weight.
     * 
     * @param productWeight the product weight to validate
     * @return true if the product weight is valid (matches the pattern), false otherwise
     */
    public static boolean isValidProductWeight(String productWeight) {
        return !isNullOrEmpty(productWeight) && PRODUCT_WEIGHT_PATTERN.matcher(productWeight).matches();
    }

    /**
     * Validates the product brand.
     * 
     * @param productBrand the product brand to validate
     * @return true if the product brand is valid (only letters and spaces), false otherwise
     */
    public static boolean isValidProductBrand(String productBrand) {
        return !isNullOrEmpty(productBrand) && PRODUCT_BRAND_PATTERN.matcher(productBrand).matches();
    }

    /**
     * Validates the product category.
     * 
     * @param productCategory the product category to validate
     * @return true if the product category is valid (only letters and spaces), false otherwise
     */
    public static boolean isValidProductCategory(String productCategory) {
        return !isNullOrEmpty(productCategory) && PRODUCT_CATEGORY_PATTERN.matcher(productCategory).matches();
    }

    /**
     * Validates all product input fields.
     * 
     * @param productId the product ID to validate
     * @param productName the product name to validate
     * @param productPrice the product price to validate
     * @param productWeight the product weight to validate
     * @param productBrand the product brand to validate
     * @param productCategory the product category to validate
     * @return true if all fields are valid, false otherwise
     */
    public static boolean validateProductInput(String productId, String productName, String productPrice, String productWeight, String productBrand, String productCategory) {
        StringBuilder errorMessage = new StringBuilder();
        // Check for empty fields
        if (isNullOrEmpty(productId) || isNullOrEmpty(productName) || isNullOrEmpty(productPrice) || isNullOrEmpty(productWeight) || isNullOrEmpty(productBrand) || 
            isNullOrEmpty(productCategory)) {
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
            errorMessage.append("Invalid Product Weight. It should be a positive number.\n");
        }
        if (!isValidProductBrand(productBrand)) {
            errorMessage.append("Invalid Product Brand. It should contain only alphabets and spaces.\n");
        }
        if (!isValidProductCategory(productCategory)) {
            errorMessage.append("Invalid Product Category. It should contain only alphabets and spaces.\n");
        }

        // Show error message if any validation fails
        if (errorMessage.length() > 0) {
            JOptionPane.showMessageDialog(null, errorMessage.toString(), "Validation Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
}
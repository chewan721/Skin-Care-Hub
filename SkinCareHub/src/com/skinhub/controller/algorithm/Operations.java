/**
 * The Operations class provides methods to perform various operations on a JTable, 
 * such as adding, getting, updating, deleting, and loading products.
 * It uses the DefaultTableModel to interact with the JTable.
 */
package com.skinhub.controller.algorithm;

import com.skinhub.model.ProductModel;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * @author DeLL
 */
public class Operations {

    /**
     * Adds a new product to the JTable.
     * 
     * @param table The JTable to add the product to.
     * @param product The ProductModel to add.
     */
    public void addProduct(JTable table, ProductModel product) {
        // Get the DefaultTableModel from the JTable
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        
        // Add a new row to the model with the product's data
        model.addRow(new Object[]{
            product.getProductID(), // Product ID
            product.getProductName(), // Product Name
            product.getPrice(), // Price
            product.getBrand(), // Brand
            product.getWeight(), // Weight
            product.getCategory() // Category
        });
    }

    /**
     * Gets a product from the JTable at the specified row index.
     * 
     * @param table The JTable to get the product from.
     * @param rowIndex The row index of the product to get.
     * @return The ProductModel at the specified row index.
     */
    public ProductModel getProduct(JTable table, int rowIndex) {
        // Get the DefaultTableModel from the JTable
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        
        // Create a new ProductModel with the data from the specified row
        return new ProductModel(
            (int) model.getValueAt(rowIndex, 0), // Product ID
            (String) model.getValueAt(rowIndex, 1), // Product Name
            (double) model.getValueAt(rowIndex, 2), // Price
            (String) model.getValueAt(rowIndex, 3), // Brand
            (short) model.getValueAt(rowIndex, 4), // Weight
            (String) model.getValueAt(rowIndex, 5) // Category
        );
    }

    /**
     * Updates a product in the JTable at the specified row index.
     * 
     * @param table The JTable to update the product in.
     * @param rowIndex The row index of the product to update.
     * @param product The ProductModel to update with.
     */
    public void updateProduct(JTable table, int rowIndex, ProductModel product) {
        // Get the DefaultTableModel from the JTable
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        
        // Update the values in the model at the specified row
        model.setValueAt(product.getProductID(), rowIndex, 0); // Product ID
        model.setValueAt(product.getProductName(), rowIndex, 1); // Product Name
        model.setValueAt(product.getPrice(), rowIndex, 2); // Price
        model.setValueAt(product.getBrand(), rowIndex, 3); // Brand
        model.setValueAt(product.getWeight(), rowIndex, 4); // Weight
        model.setValueAt(product.getCategory(), rowIndex, 5); // Category
    }

    /**
     * Deletes a product from the JTable at the specified row index.
     * 
     * @param table The JTable to delete the product from.
     * @param rowIndex The row index of the product to delete.
     */
    public void deleteProduct(JTable table, int rowIndex) {
        // Get the DefaultTableModel from the JTable
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        
        // Remove the row at the specified index from the model
        model.removeRow(rowIndex);
    }

    /**
     * Loads a list of products into the JTable.
     * 
     * @param table The JTable to load the products into.
     * @param products The list of ProductModel to load.
     */
    public void loadProducts(JTable table, List<ProductModel> products) {
        // Get the DefaultTableModel from the JTable
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        
        // Clear any existing rows in the model
        model.setRowCount(0);
        
        // Add each product in the list to the model
        for (ProductModel product : products) {
            model.addRow(new Object[]{
                product.getProductID(), // Product ID
                product.getProductName(), // Product Name
                product.getPrice(), // Price
                product.getBrand(), // Brand
                product.getWeight(), // Weight
                product.getCategory() // Category
            });
        }
    }
}
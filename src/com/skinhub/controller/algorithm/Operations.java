
package com.skinhub.controller.algorithm;

import com.skinhub.model.ProductModel;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DeLL
 */
public class Operations {


    public void addProduct(JTable table, ProductModel product) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.addRow(new Object[]{
            product.getProductID(),
            product.getProductName(),
            product.getPrice(),
            product.getBrand(),
            product.getWeight(),
            product.getCategory()
        });
    }

    public ProductModel getProduct(JTable table, int rowIndex) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        return new ProductModel(
            (int) model.getValueAt(rowIndex, 0),
            (String) model.getValueAt(rowIndex, 1),
            (double) model.getValueAt(rowIndex, 2),
            (String) model.getValueAt(rowIndex, 3),
            (short) model.getValueAt(rowIndex, 4),
            (String) model.getValueAt(rowIndex, 5)
        );
    }

    public void updateProduct(JTable table, int rowIndex, ProductModel product) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setValueAt(product.getProductID(), rowIndex, 0);
        model.setValueAt(product.getProductName(), rowIndex, 1);
        model.setValueAt(product.getPrice(), rowIndex, 2);
        model.setValueAt(product.getBrand(), rowIndex, 3);
        model.setValueAt(product.getWeight(), rowIndex, 4);
        model.setValueAt(product.getCategory(), rowIndex, 5);
    }

    public void deleteProduct(JTable table, int rowIndex) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.removeRow(rowIndex);
    }

    public void loadProducts(JTable table, List<ProductModel> products) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear existing rows
        for (ProductModel product : products) {
            model.addRow(new Object[]{
                product.getProductID(),
                product.getProductName(),
                product.getPrice(),
                product.getBrand(),
                product.getWeight(),
                product.getCategory()
            });
        }
    }
    

}

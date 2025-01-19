/* 
 * 
 */
package com.skinhub.model;

/**
 *
 * @author Chewan Regmi
 */
public class ProductModel {
    private String productName; // it gives the name of the product
    private int productID; // it gives the id of the product which helps to identify each product uniquely.
    private String brand; //gives the manufacturer of the product
    private double price; 
    private short weight; // weight is in gram for sunscreen and mositurizer while it is in ml for other categories
    private String category;
    
   public ProductModel(){ // default constructor for productmodel class/
       
   }
   
   
   //
    public ProductModel(int productID, String productName, double price, String brand, short weight, String category){
        this.productName = productName ;
        this.productID = productID;
        this.brand = brand;
        this.price = price;
        this.weight = weight;
        this.category = category;

   }

    /**
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return the productID
     */
    public int getProductID() {
        return productID;
    }

    /**
     * @param productID the productID to set
     */
    public void setProductID(int productID) {
        this.productID = productID;
    }

    /**
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @param brand the brand to set
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the weight
     */
    public short getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(short weight) {
        this.weight = weight;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }
   
   
   
}

package ru.clevertec.check.model;

public class Product {

    private int idProduct;
    private String description;
    private float price;
    private int quantityInStock;
    private boolean isWholesale;


    public Product(int idProduct, String description, float price, int quantityInStock, boolean isWholesale) {
        this.idProduct = idProduct;
        this.description = description;
        this.price = price;
        this.quantityInStock = quantityInStock;
        this.isWholesale = isWholesale;
    }


    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public boolean isWholesale() {
        return isWholesale;
    }

    public void setWholesale(boolean wholesale) {
        isWholesale = wholesale;
    }

    @Override
    public String toString() {
        return idProduct + " " + description  + " " + price + " " + quantityInStock + " " + isWholesale;
    }
}

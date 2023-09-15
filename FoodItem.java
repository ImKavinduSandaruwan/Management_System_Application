package com.example.mealorder;

public class FoodItem {
    private String itemName;
    private double price;
    private String size;
    private String type;

    public FoodItem(String type, String itemName, double price){
        this.type = type.toUpperCase();
        this.itemName = itemName.toUpperCase();
        this.price = price;
        size = "MEDIUM";
    }

    public double getBasePrice() {
        return price;
    }

    public double getAdjustedPrice(){
        return switch (size){
          case "SMALL" -> getBasePrice() - 0.5;
          case "LARGE" -> getBasePrice() + 1.0;
          default -> getBasePrice();
        };
    }

    public void setSize(String size) {
        this.size = size.toUpperCase();
    }

    public void printItem(){
        System.out.printf("%30s:  $%6.2f%n",getItemName(),getAdjustedPrice());
    }

    public String getItemName() {
        if(type.equals("DRINK") || type.equals("SIDE")) return size + " " + itemName;
        return itemName;
    }
}

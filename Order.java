package com.example.mealorder;

public class Order {
    private FoodItem drink;
    private FoodItem sideItem;
    private Burger burger;

    public Order(){
        this("REGULAR", "COKE", "FRIES");
    }

    public Order(String burger, String drink, String side){
        this.burger = new Burger(burger, 4);
        this.drink = new FoodItem("DRINK", drink, 2.2);
        this.sideItem = new FoodItem("SIDE", side, 3.5);
    }

    public void changeDrinkSize(String newSize){
        drink.setSize(newSize);
    }

    public void addToppings(String extra1, String extra2, String extra3){
        burger.addToppings(extra1, extra2, extra3);
    }

    private double getTotalPrice(){
        return burger.getAdjustedPrice() + drink.getAdjustedPrice() + sideItem.getAdjustedPrice();
    }

    public void printItemizedList(){
        drink.printItem();
        sideItem.printItem();
        burger.printItem();
        System.out.printf("%30s:  $%6.2f%n","TOTAL PRICE",getTotalPrice());
    }
}

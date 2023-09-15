package com.example.mealorder;

public class Burger extends FoodItem{
    private FoodItem extraOne;
    private FoodItem extraTwo;
    private FoodItem extraThree;

    public Burger(String itemName, double price) {
        super("BURGER", itemName, price);
    }

    @Override
    public String getItemName() {
        return super.getItemName() + " BURGER";
    }

    public double getToppingPrice(String toppingName){
        return switch (toppingName.toUpperCase()){
          case "JAM", "AVOCADO", "CHILI" -> 2.5;
          case "MAYO", "HAM", "CHEESE" -> 3.0;
            default -> 0.2;
        };
    }

    public void addToppings(String extra1, String extra2, String extra3){
        this.extraOne = new FoodItem("TOPPING", extra1, getToppingPrice(extra1));
        this.extraTwo = new FoodItem("TOPPING", extra2, getToppingPrice(extra2));
        this.extraThree = new FoodItem("TOPPING", extra3, getToppingPrice(extra3));
    }

    @Override
    public double getAdjustedPrice() {
        return super.getAdjustedPrice() +
                ((extraOne != null) ? extraOne.getBasePrice() : 0) +
                ((extraTwo != null) ? extraTwo.getBasePrice() : 0) +
                ((extraThree != null) ? extraThree.getBasePrice() : 0);
    }

    @Override
    public void printItem() {
        System.out.printf("%30s:  $%6.2f%n",getItemName(),getBasePrice());
        System.out.println(" ".repeat(10) + "-".repeat(35));
        if(extraOne != null && extraTwo != null && extraThree != null){
            System.out.printf("%18s%n","TOPPINGS");
            extraOne.printItem();
            extraTwo.printItem();
            extraThree.printItem();
            System.out.println(" ".repeat(10) + "-".repeat(35));
        }

    }
}

package com.example.mealorder;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static String customize;

    public static void main(String[] args) {
        boolean shouldContinue = true;
        while (shouldContinue) {
            System.out.println("""  
                     --------------------------------------------------------------------              
                    |                    WELCOME TO THE MEAL KING                        | 
                    |                                                                    |
                    |      AVAILABLE ITEMS: ALL KIND OF BURGERS, DRINKS AND SIDE ITEMS   |
                    |      AVAILABLE TOPPINGS:  HAM,JAM,CHEESE,MAYO,CHILI,AVOCADO        |
                     ---------------------------------------------------------------------""");
            System.out.print("""
                    Press 0 to Order Common Meal or\s
                    Press 1 to Order Custom Meal or\s
                    Press 9 to exit:\s""");
            String choice = scanner.nextLine();

            if (choice.equals("0")) {
                Order commonMeal = new Order();
                addToppingAndChangeDrink(commonMeal);
            } else if (choice.equals("1")) {
                System.out.print("Enter Burger Type: ");
                String burger = scanner.nextLine();
                System.out.print("Enter Drink Type: ");
                String drink = scanner.nextLine();
                System.out.print("Enter Side Item Type: ");
                String sideItem = scanner.nextLine();
                Order order = new Order(burger, drink, sideItem);
                addToppingAndChangeDrink(order);
            }else {
                shouldContinue = false;
                System.out.println("Thank you for using our application\n");
            }
        }
    }
    public static void addToppingAndChangeDrink(Order meal){
        System.out.print("""
                
                Press 2 to Add Toppings
                Press 3 to Change Drink size
                Else Press 4: """);
        customize = scanner.nextLine();
        switch (customize) {
            case "2":
                System.out.print("Enter 3 Toppings seperated by a comma: ");
                String[] toppingList = scanner.nextLine().split(",");
                meal.addToppings(toppingList[0], toppingList[1], toppingList[2]);
            case "3":
                System.out.print("Change Drink Size: ");
                String size = scanner.nextLine();
                meal.changeDrinkSize(size);
            default:
                System.out.println();
        }
        meal.printItemizedList();
    }
}

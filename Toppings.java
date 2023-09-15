package com.example.mealorder;

public enum Toppings {
    HAM,JAM,CHEESE,MAYO,CHILI,AVOCADO;

    public double getToppingPrice(){
        return switch (this){
            case HAM, JAM, CHEESE -> 1.0;
            case MAYO, CHILI, AVOCADO -> 2.4;
        };
    }

    public String getToppingName(){
        return switch (this){
            case HAM -> "HAM";
            case JAM -> "JAM";
            case CHEESE -> "CHEESE";
            case MAYO -> "MAYO";
            case CHILI -> "CHILI";
            case AVOCADO -> "AVOCADO";
        };
    }
}

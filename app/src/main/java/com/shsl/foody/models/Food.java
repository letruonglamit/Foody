package com.shsl.foody;

public class Food {

    String name;
    int number;
    int cost;

    Food(String name, int number, int cost) {
        this.name = name;
        this.number = number;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public int getCost() {
        return cost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}

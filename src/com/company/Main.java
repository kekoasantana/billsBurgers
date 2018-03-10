package com.company;

/**
 * create basic hamburger class
 * class should contain bread type, meat, and up to 4 additional additions
 * each item should have a price
 * keep track of added items and calculate final price
 * constructor with bread roll type, meat, price
 * use setters for additional items
 * use switch statement for additional items
 * if statement to make sure they are valid
 *
 * create subclass for healthy burger which only is on brown rye bread
 * healthy burger can have 6 items total
 *
 * another subclass for deluxe burgers
 * comes with fries and drink but no other additions
 *
 * each class should have method that shows base price of burger, addition names, addition prices, and final price
 */

class BaseBurger {
    private String name;
    private String breadType;
    private String meat;
    private double price;

    private String addition1Name;
    private double addition1Price;

    private String addition2Name;
    private double addition2Price;

    private String addition3Name;
    private double addition3Price;

    private String addition4Name;
    private double addition4Price;

    public BaseBurger(String name, String breadType, String meat, double price) {
        this.name = name;
        this.breadType = breadType;
        this.meat = meat;
        this.price = price;
    }

    public void addHamburgerAddition1(String name, double price) {
        this.addition1Name = name;
        this.addition1Price = price;
    }

    public void addHamburgerAddition2(String name, double price) {
        this.addition2Name = name;
        this.addition2Price = price;
    }

    public void addHamburgerAddition3(String name, double price) {
        this.addition3Name = name;
        this.addition3Price = price;
    }

    public void addHamburgerAddition4(String name, double price) {
        this.addition4Name = name;
        this.addition4Price = price;
    }

    public double itemizeHamburger() {
        double hamburgerPrice = this.price;
        System.out.printf("%s on a %s is $%.2f\n", this.name, this.breadType, this.price);
        if (this.addition1Name != null) {
            hamburgerPrice += this.addition1Price;
            System.out.printf("%s was added for an extra $%.2f\n", this.addition1Name, this.addition1Price);
        }
        if (this.addition2Name != null) {
            hamburgerPrice += this.addition2Price;
            System.out.printf("%s was added for an extra $%.2f\n", this.addition2Name, this.addition2Price);
        }
        if (this.addition3Name != null) {
            hamburgerPrice += this.addition3Price;
            System.out.printf("%s was added for an extra $%.2f\n", this.addition3Name, this.addition3Price);
        }
        if (this.addition4Name != null) {
            hamburgerPrice += this.addition4Price;
            System.out.printf("%s was added for an extra $%.2f\n", this.addition4Name, this.addition4Price);
        }
        return hamburgerPrice;
    }
}

class HealthyBurger extends BaseBurger {
    private String healthyAddition1Name;
    private double healthyAddition1Price;

    private String healthyAddition2Name;
    private double healthyAddition2Price;

    public HealthyBurger(String meat, double price) {
        super("Healthy Burger", "Brown Rye", meat, price);
    }

    public void addHealthyAddition1(String name, double price) {
        this.healthyAddition1Name = name;
        this.healthyAddition1Price = price;
    }

    public void addHealthyAddition2(String name, double price) {
        this.healthyAddition2Name = name;
        this.healthyAddition2Price = price;
    }

    @Override
    public double itemizeHamburger() {
        double hamburgerPrice = super.itemizeHamburger();
        if (this.healthyAddition1Name != null) {
            hamburgerPrice += this.healthyAddition1Price;
            System.out.printf("%s was added for an extra $%.2f\n", this.healthyAddition1Name, this.healthyAddition1Price);
        }
        if (this.healthyAddition2Name != null) {
            hamburgerPrice += this.healthyAddition2Price;
            System.out.printf("%s was added for an extra $%.2f\n", this.healthyAddition2Name, this.healthyAddition2Price);
        }
        return hamburgerPrice;
    }
}

class DeluxeBurger extends BaseBurger {
    private String deluxeBurgerAddition1;
    private String deluxeBurgerAddition2;

    public DeluxeBurger() {
        super("Deluxe Burger", "White", "Beef and Bacon", 14.75);
        super.addHamburgerAddition1("Fries", 3.50);
        super.addHamburgerAddition2("Drink", 1.00);
    }

    @Override
    public void addHamburgerAddition1(String name, double price) {
        System.out.println("Cannot add additional items to a deluxe burger.");
    }

    @Override
    public void addHamburgerAddition2(String name, double price) {
        System.out.println("Cannot add additional items to a deluxe burger.");    }

    @Override
    public void addHamburgerAddition3(String name, double price) {
        System.out.println("Cannot add additional items to a deluxe burger.");    }

    @Override
    public void addHamburgerAddition4(String name, double price) {
        System.out.println("Cannot add additional items to a deluxe burger.");    }
}

public class Main {

    public static void main(String[] args) {
        BaseBurger burger = new BaseBurger("Burger", "White", "Beef", 7.50);
        burger.addHamburgerAddition1("Lettuce", 1.00);
        burger.addHamburgerAddition2("Tomatoes", 1.00);
        burger.addHamburgerAddition3("Fries", 3.50);

        System.out.printf("Total: %.2f\n", burger.itemizeHamburger());

        HealthyBurger healthyBurger = new HealthyBurger("Veggie", 6.75);
        healthyBurger.addHamburgerAddition1("Cheese", 1.75);
        healthyBurger.addHamburgerAddition2("Lettuce", 0.50);
        healthyBurger.addHamburgerAddition3("Fries", 2.50);
        healthyBurger.addHamburgerAddition4("Coca Cola", 0.75);
        healthyBurger.addHealthyAddition1("Tomatoes", 0.50);

        System.out.printf("Total: %.2f\n", healthyBurger.itemizeHamburger());

        DeluxeBurger db = new DeluxeBurger();
        db.addHamburgerAddition1("Chips", 4.50);
        System.out.printf("Total: %.2f\n", db.itemizeHamburger());
    }
}

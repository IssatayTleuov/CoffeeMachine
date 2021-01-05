package com.company;

import java.util.Scanner;

public class Main {

    public static int water = 400, milk = 540, coffeeBeans = 120, cups = 9, money = 550;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write action (buy, fill, take, remaining, exit)");
        String action = scanner.next();
        System.out.println();
        while (!action.equals("exit")){
            switch (action) {
                case "buy":
                    buyCoffee();
                    break;
                case "fill":
                    fillMachine();
                    break;
                case "take":
                    takeMoney();
                    break;
                case "remaining":
                    System.out.println("The coffee machine has:\n" +
                            water + " " + "of water \n" +
                            milk + " " + "of milk \n" +
                            coffeeBeans + " " + "of coffee beans\n" +
                            cups + " " + "of disposable cups\n" +
                            money + " " + "of money\n");
                    break;
                default:
                    System.out.println("No action like this");
                    break;
            }
            System.out.println("Write action (buy, fill, take, remaining, exit)");
            action = scanner.next();
            System.out.println();
        }
    }

    public static void buyCoffee() {
        int espWater = 250, espMilk = 0, espBeans = 16, espMoney = 4;
        int latWater = 350, latMilk = 75, latBeans = 20, latMoney = 7;
        int capWater = 200, capMilk = 100, capBeans = 12, capMoney = 6;

        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String coffeeType = scanner.nextLine();

        switch (coffeeType) {
            case "1":
                String esp = checkResources(espWater, water, espMilk, milk, espBeans, coffeeBeans);
                boolean espResult = esp.contains("Sorry");
                System.out.println(esp);
                System.out.println();
                if (!espResult) {
                    water = water - espWater;
                    coffeeBeans = coffeeBeans - espBeans;
                    money = money + espMoney;
                    cups = cups - 1;
                }
                break;
            case "2":
                String lat = checkResources(latWater, water, latMilk, milk, latBeans, coffeeBeans);
                boolean latResult = lat.contains("Sorry");
                System.out.println(lat);
                System.out.println();
                if (!latResult) {
                    water = water - latWater;
                    milk = milk - latMilk;
                    coffeeBeans = coffeeBeans - latBeans;
                    money = money + latMoney;
                    cups = cups - 1;
                }
                break;
            case "3":
                String cap = checkResources(capWater, water, capMilk, milk, capBeans, coffeeBeans);
                boolean capResult = cap.contains("Sorry");
                System.out.println(cap);
                System.out.println();
                if (!capResult) {
                    water = water - capWater;
                    milk = milk - capMilk;
                    coffeeBeans = coffeeBeans - capBeans;
                    money = money + capMoney;
                    cups = cups - 1;
                }
                break;
            case "back":
                System.out.println();
                break;
            default:
                System.out.println("We don't have this coffee");
                System.out.println();
                break;
        }
    }

    public static void fillMachine() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water do you want to add:");
        int fillWater = scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        int fillMilk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        int fillBeans = scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        int fillCups = scanner.nextInt();
        System.out.println();

        water = water + fillWater;
        milk = milk + fillMilk;
        coffeeBeans = coffeeBeans + fillBeans;
        cups = cups + fillCups;
    }

    public static void takeMoney() {
        System.out.println("I gave you $" + money);
        System.out.println();
        money = 0;
    }

    public static String checkResources(int needWater, int currentWater, int needMilk, int currentMilk, int needBeans, int currentBeans) {
        String result;
        if (needWater > currentWater) {
            result = "Sorry, not enough water!";
        } else if (needMilk > currentMilk) {
            result = "Sorry, not enough milk!";
        } else if (needBeans > currentBeans) {
            result = "Sorry, not enough beans!";
        } else {
            result = "I have enough resources, making you a coffee!";
        }
        return result;
    }
}

package machine;

import java.util.Scanner;
public class CoffeeMachine {
    private static int waterQuantity = 400;
    private static int milkQuantity = 540;
    private static int beansQuantity = 120;
    private static int cups = 9;
    private static int money = 550;
    private static Scanner in = new Scanner(System.in);
    private static void print() {
        System.out.println("The coffee machine has:");
        System.out.println(waterQuantity + " of water");
        System.out.println(milkQuantity + " of milk");
        System.out.println(beansQuantity +  " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
    }
    private static void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String line = null;
        if (in.hasNextLine()) {
            line = in.nextLine();
            if (line.equals("back")) {
                return;
            }
        }
        if (line != null) {
            switch (Integer.parseInt(line)) {
                case 1:
                    if (waterQuantity < 250) {
                        System.out.println("Sorry, not enough water!");
                    } else if (beansQuantity < 16) {
                        System.out.println("Sorry, not enough beans!");
                    } else if (cups <= 0) {
                        System.out.println("Sorry, not enough cups");
                    } else {
                        System.out.println("I have enough resources, making you a coffee!");
                        waterQuantity -= 250;
                        beansQuantity -= 16;
                        cups -= 1;
                        money += 4;
                    }
                    break;
                case 2:
                    if (waterQuantity < 350) {
                        System.out.println("Sorry, not enough water!");
                    } else if (milkQuantity < 75) {
                        System.out.println("Sorry, not enough milk!");
                    } else if (beansQuantity < 20) {
                        System.out.println("Sorry, not enough beans!");
                    } else if (cups <= 0) {
                        System.out.println("Sorry, not enough cups");
                    } else {
                        System.out.println("I have enough resources, making you a coffee!");
                        waterQuantity -= 350;
                        milkQuantity -= 75;
                        beansQuantity -= 20;
                        cups -= 1;
                        money += 7;
                    }
                    break;
                case 3:
                    if (waterQuantity < 200) {
                        System.out.println("Sorry, not enough water!");
                    } else if (milkQuantity < 100) {
                        System.out.println("Sorry, not enough milk!");
                    } else if (beansQuantity < 12) {
                        System.out.println("Sorry, not enough beans!");
                    } else if (cups <= 0) {
                        System.out.println("Sorry, not enough cups");
                    } else {
                        System.out.println("I have enough resources, making you a coffee!");
                        waterQuantity -= 200;
                        milkQuantity -= 100;
                        beansQuantity -= 12;
                        cups -= 1;
                        money += 6;
                    }
                    break;
                default:
                    break;
            }
        }
    }
    private static void fill() {
        System.out.println("Write how many ml of water do you want to add: ");
        waterQuantity += in.nextInt();
        System.out.println("Write how many ml of milk do you want to add: ");
        milkQuantity += in.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        beansQuantity += in.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        cups += in.nextInt();
    }
    private static void take() {
        System.out.println("I gave you $" + money);
        money = 0;
    }
    public static void main(String[] args) {
        boolean exited = false;
        while (!exited) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String option = in.nextLine();
            switch (option) {
                case "buy":
                    buy();
                    break;
                case "fill":
                    fill();
                    break;
                case "take":
                    take();
                    break;
                case "remaining":
                    print();
                    break;
                case "exit":
                    exited = true;
                    break;
                default:
                    break;
            }
        }
    }
}

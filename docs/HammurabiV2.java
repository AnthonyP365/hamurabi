package hammurabi.docs;
import java.util.Scanner;
import java.util.Random;

public class HammurabiV2 {
    Random  random;
    Scanner scanner;
    int totalDeaths;
    int percentDied;
    int year;
    int landPrice;
    int storage;
    int harvest;
    int yield;
    int acres;
    int population;
    int immigrants;
    int eaten;
    int fullPeople;
    int userInput;


    public HammurabiV2() {
        year = 0;
        landPrice = 19;
        storage = 2800;
        harvest = 3000;
        yield = 3;
        acres = harvest / yield;
        population = 100;
        scanner = new Scanner(System.in);
        random = new Random();
    }


    public static void main(String[] args) {
        new HammurabiV2().playGame();
    }

    public void playGame() {

        for (int i = 0; i < 3; i++) {
            newYear();
            printSummary();
            System.out.println("\n");

            if (askToBuyOrSell() == 1) {
                askHowManyAcresToBuy();
                System.out.println("Current bushels storage: " + storage + "\n" +
                "Current acres: " + acres + "\n");
            } else {
                askHowManyAcresToSell();
                System.out.println("Current bushels storage: " + storage + "\n" +
                        "Current acres: " + acres + "\n");
            }

            askHowMuchGrainToFeedPeople();

            newHarvest(askHowManyAcresToPlant());
            System.out.println("Current storage: " + storage);

        }
    }

    public void newYear() {
        year += 1;
        for (int i = year; i >= 2; i++) {
            newYield();
            newLandPrice();
        }
    }

    public void printSummary() {
        System.out.println("O great Hammurabi!\n" +
                "You are in year " + year + " of your ten year rule.\n" +
                "The  population is now " + population + ".\n" +
                "We have " + storage + " bushels in storage.\n" +
                "The city owns " + acres + " acres of land.\n" +
                "Land is currently worth " + landPrice + " bushels per acre.");
    }

    public int askToBuyOrSell() {
        int choice;

        do {
            System.out.println("Hammurabi: Which would you like to do this year?\n" +
                    "Enter 1: Buy acres\n" +
                    "Enter 2: Sell acres");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("You have chosen to buy!");
                    System.out.println("\n");
                    return choice;

                case 2:
                    System.out.println("You have chosen to sell!");
                    System.out.println("\n");
                    return choice;

                default:
                    System.out.println("Invalid input.\n" +
                            "Please select either 1 or 2.\n");
                    break;
            }
        } while (choice != 1 && choice !=2);

        return choice;
    }

    public void askHowManyAcresToBuy() {
        do {
            System.out.println("How many acres would you like to buy?");
            userInput = scanner.nextInt();

            if (userInput < 0) {
                System.out.println("error");
            } else if (userInput * landPrice > storage) {
                System.out.println("Hammurabi: You have only\n" + storage + " bushels.");
            }
        } while (userInput * landPrice > storage);

        acres += userInput;
        storage -= userInput * landPrice;
    }

    public void askHowManyAcresToSell() {
        do {
            System.out.println("How many acres would you like to sell?");
            userInput = scanner.nextInt();

            if (userInput < 0) {
                System.out.println("error");
            } else if (userInput > acres) {
                System.out.println("Hammurabi: You have only\n" + acres + " acres.");
            }
        } while (userInput > acres);

        acres -= userInput;
        storage += userInput * landPrice;
    }

    public void askHowMuchGrainToFeedPeople() {
        do {
            System.out.println("How many bushels would you like to feed your people?");
            userInput = scanner.nextInt();

            if (userInput < 0) {
                System.out.println("error");
            } else if (userInput > storage) {
                System.out.println("Hammurabi: You have only\n" + storage + " bushels.");
            }
        } while (userInput > storage);

        fullPeople = userInput / 20;
        storage -= userInput;
        System.out.println("Storage after grain feed: " + storage + "\n");
    }

    public int askHowManyAcresToPlant() {
        int choice;

        do {
            System.out.println("How many acres would you like to plant with seed?");
            choice = scanner.nextInt();

            if (choice < 0) {
                System.out.println("error");
            } else if (choice > acres) {
                System.out.println("Hammurabi: You have only\n" + acres + " acres.");
            } else if (choice > storage / 2) {
                System.out.println("Hammurabi: You have only\n" + storage + " bushels.");
            } else if (choice > population * 10) {
                System.out.println("Hammurabi: You have only\n" + population + " people to tend the fields.");
            }
        } while (choice > acres || choice > storage / 2 || choice > population * 10);

        storage -= choice * 2;
        System.out.println("Storage after acres planted : " + storage + "\n");
        return choice;
    }

    public int newYield() {
        return yield = random.nextInt(6-1 + 1) + 1;
    }

    public int newHarvest(int choice) {
        harvest = choice * yield;
        storage += harvest;
        System.out.println("This years harvest was: " + harvest + "\n\n");
        return harvest;
    }

    public int newLandPrice() {
        return landPrice = random.nextInt(23-1 + 1) +1;
    }





}


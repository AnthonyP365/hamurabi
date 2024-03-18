package hammurabi;
import java.util.Random;
import java.util.Scanner;



public class Hammurabi {
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();

    public static void main(String[] args) {
        new Hammurabi().playGame();
    }

    public void playGame() {
        int population = 100;
        int acresOwned = 1000;
        int bushels = 2800;
        int year = 1;
        int landCost = 19;

        while (year <= 3) {
            printSummary(year, population, bushels, acresOwned, landCost);

            year++;

        }

    }

    public static void printSummary(int year, int population, int bushels, int acresOwned, int landCost) {
        System.out.println("O great Hammurabi!\n" +
                "You are in year " + year + " of your ten year rule.\n" +
                "The  population is now " + population + ".\n" +
                "We have " + bushels + " bushels in storage.\n" +
                "The city owns " + acresOwned + " acres of land.\n" +
                "Land is currently worth " + landCost + " bushels per acre.\n");
    }

    public int askHowManyAcresToBuy(int price,int bushels) {
        int acres;

        do {
            System.out.println("How many acres of land do you want to buy?");
            acres = scanner.nextInt();
            if (acres * price > bushels) {
                System.out.println("You don't have enough bushels! Select a lower amount.");
            }
        } while (acres * price > bushels);

        return acres;
    }

    public int askHowManyAcresToSell(int acresOwned) {
        int acres;

        do {
            System.out.println("How many acres of land do you want to sell?");
            acres = scanner.nextInt();
            if (acres > acresOwned) {
                System.out.println("You don't enough land! Select a lower amount.");
            }
        } while (acres > acresOwned);

        return acres;
    }

    public int askHowMuchGrainToFeedPeople(int bushels) {
        int bushelsForFood;

        do {
            System.out.println("How much grain do you want to feed your people?");
            bushelsForFood = scanner.nextInt();
            if (bushelsForFood > bushels) {
                System.out.println("You don't have enough grain! Select a lower amount.");
            }
        } while (bushelsForFood > bushels);

        return bushelsForFood;
    }

    public int askHowManyAcresToPlant(int acresOwned,int population,int bushels) {
        int acres;

        do {
            System.out.println("How many acres of land do you want to plant with grain?");
            acres = scanner.nextInt();
            if (acres > acresOwned) {
                System.out.println("You don't enough land! Select a lower amount.");
            } else if (acres > bushels * 2) {
                System.out.println("You don't have enough grain! Select a lower amount.");
            } else if (acres > population * 10) {
                System.out.println("You don't have enough people to tend the fields.");
            }
        } while (acres > acresOwned || acres > bushels * 2 || acres > population * 10);

        return acres;
    }

    public void plagueDeaths ( int population){}

    public void starvationDeaths ( int population, int bushelsFedToPeople){}

    public void uprising ( int population, int howManyPeopleStarved){}

    public void immigrants ( int population, int acresOwned, int grainInStorage){}

    public static int harvest ( int bushelsUsedAsSeed){
        int yield = random.nextInt(6) + 1;
        return bushelsUsedAsSeed * yield;
    }

    public void grainEatenByRats ( int bushels){}

    public static int newCostOfLand () {
        int landCost = random.nextInt(7) + 17;
        return landCost;
    }

}

package hammurabi;
import java.util.Random;
import java.util.Scanner;



public class Hammurabi {
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();
    public static int starved;
    public static int population;
    public static int fullPeople;
    public static int acresOwned;
    public static int bushels;
    public static int food;
    public static int year;
    public static int landCost;
    public static int planted;

    public static void main(String[] args) {
        new Hammurabi().playGame();
    }

    public void playGame(){
        population = 100;
        fullPeople = 0;
        acresOwned = 1000;
        bushels = 2800;
        year = 1;
        landCost = 19;


        while (year <= 3) {
            printSummary(year, population, bushels, acresOwned, landCost);

            if (askToBuyOrSell() == 1) {
                askHowManyAcresToBuy(landCost, bushels);
                System.out.println("current bushels: " + bushels);
            } else {
                askHowManyAcresToSell(acresOwned);
            }

            askHowMuchGrainToFeedPeople(bushels);
            System.out.println("current bushels: " + bushels);

            askHowManyAcresToPlant(acresOwned, population, bushels);

            bushels += harvest(planted);
            System.out.println("Current bushels: " + bushels + "\n");

            population -= starvationDeaths(population, food);
            year++;
            newCostOfLand();
        }
    }

    public static void printSummary(int year, int population, int bushels, int acresOwned, int landCost){
        System.out.println("O great Hammurabi!\n" +
                "You are in year " + year + " of your ten year rule.\n" +
                "The  population is now " + population + ".\n" +
                "We have " + bushels + " bushels in storage.\n" +
                "The city owns " + acresOwned + " acres of land.\n" +
                "Land is currently worth " + landCost + " bushels per acre.\n");
    }

    public int askToBuyOrSell(){
        int choice;

        do {
            System.out.println("Which would you like to do this year?\n" +
                    "Enter 1: Buy acres\n" +
                    "Enter 2: Sell acres");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("You have chosen to buy!\n");
                    return choice;

                case 2:
                    System.out.println("You have chosen to sell!\n");
                    return choice;

                default:
                    System.out.println("Invalid input.\n" +
                            "Please select either 1 or 2.\n");
                    break;
            }
        } while (choice != 1 && choice != 2);

        return choice;
    }

    public int askHowManyAcresToBuy(int price,int bushels){
        int acres;

        do {
            System.out.println("How many acres of land do you want to buy?");
            acres = scanner.nextInt();
            if (acres * price > bushels) {
                System.out.println("You don't have enough bushels! Select a lower amount.");
            }
        } while (acres * price > bushels);

        acresOwned += acres;
        this.bushels -= acres * landCost;

        return acres;
    }

    public int askHowManyAcresToSell(int acresOwned){
        int acres;

        do {
            System.out.println("How many acres of land do you want to sell?");
            acres = scanner.nextInt();
            if (acres > acresOwned) {
                System.out.println("You don't enough land! Select a lower amount.");
            }
        } while (acres > acresOwned);

        this.acresOwned -= acres;
        bushels += acres * landCost;

        return acres;
    }

    public int askHowMuchGrainToFeedPeople(int bushels){
        int bushelsForFood;

        do {
            System.out.println("How much grain do you want to feed your people?");
            bushelsForFood = scanner.nextInt();
            if (bushelsForFood > bushels) {
                System.out.println("You don't have enough grain! Select a lower amount.");
            }
        } while (bushelsForFood > bushels);

        this.food = bushelsForFood;
        this.bushels -= bushelsForFood;

        return bushelsForFood;
    }

    public int askHowManyAcresToPlant(int acresOwned,int population,int bushels){
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


        this.bushels -= acres * 2;

        return this.planted = acres;
    }

    public void plagueDeaths ( int population){}

    public static int starvationDeaths ( int population, int bushelsFedToPeople){
        fullPeople = bushelsFedToPeople / 20;
        int deaths = population - fullPeople;

        if (deaths >= 0){
            return deaths;
        } else {
            deaths = 0;
        }

        return starved = deaths;
    }

    public void uprising ( int population, int howManyPeopleStarved){}

    public void immigrants ( int population, int acresOwned, int grainInStorage){}

    public static int harvest ( int bushelsUsedAsSeed){
        int yield = random.nextInt(6) + 1;
        return bushelsUsedAsSeed * yield;
    }

    public void grainEatenByRats ( int bushels){}

    public static int newCostOfLand (){
        return landCost= random.nextInt(7) + 17;
    }

}

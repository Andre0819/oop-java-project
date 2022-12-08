/*---------------------------------------------------------------------------
    This is to certify that this project is our own work, based on our own
    efforts and understanding of the concepts taught to us. The program was
    run, tested, and debugged by ourselves. We also certify that we did not
    plagiarize in part or whole the work of other people.

    Aquino & Ogatia CCPROG3-S17
 --------------------------------------------------------------------------*/

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * MyFarm class contains the player, tools, and seeds
 * that will be used throughout the program as well as
 * keeps track of the in-game days.
 */
public class MyFarmModel {
    private int day;
    private Player player;
    private ArrayList<Tool> tools;
    private ArrayList<Seed> seeds;

    /**
     * Creates a MyFarm object containing the
     * attributes: day, player, tools, and seeds.
     * <p>
     * Two Tools objects are added to the ArrayList tools
     * and a Seed object is added to the ArrayList seeds.
     * </p>
     */
    public MyFarmModel(){
        this.day = 1;
        this.player = new Player();

        // add plow, watering can
        this.tools = new ArrayList<>(){{
            add(new Fertilizer());
            add(new Pickaxe());
            add(new Plow());
            add(new Shovel());
            add(new WateringCan());
        }};

        // add turnip
        this.seeds = new ArrayList<>(){{
            add(new Apple());
            add(new Carrot());
            add(new Mango());
            add(new Potato());
            add(new Rose());
            add(new Sunflower());
            add(new Tulips());
            add(new Turnip());
        }};
    }

    public void spreadRocks(){
        try{
            Scanner scan = new Scanner(System.in);
            String filename = scan.nextLine();
            File myObj = new File("src/"+filename+".txt");
            scan = new Scanner(myObj);
            String spread = scan.nextLine();
            String volume = scan.nextLine();
            scan.close();
            int amount=0, row, column;
            Random rand = new Random();
            switch(volume){
                case "low":
                    amount = 10;
                    break;
                case "medium":
                    amount = rand.nextInt(11, 21);
                    break;
                case "high":
                    amount = rand.nextInt(21, 31);
                    break;
            }
            switch(spread){
                case "upper":
                    while(amount>0){
                        row = rand.nextInt(0,3);
                        column = rand.nextInt(0,10);
                        if(!player.getFarmLot().get(row * 10 + column).getHasRocks()){
                            player.getFarmLot().get(row*10+column).setHasRocks(true);
                            amount--;
                        }
                    }
                case "lower":
                    while(amount>0){
                        row = rand.nextInt(2,5);
                        column = rand.nextInt(0,10);
                        if(!player.getFarmLot().get(row * 10 + column).getHasRocks()){
                            player.getFarmLot().get(row*10+column).setHasRocks(true);
                            amount--;
                        }
                    }
                case "even":
                    while(amount>0){
                        row = rand.nextInt(0,5);
                        column = rand.nextInt(0,10);
                        if(!player.getFarmLot().get(row * 10 + column).getHasRocks()){
                            player.getFarmLot().get(row*10+column).setHasRocks(true);
                            amount--;
                        }
                    }
            }
        } catch(FileNotFoundException e){
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }

    /**
     * Updates the day in-game and modifies the isWithered
     * attribute of the Tiles object.
     * <p>
     * The method checks for when conditions are met to modify
     * the isWithered attribute of a Tiles object.
     * Displays text corresponding to the case met.
     * </p>
     */
    public void advanceNextDay(){
        this.day++;
        for(Tile t : player.getFarmLot()){
            if(t.getSeed()!=null) {
                //checks if the crop harvest time is <,>, or == to the # of days that has passed since being planted
                if (t.getSeed().getHarvestTime() < (day - t.getDayPlanted())) {
                    System.out.println("A crop has withered.");
                    t.setWithered(true);
                } else if (t.getSeed().getHarvestTime() == (day - t.getDayPlanted())) {
                    System.out.println("A crop will be available for harvest.");
                }
            }
        }


    }

    /**
     * Returns a boolean value after checking if the
     * game has ended as per the conditions provided.
     *
     * @return  true if all conditions are met; otherwise false
     */
    public boolean checkGameEnd(){
        //to be fixed
        boolean activeCrop = false;
        boolean withered = false;
        for(Tile t : player.getFarmLot()){
            if(t.getSeed() != null) { //checks if the tile currently has a myfarm.seed.
                activeCrop = true;
            }
        }

        return (player.getObjectcoin() < 5 && !activeCrop) ;
    }

    /**
     * Returns the number of days passed in-game.
     *
     * @return  the integer value of attribute day
     */
    public int getDay(){return this.day;}
    /**
     * Returns the myfarm.Player object stored in player.
     *
     * @return  player as a myfarm.Player object
     */
    public Player getPlayer(){return this.player;}

    /**
     * Returns a list of tools available in the game.
     *
     * @return  Tools objects in tools
     */
    public ArrayList<Tool> getTools(){return this.tools;}
    /**
     * Returns a list of seeds available in the game.
     *
     * @return  Seed objects in seeds
     */
    public ArrayList<Seed> getSeeds(){return this.seeds;}
}

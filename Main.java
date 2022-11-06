/*---------------------------------------------------------------------------
    This is to certify that this project is our own work, based on our own
    efforts and understanding of the concepts taught to us. The program was
    run, tested, and debugged by ourselves. We also certify that we did not
    plagiarize in part or whole the work of other people.

    Aquino & Ogatia CCPROG3-S17
 --------------------------------------------------------------------------*/

import java.util.Scanner;

/**
 * The Main class acts as the driver
 * for the prototype program.
 */
public class Main {
    public static void main(String[] args) {

        // Creates the Farm
        MyFarm farm = new MyFarm();

        Tiles farmLot = farm.getPlayer().getFarmLot();
        Scanner myObj = new Scanner(System.in);

        // Displays introductory game comments
        System.out.println("Welcome to MyFarm Simulator! Enjoy the game!");

        // Loops the game as long the player can still play
        while(!farm.checkGameEnd()) {
            System.out.println("----------------------------");
            System.out.println("Day: " + farm.getDay());
            System.out.printf("Current Level: %d (Exp: %.2f)\n", farm.getPlayer().getFarmerExp().getPlayerLevel(), farm.getPlayer().getFarmerExp().getPlayerExp());
            System.out.printf("Current Objectcoins: %.2f\n\n", farm.getPlayer().getObjectcoin());

            // Prints the farm lot of the player
            System.out.println("Your Farm:");
            if(farmLot.getSeed() == null)
                System.out.println("[ empty ]");
            else
                System.out.println("[ " + farm.getPlayer().getFarmLot().getSeed().getSeedName() + " ]");

            // Prompts the player for action
            System.out.println("""
                    Available Actions:\s
                     1 - Plow
                     2 - Plant Seed
                     3 - Water Crop
                     4 - End Day\s""");
            // The harvest action is only available when a crop is harvestable
            if(farmLot.getSeed() != null)
                if(farmLot.getSeed().getHarvestTime() == farm.getDay()-farmLot.getDayPlanted())
                    System.out.println(" 5 - Harvest Crop");
            System.out.println("Select Action: ");
            int action = myObj.nextInt();
            switch(action){

                // Plows the tile of the player making it ready for a seed
                case 1:
                    System.out.println("Player uses "+farm.getTools().get(0).getToolName()+".");
                    farmLot.plowTile(farm);
                    break;

                // Prompts the player for the seed to be bought and planted
                // If successful, the seed will ba planted to the tile
                case 2:
                    while(true){
                        System.out.println("Available Seeds: \n 1 - Turnip | " + farm.getSeeds().get(0).getSeedCost()+" Objectcoins\nSelect Seed: ");
                        int option = myObj.nextInt();
                        if(option == 1) {
                            farm.getPlayer().getFarmLot().plantSeed(farm.getPlayer(), farm.getSeeds().get(0), farm.getDay());
                            break;
                        }else System.out.println("Invalid input. Select a different seed.");
                    }
                    break;

                // Waters the seed planted on the tile
                case 3:
                    System.out.println("Player uses "+farm.getTools().get(1).getToolName()+".");
                    farm.getPlayer().getFarmLot().waterCrop(farm);
                    break;

                // Advances the day
                case 4: farm.advanceNextDay(); break;

                // Harvests a riped crop
                case 5:
                    if(farmLot.getSeed() != null)
                        if(farmLot.getSeed().getHarvestTime() == farm.getDay()-farmLot.getDayPlanted()) {
                            farm.getPlayer().getFarmLot().harvestCrop(farm.getPlayer(), farm.getDay());
                            break;
                        }

                    // Player inputs an invalid action
                default: System.out.println("Invalid input. Select a different action."); break;
            }

            // When the game ends, it displays the concluding remarks
            if(farm.checkGameEnd()) {
                System.out.println("The game is over. Player cannot plant any more seeds.");
                break;
            }
        }
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        MyFarm farm = new MyFarm();
        Tiles farmLot = farm.getPlayer().getFarmLot();
        Scanner myObj = new Scanner(System.in);

        System.out.println("Welcome to MyFarm Simulator! Enjoy the game!");

        while(!farm.checkGameEnd()) {

            System.out.println();
            System.out.println("Day: " + farm.getDay());
            System.out.println("Your Farm:");

            if(farmLot.getSeed()==null)
                System.out.println("[ empty ]");
            else
                System.out.println("[ " + farm.getPlayer().getFarmLot().getSeed().getSeedName() + " ]");

            System.out.printf("Current Objectcoins: %.2f\n", farm.getPlayer().getObjectcoin());
            System.out.println("""
                    Available Actions:\s
                     1 - Plow
                     2 - Plant Seed
                     3 - Water Crop
                     4 - End Day\s""");

            if(farmLot.getSeed()!=null)
                if(farmLot.getSeed().getHarvestTime() == farm.getDay()-farmLot.getDayPlanted())
                    System.out.println(" 5 - Harvest Crop");

            System.out.println("Select Action: ");
            int action = myObj.nextInt();

            switch(action){
                case 1: farmLot.plowTile(farm); break;
                case 2:
                    while(true){
                        System.out.println("Available Seeds: \n 1 - Turnip | " +
                                farm.getSeeds().get(0).getSeedCost()+" Objectcoins\nSelect Seed: ");
                        int option = myObj.nextInt();
                        if(option==1) {
                            farm.getPlayer().getFarmLot().plantSeed(farm.getPlayer(), farm.getSeeds().get(0), farm.getDay());
                            break;
                        }else System.out.println("Invalid input. Select a different seed.");
                    }
                    break;
                case 3: farm.getPlayer().getFarmLot().waterCrop(farm); break;
                case 4: farm.advanceNextDay(); break;
                case 5:
                    if(farmLot.getSeed()!=null)
                        if(farmLot.getSeed().getHarvestTime() == farm.getDay()-farmLot.getDayPlanted()) {
                            farm.getPlayer().getFarmLot().harvestCrop(farm.getPlayer(), farm.getDay());
                            break;
                        }
                default: System.out.println("Invalid input. Select a different action."); break;
            }

            if(farm.checkGameEnd()) {
                System.out.println("The game is over. Player cannot plant any more seeds.");
                break;
            }
        }
    }
}

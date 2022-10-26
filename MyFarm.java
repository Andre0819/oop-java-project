import java.util.ArrayList;
import java.util.Arrays;

public class MyFarm {
    private Player player;
    private ArrayList<Tools> tools;
    private ArrayList<Seeds> seeds;
    public MyFarm(){
        this.player = new Player();
        this.tools = new ArrayList<Tools>(Arrays.asList("Plow", "Watering Can", "Fertilizer", "Pickaxe", "Shovel")) ;
        this.seeds = new ArrayList<Seeds>(Arrays.asList("Turnip", "Carrot", "Potato", "Rose", "Tulips", "Sunflower", "Mango", "Apple"));
    }

    public boolean checkGameEnd(){
        boolean activeCrop = false;
        for(Tiles a: player.getFarmLot()){
            if(a.seed != null) {
                activeCrop = true;
                break;
            }
        }
        if (player.getObjectcoin() < 5 && activeCrop)
            return true;
        return false;
    }
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}

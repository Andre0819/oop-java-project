import java.util.ArrayList;
import java.util.Arrays;

public class MyFarm {
    private int day;
    private Player player;
    private ArrayList<Tools> tools;
    private ArrayList<Seeds> seeds;
    public MyFarm(){
        this.day = 1;
        this.player = new Player();
        this.tools = new ArrayList<Tools>(Arrays.asList("Plow", "Watering Can", "Fertilizer", "Pickaxe", "Shovel")) ;
        this.seeds = new ArrayList<Seeds>(Arrays.asList("Turnip", "Carrot", "Potato", "Rose", "Tulips", "Sunflower", "Mango", "Apple"));
    }
    public void advanceNextDay();
    public boolean checkGameEnd(){
        boolean activeCrop = false;
        for(Tiles a: player.getFarmLot()){
            if(a.seed != null) {
                activeCrop = true;
                break;
            }
        }
        return player.getObjectcoin() < 5 && activeCrop;
    }
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}

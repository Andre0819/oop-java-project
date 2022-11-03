import java.util.ArrayList;
import java.util.Arrays;

public class MyFarm {
    private int day;
    private Player player;
    private ArrayList<Tools> tools;
    private ArrayList<Seed> seeds;
    public MyFarm(){
        this.day = 1;
        this.player = new Player();
        this.tools = new ArrayList<>(Arrays.asList(new Tools("Plow"), new Tools("Watering Can"), new Tools("Fertilizer"), new Tools("Pickaxe"), new Tools("Shovel"))) ;
        this.seeds = new ArrayList<>(Arrays.asList(new Seed("Turnip"), new Seed("Carrot"), new Seed("Potato"), new Seed("Rose"), new Seed("Tulips"), new Seed("Sunflower"), new Seed("Mango"), new Seed("Apple")));
    }
    public void advanceNextDay(){
        this.day++;
        if(player.getFarmLot().getSeed()!=null)
            if(player.getFarmLot().getSeed().getHarvestTime() < (day-player.getFarmLot().getDayPlanted())){
                player.getFarmLot().setWithered(true);
            }

    }
    public boolean checkGameEnd(){
        boolean activeCrop = false;
        if(player.getFarmLot().getSeed() != null) {
                activeCrop = true;
        }

        return (player.getObjectcoin() < 5 && activeCrop) || player.getFarmLot().getWitherStatus();
    }
    public int getDay(){return this.day;}
    public Player getPlayer(){return this.player;}
    public ArrayList<Tools> getTools(){return this.tools;}
    public ArrayList<Seed> getSeeds(){return this.seeds;}
}

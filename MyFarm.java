import java.util.ArrayList;

public class MyFarm {
    private int day;
    private Player player;
    private ArrayList<Tools> tools;
    private ArrayList<Seed> seeds;
    public MyFarm(){
        this.day = 1;
        this.player = new Player();

        // plow, watering can
        this.tools = new ArrayList<>();
        tools.add(new Tools("Plow", 0, 0.5));
        tools.add(new Tools("Watering Can", 0, 0.5));

        this.seeds = new ArrayList<>();
        seeds.add(new Seed("Turnip", "Root crop", 2, 1, 2, 0, 1, 1, 2, 5, 6, 5));
    }
    public void advanceNextDay(){
        this.day++;
        if(player.getFarmLot().getSeed() != null)
            if(player.getFarmLot().getSeed().getHarvestTime() < (day-player.getFarmLot().getDayPlanted())){
                player.getFarmLot().setWithered(true);
            }

    }
    public boolean checkGameEnd(){
        boolean activeCrop = false;
        if (player.getFarmLot().getSeed() != null) {
            activeCrop = true;
        }

        return (player.getObjectcoin() < 5 && activeCrop) || player.getFarmLot().getWitherStatus();
    }
    public int getDay(){return this.day;}
    public Player getPlayer(){return this.player;}
    public ArrayList<Tools> getTools(){return this.tools;}
    public ArrayList<Seed> getSeeds(){return this.seeds;}
}

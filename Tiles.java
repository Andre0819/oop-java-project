public class Tiles {
    private int dayPlanted;
    private boolean isPlowed;
    private boolean isWithered;
    private int wateredCrop;
    private Seed seed;

    public Tiles(){
        this.isPlowed = false;
        this.isWithered = false;
        this.seed = null;
        this.dayPlanted = 0;
        this.wateredCrop = 0;
    }

    public void plowTile(MyFarm farm){
        Player p = farm.getPlayer();
        if(!this.isPlowed){
            this.isPlowed = true;
            p.setObjectcoin(p.getObjectcoin()-farm.getTools().get(1).getUsageCost());
            System.out.println("Tile is now plowed.");
        } else
            System.out.println("Tile has already been plowed.");

    }
    public void waterCrop(MyFarm farm){
        Player p = farm.getPlayer();
        if(this.seed != null) {
            if (this.wateredCrop < seed.getWaterBonusLimit()) {
                this.wateredCrop++;
                p.setObjectcoin(p.getObjectcoin()-farm.getTools().get(1).getUsageCost());
                System.out.println("This crop has been watered " + this.wateredCrop + " times.");
            } else
                System.out.println("This crop cannot be watered anymore.");
        }
        else
            System.out.println("The tile is currently empty.");
    }

    public void plantSeed(Player player, Seed plant, int day){
        if(seed==null) {
            if(this.isPlowed) {
                if (player.getObjectcoin() > plant.getSeedCost()) {
                    player.setObjectcoin(player.getObjectcoin() - plant.getSeedCost());
                    this.seed = plant;
                    this.dayPlanted = day;
                    System.out.println(plant.getSeedName() + " successfully planted.");
                    System.out.println("Player's Objectcoins is now " + player.getObjectcoin() + ".");
                } else
                    System.out.println("Player does not have enough Objectcoins.");
            }else System.out.println("Tile is unplowed.");
        }else System.out.println("A seed is already planted.");

    }
    public void harvestCrop(Player player, int day){
        double HarvestTotal, FinalTotal, WaterBonus, produce;
        if(seed!=null && !this.isWithered) {
            if (seed.getHarvestTime() == (day - this.dayPlanted)) {
                if (wateredCrop >= seed.getWaterNeeds()) {
                    produce = seed.getSeedProduce();
                    HarvestTotal = produce * (seed.getSellingPrice());
                    WaterBonus = HarvestTotal * 0.2 * (wateredCrop-1);
                    FinalTotal = HarvestTotal + WaterBonus;
                    if (seed.getCropType().compareTo("Flower") == 0)
                        FinalTotal = FinalTotal * 1.1;
                    player.setObjectcoin(player.getObjectcoin()+FinalTotal);
                    this.wateredCrop = 0;
                    this.seed = null;
                    this.isPlowed = false;
                    System.out.println("Crop successfully harvested.\nProducts produced: " + produce);
                } else {
                    this.isWithered = true;
                    System.out.println("Crop did not meet the water requirement.\nCrop has withered.");
                }
            } else
                System.out.println("The crop is not yet ready for harvest.");
        }

    }
    public Seed getSeed(){return this.seed;}
    public int getDayPlanted(){return this.dayPlanted;}
    public boolean getWitherStatus(){return this.isWithered;}
    public void setWithered(boolean status){
        this.isWithered = status;
    }
}



public class Tiles {
    private int dayPlanted;
    private boolean isPlowed;
    private boolean hasRocks;
    private boolean isWithered;
    private int wateredCrop;
    private int fertilizedCrop;
    private Seed seed;

    public Tiles(){
        this.isPlowed = false;
        this.isWithered = false;
        this.hasRocks = false;
        this.seed = null;
        this.dayPlanted = 0;
        this.wateredCrop = 0;
        this.fertilizedCrop = 0
    }

    public boolean plowTile(Tools tool){
        if(!this.isPlowed){
            if(tool.getToolName().compareTo("Plow")==0){
                this.isPlowed = true;
                return true;
            }
        }
        return false;
    }
    public boolean removeRock(Tools tool){
        if(this.hasRocks){
            if(tool.getToolName().compareTo("Pickaxe")==0){
                this.hasRocks = false;
                return true;
            }
        }
        return false;
    }
    public boolean removeWither(Tools tool){
        if(this.isWithered){
            if(tool.getToolName().compareTo("Shovel")==0){
                this.isWithered = false;
                return true;
            }
        }
        return false;
    }
    public boolean plantSeed(Player player, Seed seed, int day){
        if(player.getObjectcoin() > seed.getSeedCost()){
            player.setObjectcoin(player.getObjectcoin()-seed.getSeedCost());
            this.seed = seed;
            this.dayPlanted = day;
        }
    }
    public boolean harvestCrop(Player player, int day){
        double HarvestTotal, FinalTotal, WaterBonus, FertilizerBonus;
        if(seed.getHarvestTime()==(this.dayPlanted-day)){
            HarvestTotal = seed.getProductsProduced() * (seed.getSellingPrice()+player.getXp().getBonusEarnings());
            WaterBonus = HarvestTotal * 0.2 * wateredCrop;
            FertilizerBonus = HarvestTotal * 0.5 * fertilizedCrop;
            FinalTotal = HarvestTotal + WaterBonus + FertilizerBonus;
            if(seed.getCropType().compareTo("Flower")==0)
                FinalTotal = FinalTotal * 1.1;
            player.setObjectcoin(FinalTotal);
        }
    }
}

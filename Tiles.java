public class Tiles {
    private boolean isPlowed;
    private boolean hasRocks;
    private boolean isWithered;
    private Seed seed;

    public Tiles(){
        this.isPlowed = false;
        this.isWithered = false;
        this.hasRocks = false;
        this.seed = null;
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
    public boolean plantSeed(Player player, Seed seed){
        if(player.getObjectcoin() > seed.getCostUsage()){
            player.setObjectcoin(player.getObjectcoin()-seed.getCostUsage());
            this.seed = seed;
        }
    }
}

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Player {
    private ArrayList<Tiles> farmLot;
    private int objectcoin;
    private FarmerXP xp;

    public Player(){
        this.farmLot = new ArrayList<Tiles>();
        this.objectcoin = 100;
        this.xp = new FarmerXP();
    }

    public ArrayList<Tiles> getFarmLot(){return this.farmLot;}
    public int getObjectcoin(){return this.objectcoin;}

    public FarmerXP getXp() {
        return this.xp;
    }
    public int setObjectcoin(int coin){this.objectcoin = coin;}
}

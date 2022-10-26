import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Player {
    private ArrayList<Tiles> farmLot;
    private double objectcoin;
    private FarmerExp exp;

    public Player(){
        this.farmLot = new ArrayList<Tiles>();
        this.objectcoin = 100;
        this.xp = new FarmerExp();
    }

    public ArrayList<Tiles> getFarmLot(){return this.farmLot;}
    public double getObjectcoin(){return this.objectcoin;}

    public FarmerExp getExp() {
        return this.exp;
    }
    public void setObjectcoin(double coin){this.objectcoin += coin;}
}

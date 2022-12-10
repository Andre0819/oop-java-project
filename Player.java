

import java.util.ArrayList;
import java.util.List;

/**
 * Player class contains the farmLot, objectcoin,
 * farmerExp, farmerLevel, farmerType, and farmerTypeList. Most methods from
 * other classes will be accessing Player to obtain
 * or update values in its attributes.
 */
public class Player {
    private ArrayList<Tile> farmLot;
    private double farmerExp;
    private int farmerLevel;
    private ArrayList<FarmerType> farmerTypeList;
    private FarmerType farmerType;
    private double objectcoin;

    /**
     * Creates Player object.
     * <p>
     * The values of the attribute objectcoin is
     * initialized to 100. The attribute farmLot will have 50 Tile objects
     * added to it. The attribute farmerTypeList will have different farmer types added in.
     *
     * </p>
     */
    public Player(){
        this.farmLot = new ArrayList<>();

        for(int i=1;i<=50;i++)
            this.farmLot.add(new Tile(i));


        this.farmerExp = 0;
        this.farmerLevel = 0;
        this.farmerTypeList = new ArrayList<>(){{
            add(new DefaultFarmer());
            add(new RegisteredFarmer());
            add(new DistinguishedFarmer());
            add(new LegendaryFarmer());
        }};
        this.farmerType = farmerTypeList.get(0);
        this.objectcoin = 100;
    }
    /**
     * A method that updates the farmerType of Player.
     *
     *
     * @return boolean value whether action is successful.
     */
    public boolean updateFarmerType(){
        boolean result = false;
        int type=0;
        if(farmerType instanceof DefaultFarmer){
            type = 1;
        } else if (farmerType instanceof RegisteredFarmer) {
            type = 2;
        } else if (farmerType instanceof DistinguishedFarmer){
            type = 3;
        }
        if(type!=0) {
            if (objectcoin >= farmerTypeList.get(type).getRegFee() && farmerLevel >= farmerTypeList.get(type).getLevelReq()) {
                farmerType = farmerTypeList.get(type);
                objectcoin -= farmerTypeList.get(type).getRegFee();
                result = true;
            }
        }
        return result;
    }

    /**
     * A method that updates the experience of the player upon action that
     * results to experience. The action might be plowing a tile, watering
     * a myfarm.seed, or harvesting a crop.
     * <p>
     * The method is also responsible for automatically updating the level
     * for every 100 experience points reached.
     * </p>
     *
     * @param expYield  the experience yield
     */
    public void updatePlayerExp(double expYield) {
        this.farmerExp += expYield;
        this.farmerLevel = (int)(farmerExp / 100);
    }
    /**
     * Returns the farmLot tile as a Tiles object.
     *
     * @return  the Tiles object farmLot
     */
    public ArrayList<Tile> getFarmLot(){return this.farmLot;}
    /**
     * Returns the exp of the player.
     *
     * @return  the double value in farmerExp
     */
    public double getFarmerExp(){return this.farmerExp;}
    public int getFarmerLevel(){return this.farmerLevel;}

    public FarmerType getFarmerType() {
        return this.farmerType;
    }

    /**
     * Returns the amount of objectcoins the player currently has.
     *
     * @return  the integer value of the attribute objectcoin
     */
    public double getObjectcoin(){return this.objectcoin;}


    /**
     * Takes parameter coin and updates the attribute objectcoin
     * with coin as its new value.
     *
     * @param coin  the new amount of objectcoins in double format
     */
    public void setObjectcoin(double coin){this.objectcoin = coin;}
}

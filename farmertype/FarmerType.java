package farmertype;

public abstract class FarmerType {

    private String typeName;
    private int levelReq;
    private int bonusPerProduce;
    private int costReduction;
    private int waterBonusLI; //LI - limit increase
    private int fertBonusLI;
    private double regFee;

    public FarmerType(String typeName, int levelReq, int bonusPerProduce, int costReduction,
                      int waterBonusLI, int fertBonusLI, double regFee) {
        this.typeName = typeName;
        this.levelReq = levelReq;
        this.bonusPerProduce = bonusPerProduce;
        this.costReduction = costReduction;
        this.waterBonusLI = waterBonusLI;
        this.fertBonusLI = fertBonusLI;
        this.regFee = regFee;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public int getLevelReq() {
        return this.levelReq;
    }

    public int getBonusPerProduce() {
        return this.bonusPerProduce;
    }

    public int getCostReduction() {
        return this.costReduction;
    }

    public int getWaterBonusLI() {
        return this.waterBonusLI;
    }

    public int getFertBonusLI() {
        return this.fertBonusLI;
    }

    public double getRegFee() {
        return this.regFee;
    }
}

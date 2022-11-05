import java.util.Random;

public class Seed {

    private String seedName;
    private String cropType;
    private int harvestTime;
    private int waterNeeds;
    private int waterBonusLimit;
    private int fertilizerNeeds;
    private int fertilizerBonusLimit;
    private int seedProduceMin;
    private int seedProduceMax;
    private int seedCost;
    private int sellingPrice;
    private double expYield;

    public Seed(String seedName, String cropType, int harvestTime, int waterNeeds, int waterBonusLimit,
                int fertilizerNeeds, int fertilizerBonusLimit, int seedProduceMin, int seedProduceMax, int seedCost,
                int sellingPrice, int expYield){

        this.seedName = seedName;
        this.cropType = cropType;
        this.harvestTime = harvestTime;
        this.waterNeeds = waterNeeds;
        this.waterBonusLimit = waterBonusLimit;
        this.fertilizerNeeds = fertilizerNeeds;
        this.fertilizerBonusLimit = fertilizerBonusLimit;
        this.seedProduceMin = seedProduceMin;
        this.seedProduceMax = seedProduceMax;
        this.seedCost = seedCost;
        this.sellingPrice = sellingPrice;
        this.expYield = expYield;
    }

    public String getSeedName() {
        return seedName;
    }

    public String getCropType() {
        return cropType;
    }

    public int getHarvestTime() {
        return harvestTime;
    }

    public int getWaterNeeds() {
        return waterNeeds;
    }

    public int getWaterBonusLimit() {
        return waterBonusLimit;
    }

    public int getFertilizerNeeds() {
        return fertilizerNeeds;
    }

    public int getFertilizerBonusLimit() {
        return fertilizerBonusLimit;
    }

    public int getSeedCost() {
        return seedCost;
    }

    public int getSellingPrice() {
        return sellingPrice;
    }

    public double getExpYield() {
        return expYield;
    }

    public int getSeedProduce() {
        Random randomizer = new Random();
        int produce = randomizer.nextInt(seedProduceMin, seedProduceMax + 1);
        return produce;
    }
}

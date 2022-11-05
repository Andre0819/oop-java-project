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
                int seedProduceMin, int seedProduceMax, int seedCost, int sellingPrice){

        this.seedName = seedName;
        this.cropType = cropType;
        this.harvestTime = harvestTime;
        this.waterNeeds = waterNeeds;
        this.waterBonusLimit = waterBonusLimit;
        this.seedProduceMin = seedProduceMin;
        this.seedProduceMax = seedProduceMax;
        this.seedCost = seedCost;
        this.sellingPrice = sellingPrice;
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

    public int getSeedCost() {
        return seedCost;
    }

    public int getSellingPrice() {
        return sellingPrice;
    }

    public int getSeedProduce() {
        Random randomizer = new Random();
        int produce = randomizer.nextInt(seedProduceMin, seedProduceMax + 1);
        return produce;
    }
}

import java.util.Random;

/**
 * This class represents a myfarm.seed, which contains a myfarm.seed name, crop type, time it takes
 * to harvest the crop, the minimum and maximum amount of water and fertilizer it needs to
 * be harvestable, the number of possible produce, the myfarm.seed cost, the base selling price,
 * and its experience yield.
 */
public abstract class Seed {

    private String seedName;
    private String cropType;
    private int harvestTime;
    private int waterNeeds;
    private int waterBonusLimit;
    private int fertilizerNeeds;
    private int fertilizerBonusLimit;
    private int seedProduceMin;
    private int seedProduceMax;
    private float seedCost;
    private float sellingPrice;
    private double expYield;

    /**
     * Creates a Seed object by supplying the myfarm.seed name, crop type, time it takes
     * to harvest the crop, the minimum and maximum amount of water and fertilizer it needs
     * to be harvestable, the number of possible produce, the myfarm.seed cost, and its base selling
     * price.
     *
     * @param seedName              the name of the myfarm.seed
     * @param cropType              the crop type of the myfarm.seed
     * @param harvestTime           the number of days the myfarm.seed needs for harvest
     * @param waterNeeds            the minimum amount of water the myfarm.seed needs for harvest
     * @param waterBonusLimit       the maximum amount of water the myfarm.seed can take
     * @param fertilizerNeeds       the minimum amount of fertilizer the myfarm.seed needs
     * @param fertilizerBonusLimit  the maximum amount of fertilizer the myfarm.seed needs
     * @param seedProduceMin        the minimum number of produce the myfarm.seed can make
     * @param seedProduceMax        the maximum number of produce the myfarm.seed can make
     * @param seedCost              the cost of the myfarm.seed in objectcoin
     * @param sellingPrice          the base selling price of the myfarm.seed per produce
     * @param expYield              the experience yield of the myfarm.seed upon harvest
     */
    public Seed(String seedName, String cropType, int harvestTime, int waterNeeds, int waterBonusLimit,
                int fertilizerNeeds, int fertilizerBonusLimit, int seedProduceMin, int seedProduceMax,
                int seedCost, int sellingPrice, double expYield) {

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

    /**
     * A method that returns the myfarm.seed name.
     *
     * @return the name of the myfarm.seed
     */
    public String getSeedName() {
        return seedName;
    }

    /**
     * A method the returns the crop type.
     *
     * @return the crop type of the myfarm.seed
     */
    public String getCropType() {
        return cropType;
    }

    /**
     * A method that returns the harvest time of the myfarm.seed.
     *
     * @return the number of days the myfarm.seed needs for harvest
     */
    public int getHarvestTime() {
        return harvestTime;
    }

    /**
     * A method that returns the water needs of the myfarm.seed.
     *
     * @return the minimum amount of water the myfarm.seed needs for harvest
     */
    public int getWaterNeeds() {
        return waterNeeds;
    }

    /**
     * A method that returns the water bonus limit of the myfarm.seed.
     *
     * @return the maximum amount of water the myfarm.seed can take
     */
    public int getWaterBonusLimit() {
        return waterBonusLimit;
    }

    public int getFertilizerNeeds() {
        return this.fertilizerNeeds;
    }

    public int getFertilizerBonusLimit() {
        return this.fertilizerBonusLimit;
    }

    /**
     * A method that returns the myfarm.seed cost.
     *
     * @return the cost of the myfarm.seed in objectcoin
     */
    public float getSeedCost() {
        return seedCost;
    }

    /**
     * A method the returns the selling price of the myfarm.seed per produce.
     *
     * @return the base selling price of the myfarm.seed per produce
     */
    public float getSellingPrice() {
        return this.sellingPrice;
    }

    /**
     * A method the returns the experience yield of the myfarm.seed upon harvest
     *
     * @return the experience yield of the myfarm.seed upon harvest
     */
    public double getExpYield() {
        return this.expYield;
    }

    /**
     * A method that generates a random number of produce given the range of
     * produce the myfarm.seed can make.
     *
     * @return the number of produce the myfarm.seed generated
     */
    public int getSeedProduce() {
        Random randomizer = new Random();
        return randomizer.nextInt(seedProduceMin, seedProduceMax + 1);
    }
}
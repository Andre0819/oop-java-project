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

    public Seed(String seedName){

        switch (this.seedName) {

            case "Turnip":
                this.cropType = "Root crop";
                this.harvestTime = 2;
                this.waterNeeds = 1;
                this.waterBonusLimit = 2;
                this.fertilizerNeeds = 0;
                this.fertilizerBonusLimit = 1;
                this.seedProduceMin = 1;
                this.seedProduceMax = 2;
                this.seedCost = 5;
                this.sellingPrice = 6;
                this.expYield = 5;
                break;

            case "Carrot":
                this.cropType = "Root crop";
                this.harvestTime = 3;
                this.waterNeeds = 1;
                this.waterBonusLimit = 2;
                this.fertilizerNeeds = 0;
                this.fertilizerBonusLimit = 1;
                this.seedProduceMin = 1;
                this.seedProduceMax = 2;
                this.seedCost = 10;
                this.sellingPrice = 9;
                this.expYield = 7.5;
                break;

            case "Potato":
                this.cropType = "Root crop";
                this.harvestTime = 5;
                this.waterNeeds = 3;
                this.waterBonusLimit = 4;
                this.fertilizerNeeds = 1;
                this.fertilizerBonusLimit = 2;
                this.seedProduceMin = 1;
                this.seedProduceMax = 10;
                this.seedCost = 20;
                this.sellingPrice = 3;
                this.expYield = 12.5;
                break;

            case "Rose":
                this.cropType = "Flower";
                this.harvestTime = 1;
                this.waterNeeds = 1;
                this.waterBonusLimit = 2;
                this.fertilizerNeeds = 0;
                this.fertilizerBonusLimit = 1;
                this.seedProduceMin = 1;
                this.seedProduceMax = 1;
                this.seedCost = 5;
                this.sellingPrice = 65;
                this.expYield = 2.5;
                break;

            case "Tulips":
                this.cropType = "Flower";
                this.harvestTime = 2;
                this.waterNeeds = 2;
                this.waterBonusLimit = 3;
                this.fertilizerNeeds = 0;
                this.fertilizerBonusLimit = 1;
                this.seedProduceMin = 1;
                this.seedProduceMax = 1;
                this.seedCost = 10;
                this.sellingPrice = 9;
                this.expYield = 5;
                break;

            case "Sunflower":
                this.cropType = "Flower";
                this.harvestTime = 3;
                this.waterNeeds = 2;
                this.waterBonusLimit = 3;
                this.fertilizerNeeds = 1;
                this.fertilizerBonusLimit = 2;
                this.seedProduceMin = 1;
                this.seedProduceMax = 1;
                this.seedCost = 20;
                this.sellingPrice = 19;
                this.expYield = 7.5;
                break;

            case "Mango":
                this.cropType = "Fruit tree";
                this.harvestTime = 10;
                this.waterNeeds = 7;
                this.waterBonusLimit = 7;
                this.fertilizerNeeds = 4;
                this.fertilizerBonusLimit = 4;
                this.seedProduceMin = 5;
                this.seedProduceMax = 15;
                this.seedCost = 100;
                this.sellingPrice = 8;
                this.expYield = 25;
                break;

            case "Apple":
                this.cropType = "Fruit tree";
                this.harvestTime = 10;
                this.waterNeeds = 7;
                this.waterBonusLimit = 7;
                this.fertilizerNeeds = 5;
                this.fertilizerBonusLimit = 5;
                this.seedProduceMin = 10;
                this.seedProduceMax = 15;
                this.seedCost = 200;
                this.sellingPrice = 5;
                this.expYield = 25;
                break;
        }
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

    public int getSeedProduceMin() {
        return seedProduceMin;
    }

    public int getSeedProduceMax() {
        return seedProduceMax;
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

    /** Related sa Farmer XP
    public int setSeedCost() {

    }
     **/
}

public class Seed {

    private String seedName;
    private String cropType;
    private int harvestTime;
    private int waterNeeds;
    private int waterBonusLimit;
    private int seedProduceMin;
    private int seedProduceMax;
    private int seedCost;
    private int sellingPrice;

    public Seed(String seedName){
        this.seedName = seedName;
        switch (this.seedName) {
            case "Turnip" -> {
                this.cropType = "Root crop";
                this.harvestTime = 2;
                this.waterNeeds = 1;
                this.waterBonusLimit = 2;
                this.seedProduceMin = 1;
                this.seedProduceMax = 2;
                this.seedCost = 5;
                this.sellingPrice = 6;
            }
            case "Carrot" -> {
                this.cropType = "Root crop";
                this.harvestTime = 3;
                this.waterNeeds = 1;
                this.waterBonusLimit = 2;
                this.seedProduceMin = 1;
                this.seedProduceMax = 2;
                this.seedCost = 10;
                this.sellingPrice = 9;
            }
            case "Potato" -> {
                this.cropType = "Root crop";
                this.harvestTime = 5;
                this.waterNeeds = 3;
                this.waterBonusLimit = 4;
                this.seedProduceMin = 1;
                this.seedProduceMax = 10;
                this.seedCost = 20;
                this.sellingPrice = 3;
            }
            case "Rose" -> {
                this.cropType = "Flower";
                this.harvestTime = 1;
                this.waterNeeds = 1;
                this.waterBonusLimit = 2;
                this.seedProduceMin = 1;
                this.seedProduceMax = 1;
                this.seedCost = 5;
                this.sellingPrice = 65;
            }
            case "Tulips" -> {
                this.cropType = "Flower";
                this.harvestTime = 2;
                this.waterNeeds = 2;
                this.waterBonusLimit = 3;
                this.seedProduceMin = 1;
                this.seedProduceMax = 1;
                this.seedCost = 10;
                this.sellingPrice = 9;
            }
            case "Sunflower" -> {
                this.cropType = "Flower";
                this.harvestTime = 3;
                this.waterNeeds = 2;
                this.waterBonusLimit = 3;
                this.seedProduceMin = 1;
                this.seedProduceMax = 1;
                this.seedCost = 20;
                this.sellingPrice = 19;
            }
            case "Mango" -> {
                this.cropType = "Fruit tree";
                this.harvestTime = 10;
                this.waterNeeds = 7;
                this.waterBonusLimit = 7;
                this.seedProduceMin = 5;
                this.seedProduceMax = 15;
                this.seedCost = 100;
                this.sellingPrice = 8;
            }
            case "Apple" -> {
                this.cropType = "Fruit tree";
                this.harvestTime = 10;
                this.waterNeeds = 7;
                this.waterBonusLimit = 7;
                this.seedProduceMin = 10;
                this.seedProduceMax = 15;
                this.seedCost = 200;
                this.sellingPrice = 5;
            }
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

    public int getSeedProduce() {
        return (int) Math.floor(Math.random() * (this.seedProduceMax - this.seedProduceMin + 1) + this.seedProduceMin);
    }

    public int getSeedCost() {
        return seedCost;
    }

    public int getSellingPrice() {
        return sellingPrice;
    }

}

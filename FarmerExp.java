public class FarmerExp {

    private String farmerType;
    private double playerExp;
    private int playerLevel;
    private int bonusEarningsPerProduce;
    private int seedCostReduction;
    private int waterBonusLI; // LI - limit increase
    private int fertilizerBonusLI;

    private int registeredFarmerFee = 200;
    private int distinguishedFarmerFee = 300;
    private int legendaryFarmerFee = 400;

    public FarmerExp() {
        this.farmerType = "Farmer";
        this.playerExp = 0;
        this.playerLevel = 0;
        this.bonusEarningsPerProduce = 0;
        this.seedCostReduction = 0;
        this.waterBonusLI = 0;
        this.fertilizerBonusLI = 0;
    }

    public void updatePlayerExp(double expYield) {
        this.playerExp += expYield;
        playerLevel = (int)(playerExp / 100);
    }

    //t - successful registration , f otherwise
    public boolean registerFarmer(Player player, String type) {

        String tempFarmerType = player.getExp().getFarmerType();
        boolean isRegistered = false;

        if (type.equals("Registered Farmer")) {
            if (player.getObjectcoin() >= registeredFarmerFee && playerLevel >= 5
                && tempFarmerType.equals("Farmer")) {

                player.setObjectcoin(player.getObjectcoin() - registeredFarmerFee);

                this.farmerType = type;
                this.bonusEarningsPerProduce = 1;
                this.seedCostReduction = 1;

                isRegistered = true;
            }
        }
        else if (type.equals("Distinguished Farmer")) {
            if (player.getObjectcoin() >= distinguishedFarmerFee && playerLevel >= 10
                && tempFarmerType.equals("Registered Farmer")) {

                player.setObjectcoin(player.getObjectcoin() - distinguishedFarmerFee);

                this.farmerType = type;
                this.bonusEarningsPerProduce = 2;
                this.seedCostReduction = 2;
                this.waterBonusLI = 1;

                isRegistered = true;
            }
        }
        else { // legendary
            if (player.getObjectcoin() >= legendaryFarmerFee && playerLevel >= 15
                && tempFarmerType.equals("Distinguished Farmer")) {

                player.setObjectcoin(player.getObjectcoin() - legendaryFarmerFee);

                this.farmerType = type;
                this.bonusEarningsPerProduce = 4;
                this.seedCostReduction = 3;
                this.waterBonusLI = 2;
                this.fertilizerBonusLI = 1;

                isRegistered = true;
            }

        }

        return isRegistered;
    }


    public String getFarmerType() {
        return farmerType;
    }

    public double getPlayerExp() {
        return playerExp;
    }

    public int getPlayerLevel() {
        return playerLevel;
    }

    public int getBonusEarningsPerProduce() {
        return bonusEarningsPerProduce;
    }

    public int getSeedCostReduction() {
        return seedCostReduction;
    }

    public int getWaterBonusLI() {
        return waterBonusLI;
    }

    public int getFertilizerBonusLI() {
        return fertilizerBonusLI;
    }
}

/**
 * FarmerType class represents the farmer type of the player, which contains the type name,
 * level requirement, bonus objectcoin per produce, seed cost reduction, water and
 * fertilizer bonus limit increase, and the registration fee.
 *
 * <p>
 * Depending on the farmer type, the player will enjoy certain bonuses on some their actions.
 * Bonuses include bonus earnings in produce, cost reduction in buying seeds, increased bonus
 * limit on water and fertilizer usage.
 */
public abstract class FarmerType {

    private String typeName;
    private int levelReq;
    private int bonusPerProduce;
    private int costReduction;
    private int waterBonusLI; //LI - limit increase
    private int fertBonusLI;
    private double regFee;

    /**
     * Creates a Farmer Type object by supplying the type name, level requirement,
     * bonus objectcoin per produce, seed cost reduction, water and fertilizer bonus
     * limit increase, and the  registration fee.
     *
     * @param typeName              the farmer type
     * @param levelReq              the minimum level requirement
     * @param bonusPerProduce       the bonus earnings per produce
     * @param costReduction         the seed cost reduction
     * @param waterBonusLI          the water bonus limit increase
     * @param fertBonusLI           the fertilizer bonus limit increase
     * @param regFee                the registration fee of the farmer type
     */
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

    /**
     * A method that returns the farmer type
     *
     * @return the farmer type
     */
    public String getTypeName() {
        return this.typeName;
    }

    /**
     * A method that returns the level requirement for the farmer type
     *
     * @return the level requirement
     */
    public int getLevelReq() {
        return this.levelReq;
    }

    /**
     * A method that returns the bonus earnings per produce
     *
     * @return the bonus earnings per produce
     */
    public int getBonusPerProduce() {
        return this.bonusPerProduce;
    }

    /**
     * A method that returns the seed cost reduction
     *
     * @return the seed cost reduction
     */
    public int getCostReduction() {
        return this.costReduction;
    }

    /**
     * A method that returns the water bonus limit increase
     *
     * @return the water bonus limit increase
     */
    public int getWaterBonusLI() {
        return this.waterBonusLI;
    }

    /**
     * A method that returns the fertilizer bonus limit increase
     *
     * @return the fertilizer bonus limit increase
     */
    public int getFertBonusLI() {
        return this.fertBonusLI;
    }

    /**
     * A method that returns the amount of objectcoin needed to
     * register for the farmer type
     *
     * @return the registration fee
     */
    public double getRegFee() {
        return this.regFee;
    }
}

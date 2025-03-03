/**
 * This class represent a tool, which has a name, usage cost, and experience yield.
 */
public class Tools {

    private String toolName;
    private int usageCost;
    private double expYield;

    /**
     * Creates a Tools object by supplying the name and usage cost
     *
     * @param toolName      the name of the tool
     * @param usageCost     the objectcoin amount needed for the tool's usage
     * @param expYield      the experience yield of the tool upon usage
     */
    public Tools(String toolName, int usageCost, double expYield) {
        this.toolName = toolName;
        this.usageCost = usageCost;
        this.expYield = expYield;
    }

    /**
     * A method that returns the name of the tool
     *
     * @return the name of tool
     */
    public String getToolName() {
        return this.toolName;
    }

    /**
     * A method that returns the usage cost of the tool
     *
     * @return the objectcoin amount needed for the tool's usage
     */
    public int getUsageCost() {
        return this.usageCost;
    }

    /**
     * A method that returns the experience yield of the tool upon usage
     *
     * @return the experience yield of the tool upon usage
     */
    public double getExpYield() {
        return expYield;
    }
}

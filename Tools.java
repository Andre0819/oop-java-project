/**
 * This class represent a tool, which has a name and usage cost.
 */
public class Tools {

    private String toolName;
    private int usageCost;

    /**
     * Creates a Tools object by supplying the name and usage cost
     * 
     * @param toolName      the name of the tool
     * @param usageCost     the objectcoin amount needed for the tool's usage
     */
    public Tools(String toolName, int usageCost) {
        this.toolName = toolName;
        this.usageCost = usageCost;
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
}

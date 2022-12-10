/**
 * This class represents a tool, which contains the tool name, usage cost, and experience
 * yield.
 * <p>
 * A tool can be used to a tile under certain conditions and if the player has enough
 * objectcoins to pay for the usage cost. After successful use, it will update the player's
 * object coins and will yield experience points.
 */

public abstract class Tool {

    private String toolName;
    private int usageCost;
    private double expYield;

    /**
     * Creates a Tool object by supplying the tool name, usage cost, and experience yield.
     *
     * @param toolName      the name of the tool
     * @param usageCost     the objectcoin amount needed to use the tool
     * @param expYield      the experience yield
     */
    public Tool(String toolName, int usageCost, double expYield) {
        this.toolName = toolName;
        this.usageCost = usageCost;
        this.expYield = expYield;
    }

    /**
     * An abstract method that uses the tool to a tile and updates
     * the player's objectcoins and experience points upon successful
     * usage.
     *
     * @param tile      the tile where tool will be used on
     * @param player    the player using the tool
     *
     * @return the usage status of the tool
     */
    public abstract boolean useTool(Tile tile, Player player);

    /**
     * A method that returns the name of the tool
     *
     * @return the name of the tool
     */
    public String getToolName() {
        return toolName;
    }

    /**
     * A method that returns the objectcoin amount needed to use the tool.
     *
     * @return the usage cost
     */
    public int getUsageCost() {
        return usageCost;
    }

    /**
     * A method that returns the tool's experience yield upon successful usage.
     *
     * @return the experience yield
     */
    public double getExpYield() {
        return expYield;
    }
}

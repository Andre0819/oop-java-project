package tool;

import seed.*;
public abstract class Tool {

    private String toolName;
    private int usageCost;
    private double expYield;

    public Tool(String toolName, int usageCost, double expYield) {
        this.toolName = toolName;
        this.usageCost = usageCost;
        this.expYield = expYield;
    }

    public String getToolName() {
        return toolName;
    }

    public int getUsageCost() {
        return usageCost;
    }

    public double getExpYield() {
        return expYield;
    }
}

public class Tools {

    private String toolName;
    private int usageCost;
    private double usageExpGain;

    public Tools(String toolName, int usageCost, double usageExpGain) {
        this.toolName = toolName;
        this.usageCost = usageCost;
        this.usageExpGain = usageExpGain;
    }

    public String getToolName() {
        return this.toolName;
    }

    public int getUsageCost() {
        return this.usageCost;
    }

    public double getUsageExpGain() {
        return this.usageExpGain;
    }
}

public class Tools {

    private String toolName;
    private int usageCost;
    private double usageExpGain;

    public Tools(String toolName, int usageCost, double usageExpGain) {
        this.toolName = toolName;

        switch (this.toolName) {

            case "Plow":
            case "Watering Can":
                this.usageCost = 0;
                this.usageExpGain = 0.5;
                break;

            case "Fertilizer":
                this.usageCost = 10;
                this.usageExpGain = 4;
                break;

            case "Pickaxe":
                this.usageCost = 50;
                this.usageExpGain = 15;
                break;

            case "Shovel":
                this.usageCost = 7;
                this.usageExpGain = 2;
                break;
        }
    }

    public String getToolName() {
        return toolName;
    }

    public int getUsageCost() {
        return usageCost;
    }

    public double getUsageExpGain() {
        return usageExpGain;
    }
}

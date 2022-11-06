public class Tools {

    private String toolName;
    private int usageCost;

    public Tools(String toolName, int usageCost) {
        this.toolName = toolName;
        this.usageCost = usageCost;
    }

    public String getToolName() {
        return this.toolName;
    }

    public int getUsageCost() {
        return this.usageCost;
    }
}

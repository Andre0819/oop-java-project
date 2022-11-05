public class Tools {

    private String toolName;
    private int usageCost;

    public Tools(String toolName) {
        this.toolName = toolName;

        switch (this.toolName) {

            case "Plow":
            case "Watering Can":
                this.usageCost = 0;
                break;

            case "Fertilizer":
                this.usageCost = 10;
                break;

            case "Pickaxe":
                this.usageCost = 50;
                break;

            case "Shovel":
                this.usageCost = 7;
                break;
        }
    }

    public int getUsageCost() {
        return this.usageCost;
    }

}

/**
 * LegendaryFarmer class represents a legendary farmer type that extends the FarmerType class.
 */
public class LegendaryFarmer extends FarmerType {

    /**
     * Creates a LegendaryFarmer object with predefined attributes that is passed to the
     * constructor of the abstract class FarmerType.
     */
    public LegendaryFarmer() {
        super("Legendary Farmer", 15, 4, 3,
                2, 1, 400);
    }
}

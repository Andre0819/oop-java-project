/**
 * DistinguishedFarmer class represents a distinguished farmer type that extends the FarmerType class.
 */
public class DistinguishedFarmer extends FarmerType {

    /**
     * Creates a DistinguishedFarmer object with predefined attributes that is passed to the
     * constructor of the abstract class FarmerType.
     */
    public DistinguishedFarmer() {
        super("Distinguished Farmer", 10, 2, 2,
                1, 0, 300);
    }
}

/**
 * RegisteredFarmer class represents a registered farmer type that extends the FarmerType class.
 */
public class RegisteredFarmer extends FarmerType {

    /**
     * Creates a RegisteredFarmer object with predefined attributes that is passed to the
     * constructor of the abstract class FarmerType.
     */
    public RegisteredFarmer() {
        super("Registered Farmer", 5, 1, 1,
                0, 0, 200);
    }
}

public class VehiclesGreenInt extends VehiclesEnabled {

    public VehiclesGreenInt(Context context) {
        super(false);
        System.out.println("VehicleGreenInt: waiting for pedestrian to signal");
    }

    @Override
    public void pedestrianWaiting(Context context) {
        context.setState(new VehiclesYellow(context));
    }
}



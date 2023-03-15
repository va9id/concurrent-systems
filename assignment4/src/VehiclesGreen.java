public class VehiclesGreen extends VehiclesEnabled {

    private boolean isPedestrianWaiting;

    public VehiclesGreen(Context context, boolean signalDuringFlash) {
        super(true);
        isPedestrianWaiting = signalDuringFlash;
        System.out.println("VehicleGreen: light is green for cars");
        timeout(context);
    }

    @Override
    public void timeout(Context context) {
        System.out.println("\tTIMEOUT event received internally");
        Thread greenThread = new Thread (){
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (getPedestrianWaiting()) {
                    context.setState(new VehiclesYellow(context));
                } else {
                    context.setState(new VehiclesGreenInt(context));
                }
            }
        };
        greenThread.start();
    }

    @Override
    public synchronized void pedestrianWaiting(Context context) { isPedestrianWaiting = true; }


    public synchronized boolean getPedestrianWaiting() {
        return isPedestrianWaiting;
    }
}
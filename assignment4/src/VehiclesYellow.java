public class VehiclesYellow extends VehiclesEnabled {

    public VehiclesYellow(Context context){
        super(false);
        System.out.println("VehicleYellow: light is yellow for cars");
        timeout(context);
    }

    @Override
    public void timeout(Context context) {
        System.out.println("\tTIMEOUT event received internally");
        Thread yellowThread = new Thread (){
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                context.setState(new PedestriansWalk(context));
            }
        };
        yellowThread.start();
    }
}

public class PedestriansWalk extends PedestriansEnabled {

    public PedestriansWalk(Context context){
        super(true);
        System.out.println("PedestriansWalk: Pedestrians walk");
        timeout(context);
    }

    @Override
    public void timeout(Context context) {
        System.out.println("\tTIMEOUT event received internally");
        Thread walkThread = new Thread (){
            @Override
            public void run() {
                try {
                    Thread.sleep(15000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                context.setState(new PedestriansFlash(context));
            }
        };
        walkThread.start();
    }
}

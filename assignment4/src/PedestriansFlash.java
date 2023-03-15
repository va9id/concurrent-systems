public class PedestriansFlash extends PedestriansEnabled{

    private int pedestrianFlashCtr;
    private boolean pedestrianSignaledDuringFlash;

    public PedestriansFlash(Context context) {
        super(false);
        pedestrianFlashCtr = 7;
        pedestrianSignaledDuringFlash = false;
        System.out.println("PedestriansFlash: pedestrians don't walk, signal is flashing");
        timeout(context);
    }

    @Override
    public void timeout(Context context) {
        System.out.println("\tTIMEOUT event received internally");
        Thread flashThread = new Thread (){
            @Override
            public void run() {
                while(pedestrianFlashCtr > 0) {
                    if ((pedestrianFlashCtr & 1)==0) {
                        System.out.println("\tFLASH ON");
                    } else {
                        System.out.println("\tFLASH OFF");
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    pedestrianFlashCtr -= 1;
                }
                context.setState(new VehiclesGreen(context, getPedestrianSignaledDuringFlash()));
            }
        };
        flashThread.start();
    }

    @Override
    public synchronized void pedestrianWaiting(Context context) {
        pedestrianSignaledDuringFlash = true;
    }

    public synchronized boolean getPedestrianSignaledDuringFlash() {
        return pedestrianSignaledDuringFlash;
    }


}

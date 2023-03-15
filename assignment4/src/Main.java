public class Main {
    public static void main(String[] args) {
        Context c = new Context();
        int i = 1;
        while(i < 4) {
            State s = c.getState();

            if (s instanceof VehiclesGreen && i == 1) {
                c.pedestrianWaiting();
                i += 1;
            }
            else if (s instanceof PedestriansFlash && i == 2) {
                c.pedestrianWaiting();
                i += 1;
            }
            else if (s instanceof VehiclesGreenInt && i == 3) {
                c.pedestrianWaiting();
                i += 1;
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

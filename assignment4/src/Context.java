public class Context {
    private State state;

    public Context() {
        state = new VehiclesGreen(this, false);
    }

    public void timeout() {
        try {
            System.out.println("\tTIMEOUT event received");
            state.timeout(this);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void pedestrianWaiting() {
        try {
            System.out.println("\tPEDESTRIAN_WAITING event received");
            state.pedestrianWaiting(this);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void setState(State s) {
        state = s;
    }

    public synchronized State getState() { return state; }
}

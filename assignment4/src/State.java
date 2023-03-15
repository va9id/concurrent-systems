public abstract class State {

    public void timeout(Context context) throws Exception {
        throw new Exception("timeout() cannot be called from " + this.getClass().getName());
    }

    public void pedestrianWaiting(Context context) throws Exception {
        throw new Exception("pedestrianWaiting() cannot be called from " + this.getClass().getName());
    }
}

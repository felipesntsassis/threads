public class Job extends  Thread {

    private final long initialValue;
    private final long finalValue;
    private long total = 0;

    public Job(int initialValue, int finalValue) {
        this.initialValue = initialValue;
        this.finalValue = finalValue;
    }

    public long getTotal() {
        return total;
    }

    @Override
    public void run() {
        for (long i = initialValue; i <= finalValue; i++) total += i;
    }
}

import java.util.concurrent.Callable;

public class CallableSample implements Callable<String> {

    public final long waitingTime;

    CallableSample(int time) {
        waitingTime = time;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(waitingTime);
        return Thread.currentThread().getName();
    }

}

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AsyncSample {

    private static int sharedVar = 0;
    private static final Integer QUANTITY = 10000;
    private static final List<Integer> VALUES = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < QUANTITY; i++) VALUES.add(++ sharedVar);
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < QUANTITY; i++) VALUES.add(++ sharedVar);
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < QUANTITY; i++) VALUES.add(++ sharedVar);
            }
        });

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        int sum = 0;

        for (Integer value : VALUES) sum += value;

        System.out.println("Soma: " + sum);
    }
}

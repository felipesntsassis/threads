import java.util.*;

public class AsyncSample2 {
    private static int sharedVar = 0;
    private static final Integer QUANTITY = 10000;
    private static final Set<Integer> VALUES = new HashSet<>();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < QUANTITY; i++) {
                    boolean novo = VALUES.add(++sharedVar);
                    if (!novo) System.out.println("Já existe: " + sharedVar);
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < QUANTITY; i++) {
                    boolean novo = VALUES.add(++sharedVar);
                    if (!novo) System.out.println("Já existe: " + sharedVar);
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < QUANTITY; i++) {
                    boolean novo = VALUES.add(++sharedVar);
                    if (!novo) System.out.println("Já existe: " + sharedVar);
                }
            }
        }).start();
    }
}

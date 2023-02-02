import java.util.ArrayList;
import java.util.List;

// Nota:O ato de adquirir bloqueios para sincronizar threads consome tempo,mesmo quando nenhuma precisa aguardar a
// liberação do objeto sincronizado.Esse processo é uma faca de dois gumes:se por um lado ele resolve problemas de
// concorrência,por outro serializa o processamento das threads sobre esse bloco;ou seja,as threads nunca estarão
// processando esse código simultaneamente,o que pode degradar o desempenho.Portanto,esse recurso deve ser usado com
// moderação e somente onde for necessário.

public class SyncMethodSample {
    private static int sharedVar = 0;
    private static final Integer QUANTITY = 10000;
    private static final List<Integer> VALUES = new ArrayList<>();

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < QUANTITY; i++) incrementAndAdd();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < QUANTITY; i++) incrementAndAdd();
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < QUANTITY; i++) incrementAndAdd();
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

    private synchronized static void incrementAndAdd() {
        VALUES.add(++sharedVar);
    }

}

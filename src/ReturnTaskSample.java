import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReturnTaskSample {

    public static void main(String[] args) {
        List<CallableSample> tasks = Arrays.asList(
                new CallableSample(8000),
                new CallableSample(4000),
                new CallableSample(6000)
        );
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        ExecutorCompletionService<String> completionService = new ExecutorCompletionService<>(threadPool);

        System.out.println("Tarefas iniciadas, aguardando a conclusão");
        // executing tasks
        for (CallableSample task : tasks) completionService.submit(task);

        // wait and print return of each one
        for (int i = 0; i < tasks.size(); i ++) {
            try {
                System.out.println(completionService.take().get());
            } catch (InterruptedException | ExecutionException ex) {
                ex.printStackTrace();
            }
        }

        threadPool.shutdown();
    }
}

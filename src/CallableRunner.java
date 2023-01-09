import java.util.concurrent.*;

public class CallableRunner {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<String> welcomeFuture =  executorService.submit(new CallableTask("in28minutes"));

        System.out.println("\nnew CallableTask(\"in28minutes\")");

        String welcomeMessage = welcomeFuture.get();
        System.out.print(welcomeMessage);
        System.out.println("\nMain completed");
    }
}

class CallableTask implements Callable<String>{

    private String name;
    public CallableTask(String name) {
        this.name= name;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return "Hello " +name;
    }
}

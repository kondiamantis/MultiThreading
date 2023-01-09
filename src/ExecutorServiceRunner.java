import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceRunner {
    public static void main(String[] args) {
        //One thread at a time, next thread starts after first is finished
        //ExecutorService executorService = Executors.newSingleThreadExecutor();

        //n threads active at any point in time
        ExecutorService executorService = Executors.newFixedThreadPool(3);


        executorService.execute(new Task(1));
        executorService.execute(new Task(2));
        executorService.execute(new Task(3));
        executorService.execute(new Task(4));


        executorService.shutdown();

    }
}

class Task extends Thread{
    private int number;


    public Task(int number){
        this.number =number;

    }

    public void run(){//SIGNATURE
        System.out.println("\nTask " + number +" Started");
        for (int i=number*100; i<=number*100+99;i++){
            System.out.print(i +" ");
        }

        System.out.println("\nTask " +number + "Done");
    }
}

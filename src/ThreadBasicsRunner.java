public class ThreadBasicsRunner {

    public static void main(String[] args) throws InterruptedException {
        //Task1
        System.out.println("\nTask1 Kicked off");
        Task1 task1 = new Task1();
        task1.setPriority(1);
        task1.start();

        //Task2
        System.out.println("\nTask2 Kicked off");
        Task2 task2 = new Task2();
        Thread task2Thread = new Thread(task2);
        task2Thread.setPriority(10);
        task2Thread.start();

        //wait for task1,task2 to complete before starting task3
        task1.join();
        task2Thread.join();


        //Task3
        for (int i=301; i<=399;i++){
            System.out.print(i +" ");
        }

        System.out.println("\nTask3 done");

        System.out.println("\nMain done");
    }
}

class Task1 extends Thread{
    public void run(){//SIGNATURE
        System.out.println("\nTask1 Started");
        for (int i=101; i<=199;i++){
            System.out.print(i +" ");
        }

        System.out.println("\nTask1 done");
    }
}

class Task2 implements Runnable{
    @Override
    public void run() {
        System.out.println("\nTask2 Started");

        for (int i=201; i<=299; i++){
            System.out.print(i +" ");
        }
        System.out.println("\nTask2 Done");

    }


}

package Threading;

class MyTask implements Runnable{
    @Override
    public void run() {
        for(int i=0; i<10; i++){
            System.out.println("ID: " + i);
        }
    }
}

class YourTask implements Runnable{
    @Override
    public void run() {
        for(int i=0; i<10; i++){
            System.out.println("Code: " + i);
        }
    }
}

public class Thread_using_Runnable_Interface {
    public static void main(String [] args){
        System.out.println("Application started.");

        Runnable obj = new MyTask();
        Thread task = new Thread(obj);
        task.start();
        Thread task2 = new Thread(new YourTask());
        task2.start();

        for(int i=0; i<10; i++){
            System.out.println("Roll: " + i);
        }

        System.out.println("Application finished.");
    }
}

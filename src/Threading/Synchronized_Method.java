package Threading;

public class Synchronized_Method {
    private static int count = 0;

    /* synchronized method ইউজ করলে thread1 এবং thread2 সম্পূর্ণ লুপ এর টাস্ক সম্পন্ন করে */
    /* কারণ synchronized method একটি thread এর কাজ শেষ না হওয়া পর্যন্ত method কে লক করে রাখে */
    static synchronized void countNumber(){
        count++;
    }

    public static void main(String[] args){
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<10000; i++){
                    countNumber();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<10000; i++){
                    countNumber();
                }
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Total count: " + count);
    }
}

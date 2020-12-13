package Threading;

public class BasicThread_using_Thread_Class extends Thread {
    public void run(){
        for(int i=0; i<10; i++) {
            System.out.print(i + " ");
        }
    }

    static class class2 extends Thread {
        public void run(){
            for(int i=10; i>0; i--) {
                System.out.print(i + " ");
            }
        }
    }

    static class class3 extends Thread {
        public void run(){
            for(int i=1; i<=10; i++) {
                for(int j=10; j>=i; j--){
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }

    public static void main(String [] args){
        BasicThread_using_Thread_Class obj1 = new BasicThread_using_Thread_Class();
        class2 obj2 = new class2();
        class3 obj3 = new class3();

        obj1.start();
        obj2.start();
        obj3.start();
    }
}

package Threading;
import java.util.Scanner;

class Printer{
    /* synchronized method printDocument */
    /* কারণ synchronized method একটি thread এর কাজ শেষ না হওয়া পর্যন্ত method কে লক করে রাখে */
//    synchronized void printDocument(int docNo, String docName){
    void printDocument(int docNo, String docName){
        for(int i=1; i<=docNo; i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Document name: " + docName + ", Document no. " + i);
        }
    }
}

class MyThread extends Thread{
    Printer printerRef;
    MyThread(Printer pRef){
        printerRef = pRef;
    }

    @Override
    public void run() {
        /* synchronized block until it is finished */
        /* কারণ synchronized method একটি thread এর কাজ শেষ না হওয়া পর্যন্ত method কে লক করে রাখে */
        synchronized (printerRef){
            printerRef.printDocument(5, "My file.exe");
        }
    }
}

class YourThread extends Thread{
    Printer printerRef;
    YourThread(Printer pRef){
        printerRef = pRef;
    }

    @Override
    public void run() {
        /* synchronized block until it is finished */
        /* কারণ synchronized method একটি thread এর কাজ শেষ না হওয়া পর্যন্ত method কে লক করে রাখে */
        synchronized (printerRef){
            printerRef.printDocument(5, "Your file.exe");
        }
    }
}

public class Synchronized_Thread {
    public static void main(String[] args){
        System.out.println("Application started.");

        Printer obj = new Printer();
        MyThread obj2 = new MyThread(obj);
        YourThread obj3 = new YourThread(obj);
        obj2.start();
        /* join() method helps to block thread object execution until it is finished */
        try {
            obj2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        obj3.start();

        System.out.println("Application finished.");
    }
}

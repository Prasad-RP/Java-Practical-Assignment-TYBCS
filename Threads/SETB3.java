import java.util.*;

class FirstThread extends Thread {

    Random r = new Random();
    public int n;

    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                n = r.nextInt(10);
                System.out.println("Generated Random Number : " + n);

                if (n % 2 == 0) {
                    SecondThread t2 = new SecondThread(n);
                    t2.start();
                } else {
                    ThirdThread t3 = new ThirdThread(n);
                    t3.start();
                }
                sleep(1000);
            }
        } // try
        catch (Exception e) {
            e.printStackTrace();
        }

    }// run
}// class FirstThread

class SecondThread extends Thread {
    int square;

    SecondThread(int n) {
        square = n * n;
    }

    public void run() {
        try {
            System.out.println("Square OF Number: " + square);

        } // try
        catch (Exception e) {
            e.printStackTrace();
        }

    }// run

}// class second thread

class ThirdThread extends Thread {

    int cube;

    ThirdThread(int n) {
        cube = n * n * n;
    }

    public void run() {
        try {
            System.out.println("Cube OF Number: " + cube);

        } // try
        catch (Exception e) {
            e.printStackTrace();
        }

    }// run

}// class second thread

public class SETB3 {

    public static void main(String arg[]) {

        FirstThread t1 = new FirstThread();

        t1.start();

    }

}

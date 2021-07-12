package javabasics.module4;

/*
 * @author db-ss
 * @email daniel.brashaw@smoothstack.com
**/

public class Deadlock {
    
    private static Object lock1;
    private static Object lock2;

    private static class Thread1 extends Thread {

        @Override
        public void run() {
            lock1 = new Object();
            try {
                synchronized (lock1) {
                    Thread.sleep(1000);
                    synchronized (lock2) {
                        System.out.println("Thread1");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static class Thread2 extends Thread {

        @Override
        public void run() {
            lock2 = new Object();
            try {
                synchronized (lock2) {
                    Thread.sleep(1000);
                    synchronized (lock1) {
                        System.out.println("Thread2");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();

        t1.start();
        t2.start();
    }
}

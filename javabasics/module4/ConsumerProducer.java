package javabasics.module4;

import java.util.ArrayList;
import java.util.Random;

/*
 * @author db-ss
 * @email daniel.brashaw@smoothstack.com
 * 
 * This is a small program to asynchronously produce and consume Integers.
 * The frequency that they each check/attempt to read/write is in the class
 * definition. A value of 0 means it is "cleared" by the Consumer.
 *
**/


public class ConsumerProducer {

    private static final Integer size = 10;
    private static ArrayList<Integer> aList = new ArrayList<>();
    private static Random r = new Random();

    private static class Consumer extends Thread {

        private final Integer readSpeed = 2000; // much slower than the producer
                                                // in usec

        // try to read all the fields
        // but do it "slowly"
        @Override
        public void run() {
            try {
                while (true) {
                    for (int i = 0; i < size; i++) {
                        Thread.sleep(readSpeed);
                        if (aList.get(i) != 0) {
                            System.out.println("Read " + aList.get(i) + " at " + i);
                            synchronized (aList) {
                                aList.set(i, 0);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    // write values randomly, attempting some number of times
    // if we fail to write something new, go to sleep for sleepValue
    private static class Producer extends Thread {

        private final Integer writeSpeed = 300; 
        private final Integer longSleep = 10000; // a value to force the Producer
                                                 // to take a break in usec

        @Override
        public void run() {
            Integer attempts, randIdx;
            try {
                while (true) {
                    attempts = size;
                    for (int i = 0; i < size; i++) {
                        Thread.sleep(writeSpeed);
                        randIdx = r.nextInt(size);
                        if (aList.get(randIdx) != 0) {
                            attempts--;
                        } else {
                            synchronized (aList) {
                                System.out.println("Writing something at " + randIdx);
                                aList.set(randIdx, r.nextInt());
                            }
                        }
                    }
                    // if we tried to write to 10 places randomly, but didn't write
                    // anything new, give up to allow the Consumer to catch up
                    if (attempts == 0) {
                        System.out.println("Producer taking a break!");
                        Thread.sleep(longSleep);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    public static void main(String[] args) {

        // Initialize the ArrayList to zeroes
        for (int i = 0; i < size; i++) {
            aList.add(0);
        }

        Producer p = new Producer();
        Consumer c = new Consumer();
        p.start();
        c.start();
    }
    
}

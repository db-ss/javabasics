package javabasics.module1;

import java.lang.Math;
import java.util.Random;
import java.util.Scanner;

/*
 * @author db-ss
 * @email daniel.brashaw@smoothstack.com
**/

public class Assignment2 {

    private final int MAX_GUESSES = 5;
    // the amount to be close enough to validated as succeeding
    private final int THRESHOLD   = 10;
    private int guessesAllowed;
    private int answer;

    public Assignment2() {

        this.guessesAllowed = MAX_GUESSES;
        Random r = new Random();
        this.answer = r.nextInt(100) + 1;
    }

    private void run() {

        boolean done = false, correct = false;
        Scanner sc = new Scanner(System.in);

        System.out.println("Please guess an integer in 1-100, inclusive");

        while (!done) {
            if (sc.hasNextInt()) {
                correct = attemptGuess(sc.nextInt());
                // sc.nextLine() -- optionally, consume the remaining string(s)
                if (!correct) {
                    System.out.println("Please guess again");
                }
            } else {
                sc.nextLine(); // skip invalid lines of input
                System.out.println("Please guess an integer in 1-100, inclusive");
            }
            if (guessesAllowed == 0 || correct) {
                done = true;
            }
        }
        sc.close();

        if (correct) {
            System.out.println("Good job! The correct answer was " + this.answer);
        } else {
            System.out.println("Sorry, the correct answer was " + this.answer);
        }
    }

    private boolean attemptGuess(int guessVal) {

        guessesAllowed--;
        return Math.abs(guessVal - this.answer) <= THRESHOLD;
    }

    public static void main(String[] args) {

        Assignment2 a2 = new Assignment2();
        a2.run();
    }
}
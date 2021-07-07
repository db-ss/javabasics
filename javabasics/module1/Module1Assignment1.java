package javabasics.module1;

/*
 * @author db-ss
 * @email daniel.brashaw@smoothstack.com
**/

public class Module1Assignment1 {

    // The number of spaces to delimit the offset center of the pattern
    private final int CENTER_LINE = 5;
    // The number of periods to write when breaking lines
    private int minPeriods = 9;
    
    private void run() {

        System.out.println("1)");
        for (int i = 1; i <= 4; i++) {
            writeStars(i);
        }

        periodBreak();
        System.out.println("2)");
        periodBreak();

        for (int i = 4; i >= 1; i--) {
            writeStars(i);
        }

        System.out.println("3)");
        for (int i = 1; i <= 7; i += 2) {
            writeCenteredStars(i);
        }

        periodBreak();
        System.out.println("4)");
        periodBreak();

        for (int i = 7; i >= 1; i -= 2) {
            writeCenteredStars(i);
        }
    }

    private void writeStars(int numStars) {

        for (int i = 0; i < numStars; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    private void periodBreak() {

        for (int i = 0; i < minPeriods; i++) {
            System.out.print(".");
        }
        System.out.println();
        minPeriods++;
    }

    private void writeCenteredStars(int numStars) {

        int spacesToWrite = numStars / 2 > CENTER_LINE ? 0 : CENTER_LINE - numStars / 2;
        for (int i = 0; i < spacesToWrite; i++) {
            System.out.print(" ");
        }
        for (int i = 0; i < numStars; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Module1Assignment1 a1 = new Module1Assignment1();
        a1.run();
    }
}

/*
 * Print the pattern below (without the leading asterisk)
 * 
 * 1)
 * *
 * **
 * ***
 * ****
 * .........
 * 2)
 * ..........
 * ****
 * ***
 * **
 * *
 * 3)
 *      *
 *     ***
 *    *****
 *   *******
 * ...........
 * 4)
 * ............
 *   *******
 *    *****
 *     ***
 *      *
**/

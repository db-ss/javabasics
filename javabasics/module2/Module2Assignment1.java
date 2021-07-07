package javabasics.module2;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Optional;
import java.util.Scanner;

/*
 * @author db-ss
 * @email daniel.brashaw@smoothstack.com
**/

public class Module2Assignment1 {

    private final int NUM_PROMPTS = 5;

    // Given some (potentially) valid numbers in the arguments, sum them and display the value
    private void run(String[] args) {

        Double sum = 0.0;
        Optional<Number> val = null;
        for (String s : args) {
            val = parseNumber(s);
            if (val.isPresent()) {
                sum += val.get().doubleValue();
            }
        }
        System.out.println("Sum: " + sum);
    }

    // With no command arguments, request NUM_PROMPTS of numbers to sum and display the value
    private void run() {

        int remainingPrompts = NUM_PROMPTS;
        Double sum = 0.0;
        Optional<Number> val = null;
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        System.out.println("Please enter " + NUM_PROMPTS + " numbers to sum");

        while (remainingPrompts > 0) {
            sb.append(sc.next());
            val = parseNumber(sb.toString());
            if (val.isPresent()) {
                sum += val.get().doubleValue();
                remainingPrompts--;
            }
            sb.setLength(0);
        }

        sc.close();
        System.out.println("Sum: " + sum);
    }

    private Optional<Number> parseNumber(String s) {

        NumberFormat nf = NumberFormat.getInstance();
        Number num = null;

        try {
            num = nf.parse(s);
        } catch (ParseException e) {
            System.out.println(s + " is not a valid Number, skipping");
        }

        return Optional.of(num);
    }

    /*
     * If no arguments are given, the program will prompt NUM_PROMPTS 
     * (default = 5) times for numbers via stdin,
     * otherwise it will sum the command line values and print the sum.
    **/
    public static void main(String[] args) {
        
        Module2Assignment1 a1 = new Module2Assignment1();
        if (args.length == 0) {
            a1.run();
        } else {
            a1.run(args);
        }
    }
}

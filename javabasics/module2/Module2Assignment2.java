package javabasics.module2;

import java.util.Random;

/*
 * @author db-ss
 * @email daniel.brashaw@smoothstack.com
**/

public class Module2Assignment2 {

    private final int X_DIM = 10;
    private final int Y_DIM = 10;
    private Integer matrix[][];

    public Module2Assignment2() {

        Random r = new Random();
        matrix = new Integer[Y_DIM][X_DIM];

        for (int i = 0; i < Y_DIM; i++) {
            for (int j = 0; j < X_DIM; j++) {
                matrix[i][j] = r.nextInt(100) + 1;
            }
        }
    }

    private void printMax() {

        Integer max = 0;
        int xMaxPos = -1, yMaxPos = -1;
        for (int i = 0; i < Y_DIM; i++) {
            for (int j = 0; j < X_DIM; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                    yMaxPos = i;
                    xMaxPos = j;
                }
            }
        }
        System.out.println("Max value: " + max + " at (" + xMaxPos + ", " + yMaxPos + ")");
    }

    private void printMatrix() {

        for (int i = 0; i < Y_DIM; i++) {
            for (int j = 0; j < X_DIM; j++) {
                if (matrix[i][j] < 10) {
                    System.out.print("  ");
                } else if (matrix[i][j] < 100) {
                    System.out.print(" ");
                }
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Module2Assignment2 a2 = new Module2Assignment2();
        a2.printMatrix();
        a2.printMax();
    }
}

package processor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();
        int m1 = scanner.nextInt();
        int[][] matrix1 = new int[n1][m1];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                matrix1[i][j] = scanner.nextInt();
            }
        }

        int n2 = scanner.nextInt();
        int m2 = scanner.nextInt();
        int[][] matrix2 = new int[n2][m2];
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                matrix2[i][j] = scanner.nextInt();
            }
        }

        if (n1 == n2 && m1 == m2) {
            int[][] matrixSum = sumMatrices(matrix1, matrix2);
            print(matrixSum);
        } else {
            System.out.println("ERROR");
        }
    }

    static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[][] sumMatrices(int[][] matrix1, int[][] matrix2) {
        int[][] matrixSum = new int[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                matrixSum[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return matrixSum;
    }
}

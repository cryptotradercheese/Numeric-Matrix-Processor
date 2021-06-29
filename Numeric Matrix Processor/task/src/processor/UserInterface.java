package processor;

import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner = new Scanner(System.in);
    double[][] matrixInit(int row, int column) {
        final Scanner scanner = new Scanner(System.in);

        double[][] matrix = new double[row][column];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }

        return matrix;
    }

    void print(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    void showMenu() {
        System.out.println("1. Add matrices");
        System.out.println("2. Multiply matrix by a constant");
        System.out.println("3. Multiply matrices");
        System.out.println("4. Transpose matrix");
        System.out.println("5. Calculate a determinant");
        System.out.println("6. Inverse matrix");
        System.out.println("0. Exit");
    }

    void showTransposeMenu() {
        System.out.println("1. Main diagonal");
        System.out.println("2. Side diagonal");
        System.out.println("3. Vertical line");
        System.out.println("4. Horizontal line");
        System.out.println("");
    }

    double[][] readOneMatrix() {
        System.out.print("Enter size of matrix: ");
        int n1 = scanner.nextInt();
        int m1 = scanner.nextInt();
        System.out.println("Enter matrix:");
        double[][] matrix1 = matrixInit(n1, m1);

        return matrix1;
    }

    double[][][] readTwoMatrices() {
        System.out.print("Enter size of first matrix: ");
        int n1 = scanner.nextInt();
        int m1 = scanner.nextInt();
        System.out.println("Enter first matrix:");
        double[][] matrix1 = matrixInit(n1, m1);

        System.out.print("Enter size of second matrix: ");
        int n2 = scanner.nextInt();
        int m2 = scanner.nextInt();
        System.out.println("Enter second matrix:");
        double[][] matrix2 = matrixInit(n2, m2);

        return new double[][][] {matrix1, matrix2};
    }
}
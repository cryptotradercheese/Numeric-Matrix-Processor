package processor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        MatrixOperations operations = new MatrixOperations();
        UserInterface userInterface = new UserInterface();

        while (true) {
            userInterface.showMenu();
            System.out.print("Your choice: ");
            System.out.println();
            int option = scanner.nextInt();

            if (option == 0) {
                break;
            }

            double[][][] matrices;
            double[][] matrix;
            double[][] resultMatrix = new double[0][0];
            switch (option) {
                case 1:
                    matrices = userInterface.readTwoMatrices();
                    resultMatrix = operations.addMatrices(matrices[0], matrices[1]);
                    break;
                case 2:
                    matrix = userInterface.readOneMatrix();
                    System.out.print("Enter constant: ");
                    double constant = scanner.nextDouble();
                    resultMatrix = operations.multiplyMatrix(matrix, constant);
                    break;
                case 3:
                    matrices = userInterface.readTwoMatrices();
                    resultMatrix = operations.multiplyMatrices(matrices[0], matrices[1]);
                    break;
                case 4:
                    userInterface.showTransposeMenu();

                    System.out.print("Your choice: ");
                    int transposeOption = scanner.nextInt();
                    matrix = userInterface.readOneMatrix();

                    switch (transposeOption) {
                        case 1:
                            resultMatrix = operations.transposeMain(matrix);
                            break;
                        case 2:
                            resultMatrix = operations.transposeSide(matrix);
                            break;
                        case 3:
                            resultMatrix = operations.transposeVertical(matrix);
                            break;
                        case 4:
                            resultMatrix = operations.transposeHorizontal(matrix);
                            break;
                    }

                    break;
                case 5:
                    matrix = userInterface.readOneMatrix();
                    resultMatrix = new double[][] {{operations.calculateDeterminant(matrix)}};
                    break;
                case 6:
                    matrix = userInterface.readOneMatrix();
                    resultMatrix = operations.inverseMatrix(matrix);
                    break;
            }

            System.out.println("The result is:");
            userInterface.print(resultMatrix);
        }
    }
}

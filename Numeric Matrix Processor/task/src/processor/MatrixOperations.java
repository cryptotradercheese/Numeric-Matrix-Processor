package processor;

import java.util.Arrays;

public class MatrixOperations {
    double[][] addMatrices(double[][] matrix1, double[][] matrix2) {
        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
            throw new IllegalArgumentException("Different matrices dimensions");
        }

        double[][] matrixSum = new double[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                matrixSum[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return matrixSum;
    }

    double[][] multiplyMatrix(double[][] matrix, double constant) {
        double[][] matrixMultiplication = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrixMultiplication.length; i++) {
            for (int j = 0; j < matrixMultiplication[0].length; j++) {
                matrixMultiplication[i][j] = matrix[i][j] * constant;
            }
        }

        return matrixMultiplication;
    }

    double[][] multiplyMatrices(double[][] matrix1, double[][] matrix2) {
        if (matrix1[0].length != matrix2.length) {
            throw new IllegalArgumentException("Matrices can't be multiplied");
        }

        double[][] matricesMultiplication = new double[matrix1.length][matrix2[0].length];
        for (int i = 0; i < matricesMultiplication.length; i++) {
            for (int j = 0; j < matricesMultiplication[0].length; j++) {
                double element = 0;
                for (int k = 0; k < matrix1[0].length; k++) {
                    element += matrix1[i][k] * matrix2[k][j];
                }
                matricesMultiplication[i][j] = element;
            }
        }

        return matricesMultiplication;
    }

    double[][] transposeMain(double[][] matrix) {
        double[][] resultMatrix = new double[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                resultMatrix[j][i] = matrix[i][j];
            }
        }

        return resultMatrix;
    }

    double[][] transposeSide(double[][] matrix) {
        double[][] resultMatrix = new double[matrix[0].length][matrix.length];
        for (int i = 0; i < resultMatrix.length; i++) {
            for (int j = 0; j < resultMatrix[0].length; j++) {
                resultMatrix[i][j] = matrix[matrix.length - 1 - j][matrix[0].length - 1 - i];
            }
        }

        return resultMatrix;
    }

    double[][] transposeVertical(double[][] matrix) {
        double[][] resultMatrix = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < resultMatrix.length; i++) {
            for (int j = 0; j < resultMatrix[0].length; j++) {
                resultMatrix[i][j] = matrix[i][matrix[0].length - 1 - j];
            }
        }

        return resultMatrix;
    }

    double[][] transposeHorizontal(double[][] matrix) {
        double[][] resultMatrix = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < resultMatrix[0].length; i++) {
            for (int j = 0; j < resultMatrix.length; j++) {
                resultMatrix[j][i] = matrix[matrix.length - 1 - j][i];
            }
        }

        return resultMatrix;
    }

    double [][] getMatrixForMinor(double[][] matrix, int row, int column) {
        double[][] matrixForMinor = new double[matrix.length - 1][matrix[0].length - 1];

        for (int i = 0, k = 0; i < matrix.length; i++, k++) {
            if (i == row) {
                k--;
                continue;
            }

            for (int j = 0, l = 0; j < matrix[0].length; j++, l++) {
                 if (j == column) {
                    l--;
                    continue;
                }

                matrixForMinor[k][l] = matrix[i][j];
            }
        }

        return matrixForMinor;
    }

    double calculateDeterminant(double[][] matrix) {
        // trivial base case
        if (matrix.length == 1 && matrix[0].length == 1) {
            return matrix[0][0];
        }

        double determinant = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            // reduction step
            double minor = calculateDeterminant(getMatrixForMinor(matrix, 0, i));
            double cofactor = Math.pow(-1, 1 + i + 1) * minor;
            determinant += matrix[0][i] * cofactor;
        }

        return determinant;
    }

    double[][] inverseMatrix(double[][] matrix) {
        double determinant = calculateDeterminant(matrix);
        if (determinant == 0) {
            throw new IllegalArgumentException("Inverse matrix doesn't exist");
        }

        double[][] cofactorsMatrix = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                double minor = calculateDeterminant(getMatrixForMinor(matrix, i, j));
                double cofactor = Math.pow(-1, i + 1 + j + 1) * minor;
                cofactorsMatrix[i][j] = cofactor;
            }
        }

        return multiplyMatrix(transposeMain(cofactorsMatrix), 1 / determinant);
    }
}
package edu.sjsu.assignment2;

import java.util.Arrays;

public class Matrix {
    private int[][] matrix;
    private int width;
    private int height;

    public Matrix(int[][] matrix) {
        this.matrix = new int[matrix.length][];
        for(int i = 0; i < matrix.length; ++i) {
            this.matrix[i] = Arrays.copyOf(matrix[i], matrix[i].length);
        }
        height = matrix.length;
        width = matrix[0].length;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public Matrix multiply(Matrix b) {
        Matrix a = this;
        //depth assumed to be equal to matrixB.length
        //rows of the first times column of the second
        int[][] product = new int[a.height][b.width];

        for(int i = 0; i < a.height; ++i) {
            for (int j = 0; j < b.width; ++j) {
                int sum = 0;
                for (int k = 0; k < a.width; ++k) {
                    sum += a.matrix[i][k] * b.matrix[k][j];
                }
                product[i][j] = sum;
            }
        }

        return new Matrix(product);
    }
}

package edu.sjsu.assignment2;

import java.util.Arrays;


/**
 * Matrix implements a class for basic 2D integer matrices
 */
public class Matrix {
    private final int[][] matrix;
    private final int width;
    private final int height;

    /**
     * Constructor for Matrix
     *
     * @param matrix int[][] - a valid matrix to initialize the object
     */
    public Matrix(int[][] matrix) {
        this.matrix = new int[matrix.length][];
        for (int i = 0; i < matrix.length; ++i) {
            this.matrix[i] = Arrays.copyOf(matrix[i], matrix[i].length);
        }
        height = matrix.length;
        width = matrix[0].length;
    }

    /**
     * getMatrix returns the matrix as an array of integer arrays
     *
     * @return int[][] - the matrix stored in this Matrix
     */
    public int[][] getMatrix() {
        return matrix;
    }

    /**
     * multiply performs matrix multiplication, assumes valid inputs
     *
     * @param b Matrix - second matrix
     * @return Matrix - product of this matrix and b
     */
    public Matrix multiply(Matrix b) {
        Matrix a = this;
        //depth assumed to be equal to matrixB.length
        //rows of the first times column of the second
        int[][] product = new int[a.height][b.width];

        for (int i = 0; i < a.height; ++i) {
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

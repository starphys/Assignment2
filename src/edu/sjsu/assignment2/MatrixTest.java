package edu.sjsu.assignment2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {
    @Test
    public void test_matrix_multiply_2by2() {
        int[][] array1 = new int[][]{{2, 4}, {3, 4}};
        int[][] array2 = new int[][]{{1, 2}, {1, 3}};
        Matrix matrix1 = new Matrix(array1);
        Matrix matrix2 = new Matrix(array2);
        Matrix resultMatrix = matrix1.multiply(matrix2);
        int[][] resultArray = resultMatrix.getMatrix();

        int[][] expectedResult = new int[][]{{6, 16}, {7, 18}};

        Assertions.assertArrayEquals(expectedResult[0], resultArray[0]);
        Assertions.assertArrayEquals(expectedResult[1], resultArray[1]);
    }

    @Test
    public void test_matrix_multiply_3by3() {
        int[][] array1 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] array2 = new int[][]{{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
        Matrix matrix1 = new Matrix(array1);
        Matrix matrix2 = new Matrix(array2);
        Matrix resultMatrix = matrix1.multiply(matrix2);
        int[][] resultArray = resultMatrix.getMatrix();

        int[][] expectedResult = new int[][]{{30, 24, 18}, {84, 69, 54}, {138, 114, 90}};

        Assertions.assertArrayEquals(expectedResult[0], resultArray[0]);
        Assertions.assertArrayEquals(expectedResult[1], resultArray[1]);
        Assertions.assertArrayEquals(expectedResult[2], resultArray[2]);
    }

    @Test
    public void test_matrix_multiply_rectangles() {
        int[][] array1 = new int[][]{{1, 2}, {3, 4}, {5, 6}};
        int[][] array2 = new int[][]{{1}, {2}};
        Matrix matrix1 = new Matrix(array1);
        Matrix matrix2 = new Matrix(array2);
        Matrix resultMatrix = matrix1.multiply(matrix2);
        int[][] resultArray = resultMatrix.getMatrix();

        int[][] expectedResult = new int[][]{{5}, {11}, {17}};

        Assertions.assertArrayEquals(expectedResult[0], resultArray[0]);
        Assertions.assertArrayEquals(expectedResult[1], resultArray[1]);
        Assertions.assertArrayEquals(expectedResult[2], resultArray[2]);
    }
}
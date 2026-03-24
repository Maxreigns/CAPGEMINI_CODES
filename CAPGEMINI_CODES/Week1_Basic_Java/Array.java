package capgemeini_training;

public class Assignment_19Jan_Array {
    public static void main(String[] args) {

        // Ques1: Read and print a matrix of size m × n.
        int m = 3, n = 4;
        int matrix[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };

        System.out.println("Matrix of size " + m + "x" + n + ":");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        // Ques2:Find the sum of all elements of a matrix.
        int a[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int b[][] = { { 9, 8, 7 }, { 6, 5, 4 }, { 3, 2, 1 } };
        int sum[][] = new int[3][3];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                sum[i][j] = a[i][j] + b[i][j];
            }
        }
        for (int i = 0; i < sum.length; i++) {
            for (int j = 0; j < sum[i].length; j++) {
                System.out.print(sum[i][j] + " ");
            }
            System.out.println();
        }
        // Find the sum of each row of a matrix.
        int matrix1[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        for (int i = 0; i < matrix1.length; i++) {
            int rowSum = 0;
            for (int j = 0; j < matrix1[i].length; j++) {
                rowSum += matrix1[i][j];
            }
            System.out.println("Sum of row " + (i + 1) + ": " + rowSum);
        }

        // Ques4: Find the sum of each column of a matrix.
        int matrix2[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        for (int j = 0; j < matrix2[0].length; j++) {
            int colSum = 0;
            for (int i = 0; i < matrix2.length; i++) {
                colSum += matrix2[i][j];
            }
            System.out.println("Sum of column " + (j + 1) + ": " + colSum);
        }

        // Ques5: Find the maximum and minimum element in a matrix.
        int matrix3[][] = { { 3, 5, 1 }, { 9, 2, 6 }, { 4, 8, 7 } };
        int max = matrix3[0][0];
        int min = matrix3[0][0];
        for (int i = 0; i < matrix3.length; i++) {
            for (int j = 0; j < matrix3[i].length; j++) {
                if (matrix3[i][j] > max) {
                    max = matrix3[i][j];
                }
                if (matrix3[i][j] < min) {
                    min = matrix3[i][j];
                }
            }
        }
        System.out.println("Maximum element: " + max);
        System.out.println("Minimum element: " + min);

        // Ques6: Count even and odd elements in a matrix.
        int matrix4[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int evenCount = 0;
        int oddCount = 0;
        for (int i = 0; i < matrix4.length; i++) {
            for (int j = 0; j < matrix4[i].length; j++) {
                if (matrix4[i][j] % 2 == 0) {
                    evenCount++;
                } else {
                    oddCount++;
                }
            }
        }
        System.out.println("Even count: " + evenCount);
        System.out.println("Odd count: " + oddCount);

        // Ques 7:Search for a given element in a matrix.
        int matrix5[][] = { { 10, 20, 30 }, { 40, 50, 60 }, { 70, 80, 90 } };
        int target = 50;
        boolean found = false;
        for (int i = 0; i < matrix5.length; i++) {
            for (int j = 0; j < matrix5[i].length; j++) {
                if (matrix5[i][j] == target) {
                    found = true;
                    break;
                }
            }
        }
        if (found) {
            System.out.println("Element " + target + " found in the matrix.");
        } else {
            System.out.println("Element " + target + " not found in the matrix.");
        }
        // Ques8: Print the matrix in reverse order.
        int matrix6[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println("Matrix in reverse order:");
        for (int i = matrix6.length - 1; i >= 0; i--) {
            for (int j = matrix6[i].length - 1; j >= 0; j--) {
                System.out.print(matrix6[i][j] + " ");
            }
            System.out.println();
        }
        // Ques 9: Count total number of zero elements in a matrix.
        int matrix7[][] = { { 0, 2, 0 }, { 4, 0, 6 }, { 0, 8, 9 } };
        int zeroCount = 0;
        for (int i = 0; i < matrix7.length; i++) {
            for (int j = 0; j < matrix7[i].length; j++) {
                if (matrix7[i][j] == 0) {
                    zeroCount++;
                }
            }
        }
        System.out.println("Total number of zero elements: " + zeroCount);

        // Ques10: Find the trace of a square matrix.
        int matrix8[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int trace = 0;
        for (int i = 0; i < matrix8.length; i++) {
            trace += matrix8[i][i];
        }
        System.out.println("Trace of the matrix: " + trace);

        // Ques 11: Transpose of a matrix
        int a1[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int t[][] = new int[3][3];
        // transpose logic
        for (int i = 0; i < a1.length; i++) {
            for (int j = 0; j < a1[i].length; j++) {
                t[j][i] = a1[i][j];
            }
        }
        // printing transposed matrix
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                System.out.print(t[i][j] + " ");
            }
            System.out.println();
        }
        // Ques 12: Add two matrices.
        int a2[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int b2[][] = { { 9, 8, 7 }, { 6, 5, 4 }, { 3, 2, 1 } };
        int c2[][] = new int[3][3];
        for (int i = 0; i < a2.length; i++) {
            for (int j = 0; j < a2[i].length; j++) {
                c2[i][j] = a2[i][j] + b2[i][j];
            }
        }
        System.out.println("Sum of two matrices:");
        for (int i = 0; i < c2.length; i++) {
            for (int j = 0; j < c2[i].length; j++) {
                System.out.print(c2[i][j] + " ");
            }
            System.out.println();
        }

        // Ques 13: Subtract two matrices.
        int a3[][] = { { 9, 8, 7 }, { 6, 5, 4 }, { 3, 2, 1 } };
        int b3[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int c3[][] = new int[3][3];
        for (int i = 0; i < a3.length; i++) {
            for (int j = 0; j < a3[i].length; j++) {
                c3[i][j] = a3[i][j] - b3[i][j];
            }
        }
        System.out.println("Subtraction of two matrices:");
        for (int i = 0; i < c3.length; i++) {
            for (int j = 0; j < c3[i].length; j++) {
                System.out.print(c3[i][j] + " ");
            }
            System.out.println();
        }

        // Ques 14: Check whether two matrices are equal.
        int a4[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int b4[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        boolean equal = true;
        for (int i = 0; i < a4.length; i++) {
            for (int j = 0; j < a4[i].length; j++) {
                if (a4[i][j] != b4[i][j]) {
                    equal = false;
                    break;
                }
            }
        }
        if (equal) {
            System.out.println("Matrices are equal.");
        } else {
            System.out.println("Matrices are not equal.");
        }

        // Ques 15: Find the largest element in each row.
        int matrix9[][] = { { 3, 5, 1 }, { 9, 2, 6 }, { 4, 8, 7 } };
        for (int i = 0; i < matrix9.length; i++) {
            int largest = matrix9[i][0];
            for (int j = 1; j < matrix9[i].length; j++) {
                if (matrix9[i][j] > largest) {
                    largest = matrix9[i][j];
                }
            }
            System.out.println("Largest element in row " + i + " is: " + largest);
        }
        // Ques 16: Find the smallest element in each column.
        int matrix10[][] = { { 3, 5, 1 }, { 9, 2, 6 }, { 4, 8, 7 } };
        for (int j = 0; j < matrix10[0].length; j++) {
            int smallest = matrix10[0][j];
            for (int i = 1; i < matrix10.length; i++) {
                if (matrix10[i][j] < smallest) {
                    smallest = matrix10[i][j];
                }
            }
            System.out.println("Smallest element in column " + j + " is: " + smallest);
        }
    }
}
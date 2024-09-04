package CrackingTheCodingInterview.Questions.Chap1ArraysStrings;

import Common.Array;

public class C1Q8_ZeroMatrix {
    public static void main(String[] args) {
        int[][] arr = new int[2][2];
        arr[0][0] = 0;
        arr[0][1] = 1;
        arr[1][0] = 2;
        arr[1][1] = 3;

        C1Q8_ZeroMatrix solution = new C1Q8_ZeroMatrix();
        Array array = new Array();
        array.print2DArrayInteger(arr);
        array.print2DArrayInteger(solution.getZeroMatrix(arr));

    }

    private int[][] getZeroMatrix(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;
        int[][] outArr = new int[rows][cols];

        Array array = new Array();
        array.print2DArrayInteger(outArr);

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (arr[row][col] == 0) {
                    System.out.println(row);
                    System.out.println(col);
                    for (int i = 0; i < rows; i++) {
                        outArr[i][col] = -1;
                    }
                    for (int j = 0; j < cols; j++) {
                        outArr[row][j] = -1;
                    }
                }
            }
        }


        array.print2DArrayInteger(outArr);


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (outArr[i][j] == -1) {
                    outArr[i][j] = 0                    ;
                } else {
                    outArr[i][j] = arr[i][j];
                }
            }

        }

        return outArr;
    }
}

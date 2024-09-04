package CrackingTheCodingInterview.Questions.Chap1ArraysStrings;

import Common.Array;

public class C1Q7_RotateMatrix {
    public static void main(String[] args) {
        int[][] arr = new int[2][2];
        arr[0][0] = 0;
        arr[0][1] = 1;
        arr[1][0] = 2;
        arr[1][1] = 3;

        Array array = new Array();
        array.print2DArrayInteger(arr);

        C1Q7_RotateMatrix solution = new C1Q7_RotateMatrix();
        solution.rotate(arr);
        array.print2DArrayInteger(arr);


    }

    private boolean rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) return false;

        int n = matrix.length;

        // number of layer to move inwards for each rotation
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer; // first index in each layer
            int last = n - 1 - layer; // last index in each layer
            for (int i = first; i < last; i++) {
                int offset = i - first;

                int top = matrix[first][i]; // save top index

                matrix[first][i] = matrix[last - offset][first]; // left -> top
                matrix[last - offset][first] = matrix[last][last - offset]; //bottom -> left
                matrix[last][last - offset] = matrix[i][last]; //right -> bottom
                matrix[i][last] = top; //top -> right
            }
        }
        return true;
    }
}

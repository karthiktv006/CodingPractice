package Common;

public class Array {
    public void print2DArrayInteger(int[][] arr) {
        for (int[] row: arr) {
            for (int val: row) {
                System.out.print(val);
            }
            System.out.println();
        }
        System.out.println();
    }
}

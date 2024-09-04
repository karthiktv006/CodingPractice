package Common;

public class Permutation {
    public static void main(String[] args) {
        String str = "ABC";
        Permutation solution = new Permutation();
        solution.printPermutation(str);
    }

    public void printPermutation(String s) {
        char[] s_array = s.toCharArray();
        char[] out_array = s_array;
        for (int i = 0; i < s_array.length; i++) {
            
            for (int j = i; j < s_array.length; j++) {
                char c1 = s_array[i];
                char c2 = s_array[j];
                out_array[j] = c1;
                out_array[i] = c2;

                String out = new String(out_array);
                System.out.println(out);
            }
        }
    }


 }

package CrackingTheCodingInterview.Questions.Chap1ArraysStrings;
import static java.util.Arrays.sort;

public class C1Q2_CheckPermutation {
    public static void main(String[] args) {
        String s = "java";
        String t = "avga";
        C1Q2_CheckPermutation solution = new C1Q2_CheckPermutation();
        System.out.println(solution.checkPermuteByCharCount(s, t));
        System.out.println(solution.checkPermuteBySort(s, t));
    }

    private boolean checkPermuteByCharCount(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] letters = new int[128];

        char[] s_chararray = s.toCharArray();
        for(char c: s_chararray) {
            letters[c]++;
        }

        for (int i = 0; i < t.length(); i++) {
            int t_char = t.charAt(i);
            letters[t_char]--;
            if(letters[t_char] < 0) return false;
        }

        return true;
    }

    private boolean checkPermuteBySort(String s, String t) {
        if(s.length() != t.length()) return false;

        return sorted(s).equals(sorted(t));
    }

    private String sorted(String s) {
        char[] contents = s.toCharArray();
        sort(contents);
        System.out.println(contents);
        return new String(contents);
    }
}

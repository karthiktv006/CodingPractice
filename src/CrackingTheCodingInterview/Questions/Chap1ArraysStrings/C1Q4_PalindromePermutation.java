package CrackingTheCodingInterview.Questions.Chap1ArraysStrings;

public class C1Q4_PalindromePermutation {
    public static void main(String[] args) {
        String str = "TactCoa";
        C1Q4_PalindromePermutation solution = new C1Q4_PalindromePermutation();
        System.out.println(solution.checkPalindromePermutation(str));
    }

    private boolean checkPalindromePermutation(String s) {
        boolean oddLengthString = s.length() % 2 == 1;
        char[] char_array = s.toCharArray();
        int[] letters = new int[128];
        int even_count = 0;
        int odd_count = 0;

        for (char c : char_array) {
            System.out.println(Character.toLowerCase(c));
            letters[Character.toLowerCase(c)]++;
        }


        for (int letter : letters) {
            if (letter % 2 == 0 && letter != 0) {
                even_count++;
            } else if(letter % 2 == 1){
                odd_count++;
            }
        }
        System.out.println(oddLengthString);
        System.out.println(even_count);
        System.out.println(odd_count);

        if (oddLengthString && odd_count == 1) {
            return true;
        }
        return !oddLengthString && odd_count == 0;

//        for (int i = 0; i < letters.length; i++) {
//            System.out.println(i + ":" + letters[i]);
//        }

    }
}

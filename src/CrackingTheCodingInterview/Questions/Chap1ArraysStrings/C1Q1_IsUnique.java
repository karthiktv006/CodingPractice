package CrackingTheCodingInterview.Questions.Chap1ArraysStrings;

import java.util.HashMap;

public class C1Q1_IsUnique {
    public static void main(String[] args) {
        String str = "abcdefghijkA";
        System.out.println(isUniqueChars(str));
        System.out.println(isUniqueChecker(str));
        System.out.println(isUniqueCheckerBrute(str));


    }

    static boolean isUniqueChars(String s) {
        if (s.length() > 128) return false;

        boolean[] char_set = new boolean[128];
        for (int i = 0; i < s.length(); i++) {
            // type cast from char to int returns ASCII value
            int val = s.charAt(i);
            System.out.println(val);
            if (char_set[val]) {
                return false;
            }
            char_set[val] = true;
        }

        return true;
    }

    // compare by converting to lowercase
    static boolean isUniqueChecker(String s) {
        boolean unique = true;
        HashMap<Character, Integer> letters = new HashMap<Character, Integer>();
        char[] alphabets = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        for (char a : alphabets) {
            letters.put(Character.toLowerCase(a), 0);
        }

        char[] chars = s.toLowerCase().toCharArray();
        for (char c : chars) {
            int count = letters.get(c);
            if (count != 0) {
                unique = false;
                System.out.println(c);
                System.out.println(letters);
                break;
            } else {
                letters.put(c, ++count);
            }
        }

        System.out.println(letters);
        return unique;

    }

    static boolean isUniqueCheckerBrute(String s) {
        boolean unique = true;
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length - 1; i++) {
            for (int j = i + 1; j < c.length; j++) {
                if (c[i] == c[j]) {
                    unique = false;
                    break;
                }
            }
        }

        return unique;

    }


}

package CrackingTheCodingInterview.Questions.Chap1ArraysStrings;

public class C1Q5_OneAway {
    public static void main(String[] args) {
        String str1 = "pale";
        String str2 = "pal";
        C1Q5_OneAway solution = new C1Q5_OneAway();
        System.out.println(solution.isOneAway(str1, str2));
    }

    private boolean isOneAway(String s1, String s2) {
        if (s1.length() == s2.length()) {
            return oneEditReplace(s1, s2);
        } else if (s1.length() + 1 == s2.length()) {
            return  oneEditInsert(s1, s2);
        } else if (s2.length() + 1 == s1.length()) {
            return  oneEditInsert(s2, s1);
        } else {
            return false;
        }
    }

    // both methods are almost similar in iteration so it can be combined into one function
    private boolean oneEditInsert(String s1, String s2) {
        int index1 = 0;
        int index2 = 0;
        while (index1 < s1.length() && index2 < s2.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if(index1 == index2) {
                    return false;
                }
                index2++;
            } else {
                index1++;
                index2++;
            }
        }
        return true;

    }

    private boolean oneEditReplace(String s1, String s2) {
        boolean foundDiff = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (foundDiff) return false;
                foundDiff = true;
            }
        }
        return true;
    }
}

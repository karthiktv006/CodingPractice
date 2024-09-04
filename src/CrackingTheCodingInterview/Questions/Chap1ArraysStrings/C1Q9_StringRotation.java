package CrackingTheCodingInterview.Questions.Chap1ArraysStrings;

public class C1Q9_StringRotation {
    public static void main(String[] args) {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";
        C1Q9_StringRotation solution = new C1Q9_StringRotation();
        System.out.println(solution.isRotated(s1, s2));
    }

    private boolean isRotated(String s1, String s2) {
        int l = s1.length();

        if (l == s2.length() && l > 0) {
            String s1s1 = s1 + s1;
            return s1s1.contains(s2);
        }

        return false;
    }
}

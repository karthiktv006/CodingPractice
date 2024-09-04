package CrackingTheCodingInterview.Questions.Chap1ArraysStrings;

public class C1Q6_StringCompression {
    public static void main(String[] args) {
        String str = "aabbccc";
        C1Q6_StringCompression solution = new C1Q6_StringCompression();
        System.out.println(solution.compress(str));
    }

    private String compress(String s) {
        StringBuilder output = new StringBuilder();
        char c = s.charAt(0);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (c != s.charAt(i)) {
                output.append(c);
                output.append(count);
                count = 0;
                c = s.charAt(i);
            }
            count++;
        }

        output.append(c);
        output.append(count);

        return output.toString();
    }
}

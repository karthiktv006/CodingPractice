package CrackingTheCodingInterview.Questions.Chap5BitManipulations;

public class C5Q1_Insertion {
    public static void main(String[] args) {
        int n = 0b10000000;
        int m = 0b10011;
        System.out.println(Integer.toBinaryString(insert(n, m, 2, 6)));
    }

    static int insert(int n, int m, int i, int j) {
        System.out.println(Integer.toBinaryString(m));
        int allOnes = ~0;
        int left = allOnes << (i + j - 1);
        System.out.println(Integer.toBinaryString(left));
        int right = ((1 << i) - 1);
        System.out.println(Integer.toBinaryString(right));
        int mask = left | right;
        System.out.println(Integer.toBinaryString(mask));
        int n_cleared = n & mask;
        int m_shifted = m << i;

        System.out.println(Integer.toBinaryString(n_cleared));
        System.out.println(Integer.toBinaryString(m_shifted));

        return n_cleared | m_shifted;

    }
}

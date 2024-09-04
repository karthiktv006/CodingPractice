package CrackingTheCodingInterview.Questions.Chap1ArraysStrings;

public class C1Q3_URLify {
    public static void main(String[] args) {
        String str1 = "abc def  ";
        int l1 = 7;
        String str2 = "Mr John Smith    ";
        int l2 = 13;
        C1Q3_URLify solution = new C1Q3_URLify();
        System.out.println(solution.getUrl(str1, l1));
        System.out.println(solution.getUrl(str2, l2));
    }

    private String getUrl(String s, int l) {
        char[] str_array = s.toCharArray();
        int str_length = str_array.length;
        char[] url_chararray = new char[str_length];

        for (int in_index = l - 1, out_index=str_length -1; in_index >=0 && out_index >=0 ; in_index--, out_index--) {
            System.out.println("in_index" + in_index);
            System.out.println("out_index" + out_index);
            System.out.println("str_array[index]" + str_array[in_index]);
            System.out.println("url_chararray[index]" + url_chararray[out_index]);

            if(str_array[in_index] == ' ') {
                url_chararray[out_index--] = '0';
                url_chararray[out_index--] = '2';
                url_chararray[out_index] = '%';
            } else {
                url_chararray[out_index] = str_array[in_index];
            }
        }

        return new String(url_chararray);
    }
}

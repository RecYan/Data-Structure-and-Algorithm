package Algorithm.Str;

/**
 * 给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。
 * 如果剩余少于 k 个字符，则将剩余的所有全部反转。
 * 如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。
 */
public class ReverseStr {

    public static String reverseStr(String s, int k) {

        if(s == null || s.length() < 0 || k<0){
            return null;
        }

        char[] ch = s.toCharArray();
        int index = 0;
        int len = ch.length;

        while(index < len) {

            if(len-index > k) {
                for(int i=index,j=index+k-1; i<j; i++,j--) {
                    swap(ch, i, j);
                }
                index = index + 2*k;
            } else {
                for(int i=index,j=len-1; i<j; i++,j--) {
                    swap(ch, i, j);
                }
                index = len;
            }
        }
        return new String(ch);
    }

    private static void swap(char[] ch, int i, int j) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefg", 2));
    }

}

package Algorithm.Str;

/**
 * 字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”
 */
public class LeftRotateString {

    public static String leftRotateString(String str, int k) {
        if(str.length() <=0 || k < 0) {
            return null;
        }
        int len = str.length();
        str = str + str;
        return str.substring(k, k+len);
    }

    public static void main(String[] args) {
        System.out.println(leftRotateString("abcdef", 3));
    }

}

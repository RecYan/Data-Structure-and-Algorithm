package Algorithm.other;

/**
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *
 *     ==>转26进制
 *
 */
public class TitleToNumber {

    public static int titleToNumber(String s) {

        if (s == null || s.length() < 0) {
            return -1;
        }
        char[] ch = s.toCharArray();
        int result = 0;
        for (int i = 0; i < ch.length; i++) {
            result = result * 26 + (ch[i] - 'A' + 1);
        }
        return result;
    }

}

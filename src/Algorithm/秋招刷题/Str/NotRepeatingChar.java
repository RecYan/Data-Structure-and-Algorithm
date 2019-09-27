package Algorithm.Str;

import java.util.HashMap;

/**
 * 只出现一次的字符
 *    先在哈希表中统计各字母出现次数，
 *          第二次扫描直接访问哈希表获得次数
 */
public class NotRepeatingChar {

    private static HashMap<Character, Integer> map = new HashMap<>();

    public static int firstNotRepeatingChar(String str) {

        if (str.length() == 0 || str == null) {
            return -1;
        }
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                int time = map.get(str.charAt(i));
                time++;
                map.put(str.charAt(i), time);
            } else {
                map.put(str.charAt(i), 1);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String str = "aabcdfffdddd";
        System.out.println(firstNotRepeatingChar(str));
    }


}

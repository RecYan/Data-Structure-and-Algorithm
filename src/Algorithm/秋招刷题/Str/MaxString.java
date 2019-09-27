package Algorithm.Str;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 输出一个字符串中出现次数最多的字符以及次数
 */
public class MaxString {


    //hashmap 或者 hash映射
    public static void maxString(String str) {

        HashMap<Character, Integer> map = new HashMap<>();

        char[] ch = str.toCharArray();
        int length = ch.length;
        int maxCount = 0;
        char maxChar = 0;

        for(int i=0; i<length; i++) {
            if(map.containsKey(ch[i])) {
                int time = map.get(ch[i]);
                time++;
                map.put(ch[i], time);
                if(maxCount < time) {
                    maxCount = time;
                    maxChar = ch[i];
                }
            } else {
                map.put(ch[i], 1);
            }
        }

        System.out.println("maxCount: " + maxCount);
        System.out.println("maxChar: " + maxChar);

    }

    //假设都是小写
    public static char maxCharacter(String s) {

        if(s == null || s.length() < 0) {
            return ' ';
        }

        char[] ch = s.toCharArray();
        Arrays.sort(ch); //排序解决重复字符问题
        char[] res = new char[26];
        int max = 0;
        Character c = null;

        for(int i=0; i<ch.length; i++) {
            res[ch[i]-'a']++;
            if(res[ch[i]-'a'] > max) {
                //记录次数和字符
                max = res[ch[i]-'a'];
                c = ch[i];
            }
        }
        return c;
    }



    public static void main(String[] args) {
        maxString("aaabbbbbccc");
    }

}

package Algorithm.Str;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符
 *   eg:字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 *   思路：
 *      使用一个HashMap来统计字符出现的次数，
 *      同时用一个ArrayList来记录输入流，
 *      每次返回第一个出现一次的字符都是在这个ArrayList（输入流）中的字符作为key去map中查找。
 */
public class FirstAppearingOnce {

    private static Map<Character, Integer> map = new LinkedHashMap<>();

    //Insert one char from stringstream
    public static void insert(String str) {
        char[] ch = "google".toCharArray();
        for(int i=0; i<ch.length; i++) {
            if(map.containsKey(ch[i])) {
                map.put(ch[i], map.get(ch[i])+1);
            } else {
                map.put(ch[i], 1);
            }
        }

    }

    public static char firstAppearingOnce() {

        for(Map.Entry<Character, Integer> en : map.entrySet()) {
            if(en.getValue() == 1)
                return en.getKey();
        }
        return '#';
    }

    public static void main(String[] args) {
        insert("google");
        System.out.println(firstAppearingOnce());
    }

}

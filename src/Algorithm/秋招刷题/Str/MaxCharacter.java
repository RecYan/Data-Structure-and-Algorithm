package Algorithm.Str;

import java.util.Arrays;

//字符串中出现最多的字符
public class MaxCharacter {

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
        String s = "accbbdd";
        System.out.println(maxCharacter(s));
    }
}

package Algorithm.Str;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，找到最长不重复子串的长度
 *    滑动窗口思想：如果确定子串s[i,j]（假设表示字符串的第i个字符到第j-i个字符表示的子串），
 *    那么只需要比较s[j]是否与子串s[i,j]重复即可
 *    若重复：记录此时滑动窗口大小，并与最大滑动窗口比较，赋值。然后滑动窗口大小重定义为1，头位置不变，并右移一个单位。
 *    若不重复：滑动窗口头不变，结尾+1，整个窗口加大1个单位。继续比较下一个。
 */
public class LengthOfLongestSubstring {


    public static int lengthOfLongestSubstringII(String s) {

        if(s== null || s.length() < 0) {
            return -1;
        }

        int n = s.length();
        int ans = 0;
        //双指针
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
                //区间范围内字符唯一
                if (allUnique(s, i, j)) {
                    ans = Math.max(ans, j - i);
                }
        return ans;
    }

    //判断start-->end 下标之间的字符是否是唯一的
    public static boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            char ch = s.charAt(i);
            if (set.contains(ch)) {
                return false;
            }
            set.add(ch);
        }
        return true;
    }



    public static int lengthOfLongestSubstring(String s) {

        if(s== null || s.length() < 0) {
            return -1;
        }

        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;

        //双指针
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))){ //如果set中没有这个字符
                set.add(s.charAt(j)); //将这个字符加进set中

                // j - i 当前窗口的长度
                ans = Math.max(ans, j-i+1); //获取当前不重复最长子串的长度
                j++;
            }
            else {
                set.remove(s.charAt(i)); //如果当前字符出现在set中，则移除set中的一个元素
                i++;
            }
        }
        for (Character c : set) {
            System.out.print(c + " ");
        }
        System.out.println();
        return ans;
    }



    public static void main(String[] args) {

        String str = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(str));
       // System.out.println(lengthOfLongestSubstringII(str));
    }

}

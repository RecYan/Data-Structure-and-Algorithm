package Algorithm.Str;

/**
 *判断原字符串和翻转字符串的最长公共子序列长度是否比原字符串长度小1或相等
 */
public class AddcharIsHuiWen {

    private static int maxLen;
    private static int L;
    private static int R;

    public static boolean LongestPar(String str) {

        if(str == null || str.length() <= 1) {
            return false;
        }

        for(int i=0; i<str.length(); i++) {
            helper(str, i, i);
            helper(str, i, i+1);
        }
        String s = str.substring(L, R+1);
        return (str.length() - s.length() <=1) ? true : false;
    }

    //回文串判断
    private static void helper(String str, int l, int r) {

        //找到了回文串的两头位置
        while(l>=0 && r<str.length() && str.charAt(l) == str.charAt(r)) {
            if(maxLen < (r-l+1)) {
                maxLen = r-l+1;
                R = r;
                L = l;
            }
            //中心扩散
            l--;
            r++;
        }
    }

    public static void main(String[] args) {
        String s = "coco";
        System.out.println(LongestPar(s));
    }

}

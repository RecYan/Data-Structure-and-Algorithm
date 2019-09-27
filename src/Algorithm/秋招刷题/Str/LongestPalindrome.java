package Algorithm.Str;

/**
 * 最长回文子串长度
 *   中心扩散法
 *    b a b c b
 *    *开始扩散
 */
public class LongestPalindrome {

    private static int maxLen = 0;
    //最长回文串两端
    private static int L = 0;
    private static int R = 0;

    public static String longestPalindrome(String str) {

        if(str.length() <= 1) {
            return str;
        }

        for(int i=0; i<str.length(); i++) {
            diffusion(str, i, i); //奇数回文
            diffusion(str, i, i+1); //abba情况 -->偶数回文
        }
        return str.substring(L, R+1);
    }

    //中心扩散
    private static void diffusion(String str, int left, int right) {

        //回文串判断
        while(left>=0 && right<str.length() && (str.charAt(left) == str.charAt(right))) {
            if((right-left+1) > maxLen) {
                maxLen = right-left+1;
                //记录长度
                L = left;
                R = right;
            }
            //两段扩散
            left--;
            right++;
        }
    }

    public static void main(String[] args) {
        String s = "babccb";
        String str = longestPalindrome(s);
        for(int i=0; i<str.length(); i++) {
            System.out.print(str.charAt(i) + " ");
        }
        System.out.println(str.length());
    }

}

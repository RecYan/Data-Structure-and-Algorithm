package Algorithm.Str;

/**
 * 字符串全组合
 *
 * 对于ABC三个元素的全组合有以下情况：
 * 001取C； 010取B；011取BC；100取A；101取AC；110取AB；111取ABC。
 * 问题转化为了：求1—(2^n-1)中每一个数的二进制数中1的位置有哪些，有1的位置即是字符串中需要取的字符的位置。
 */
public class Combination {

    /*public static void combation(String str) {

        if(str == null || str.length() < 0) {
            return;
        }

        char[] chs = str.toCharArray();
        int length = 1 << chs.length;//组合的个数有2^n的长度
        for(int i = 0; i<length; i++){
            for(int j = 0; j<chs.length; j++){
                int k = 1<<j; //0 1 2 4
                if((k&i) == 1){//按位与运算，如果结果为1就输出当前位，结果为0不输出
                    System.out.print(chs[j]);
                }
            }
            System.out.println();
        }
    }*/

    /**递归
     * 假设我们想在长度为n的字符串中求m个字符的组合。我们先从头扫描字符串的第一个字符。
     * 针对一个字符，我们有两种选择：
     * 一是把这个字符放到组合中去，接下来我们需要在剩下的n-1个字符中选取m-1个字符；
     * 二是不把这个字符放到组合中去，接下来我们需要在剩下的n-1个字符中选择m个字符。
     */
    public static void combationII(String str) {
        if(str == null || str.length() < 0) {
            return;
        }

        char[] ch = str.toCharArray();
        StringBuilder sb = new StringBuilder();

        for(int i=1; i<=ch.length; i++) {
            //每个字符判断 取或者不去取
            helper(ch, 0, i, sb);
        }
    }

    private static void helper(char[] ch, int begin, int len, StringBuilder sb) {

        if(len==0) { //当都选择结束时打印sb内容
            System.out.println(sb+" ");
            //return;
        }
        if(begin==ch.length) { //防止begin指针越界
            return;
        }
        
        sb.append(ch[begin]); //取
        helper(ch, begin+1, len-1, sb); //剩下的里面选len-1个
        sb.deleteCharAt(sb.length()-1); //不取
        helper(ch, begin+1, len, sb); //剩下的里面选len个

    }

    public static void main(String[] args) {
        //combation("ABC");
        combationII("ABC");
    }

}

package Algorithm.other;

/**
 * 用1（1自身左移运算，）和n的每位进行位与，来判断1的个数
 *  eg n = 1010
 *  flag      1 --> 倒数第一次
 *  flag <<1   10 --> 倒数第二位
 */
public class NumberOf1 {

    /**需要循环n的二进制次数
     *   1010
     *      1
     *     10
     *    100
     *   1000
     *  依次比较二进制的每一位
     */
    public static int numberOf1(int n) {
        int count = 0;
        int flag = 1;

        while(flag != 0) {
            if((n & flag) == 1) {
                count ++;
            }
            flag = flag << 1;
        }
        return count;
    }

    /**需要循环n的二进制中1的个数次  推荐
     *    把一个数减一在和原来的数做与运算，
     *    相当于该数的二进制中最右边一个1变成0
     */
    public static int numberOf1II(int n) {
        int count = 0;

        while (n != 0) {
            count ++;
            n = n & (n - 1);
        }
        return count;
    }



    public static void main(String[] args) {
        System.out.println(numberOf1(9));
        System.out.println(numberOf1II(9));
    }

}

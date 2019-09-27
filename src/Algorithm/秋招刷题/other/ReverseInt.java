package Algorithm.other;

/**整数反转
 *  截取整数每一位数值思路
 */
public class ReverseInt {

    public static int reverse(int x) {

        //溢出判断
        if(x < Integer.MIN_VALUE || x > Integer.MAX_VALUE) {
            return 0;
        }

        int temp = 0;
        while(x != 0) {
            temp = temp * 10;
            temp = temp + x % 10; //取每一位数字
            x = x / 10;
        }
        return temp;
    }
}

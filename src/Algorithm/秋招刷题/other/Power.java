package Algorithm.other;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *   第一种方法：使用递归，时间复杂度O(logn)
 *   当n为偶数，a^n =（a^n/2）*（a^n/2）
 *   当n为奇数，a^n = a^[(n-1)/2] * a^[(n-1)/2] * a
 *   举例：
 *   2^11 = 2^1 * 2^2 * 2^8
 *   2^1011 = 2^0001 * 2^0010 * 2^1000
 * 第二种方法：累乘，时间复杂度为O(n)
 */
public class Power {

    //O(logn)
    public static double power(double base, int exponent) {

        int n = Math.abs(exponent);
        double result = 0.0;
        if (n == 0)
            return 1.0;
        if (n == 1)
            return base;
        //base为0情况
        if (base - 0.0 == 0.00001 || base - 0.0 == -0.00001)  {
            if (exponent < 0) {
                throw new RuntimeException("除0异常");
            }else{
                return 0.0;
            }
        }
        /**
         *  n=6 n/2=3 3+3
         *  n=7 n/2=3 3+3+1
         */
        result = power(base, n >> 1);
        result *= result;
        if ((n & 1) == 1) // 如果指数n为奇数，则要再乘一次底数base
            result *= base;
        if (exponent < 0) // 如果指数为负数，则应该求result的倒数
            result = 1 / result;

        return result;
    }

    // 使用累乘 O(n)
    public static double powerAnother(double base, int exponent) {
        //base为0情况
        if (base - 0.0 == 0.00001 || base - 0.0 == -0.00001)  {
            if (exponent < 0) {
                throw new RuntimeException("除0异常");
            }else{
                return 0.0;
            }
        }
        double result = 1.0;
        for (int i = 0; i < Math.abs(exponent); i++) {
            result *= base;
        }
        if (exponent >= 0)
            return result;
        else
            return 1 / result;
    }

    public static void main(String[] args) {
        System.out.println(power(0.0, -1));
        System.out.println(power(0.5, -1));
       // System.out.println(powerAnother(0.5, -1));


    }
}

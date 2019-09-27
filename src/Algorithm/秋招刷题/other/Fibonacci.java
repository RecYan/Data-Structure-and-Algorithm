package Algorithm.other;


/**
 *  f(o) f(1) =>f(2)
 *       ----------
 *       f(1) f(2) => f(3)
 *
 *  循环0(n)解法
 */
public class Fibonacci {

    public static int fibonacci(int n) {

        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }

        int fn0 = 0;
        int fn1 = 1;
        int currentNum = 0;
        for(int i=2; i<=n; i++) {
            currentNum = fn0 + fn1;
            //避免重复计算 ==> 类似指针后移
            fn0 = fn1;
            fn1 = currentNum;
        }
        return currentNum;
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(3));
    }


}

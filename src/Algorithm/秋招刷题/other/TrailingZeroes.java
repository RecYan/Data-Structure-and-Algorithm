package Algorithm.other;

/**
 * 在logn的时间内 找到n！末尾有几个零
 * 首先，要清楚 n!末尾有几个零是由这个数字的质因子中有几个成对的2 和5 决定的。
 * 我们又知道n! = n(n-1)(n-2)...... 1 ,不难看出随着n的增大，n！中质因子2要比5多的多！
 *
 * 那么我们可以计算n中包含5的数量，这个数量就是末尾0的值
 *   找出1-n中有多少个5， 5*5， 5*5*5....
 */
public class TrailingZeroes {

    public static int trailingZeroes(int n) {
        int count = 0;

        while(n != 0) {
            count = count + n/5;
            n = n / 5;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(100));
    }

}

package Algorithm.Array;

/**
 *给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * 思路:
 * *  B0        1        A1       A2       ...        An-2     An-1
 * *  B1        A0       1        A2       ...        An-2     An-1
 * *
 * *  B2        A0      A1        1       ...         An-2     An-1
 * *
 * * ...        A0      A1        ...      1          An-2     An-1
 * *
 * * Bn-2       A0      A1        ...    An-3         1        An-1
 * *
 * * Bn-1       A0      A1        ...    An-3         An-2       1
 * * 分为上三角和下三角
 * * 分别先递增乘下三角,在递减乘上三角
 */
public class Multiply {

    /**
     * 解释下代码，设有数组大小为5。
     * 对于第一个for循环
     * 第一步：b[0] = 1;
     * 第二步：b[1] = b[0] * a[0] = a[0]
     * 第三步：b[2] = b[1] * a[1] = a[0] * a[1];
     * 第四步：b[3] = b[2] * a[2] = a[0] * a[1] * a[2];
     * 第五步：b[4] = b[3] * a[3] = a[0] * a[1] * a[2] * a[3];
     * 然后对于第二个for循环
     * 第一步
     * temp *= a[4] = a[4];
     * b[3] = b[3] * temp = a[0] * a[1] * a[2] * a[4];
     * 第二步
     * temp *= a[3] = a[4] * a[3];
     * b[2] = b[2] * temp = a[0] * a[1] * a[4] * a[3];
     * 第三步
     * temp *= a[2] = a[4] * a[3] * a[2];
     * b[1] = b[1] * temp = a[0] * a[4] * a[3] * a[2];
     * 第四步
     * temp *= a[1] = a[4] * a[3] * a[2] * a[1];
     * b[0] = b[0] * temp = a[4] * a[3] * a[2] * a[1];
     * 由此可以看出从b[4]到b[0]均已经得到正确计算。
     */
    public static int[] mutiply(int[] num) {
        if (num == null || num.length <= 0) {
            return null;
        }
        int length = num.length;
        int[] result = new int[length];

        if (length != 0) {
            //乘下三角部分  从上到下
            result[0] = 1; //下三角初始
            for (int i = 1; i < length; i++) {
                result[i] = result[i - 1] * num[i - 1];
            }
            //乘上三角 从下到上
            int temp = 1;
            for (int j = length - 2; j >= 0; j--) {
                temp = temp * num[j + 1];
                result[j] = result[j] * temp;
            }
        }
        return result;
    }
}

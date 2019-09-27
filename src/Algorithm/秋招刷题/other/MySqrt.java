package Algorithm.other;

/**
 * 二分法实现开根号运算
 */
public class MySqrt {

    public static int mySqrt(int x) {

        if(x == 1) {
            return x;
        }
        int min = 0;
        int max = x;

        while((max-min) > 1) {
            int m = (max+min) / 2;
            if((x/m) < m) { // m*m>x --> 超了x
                max = m;
            } else {
                min = m;
            }
        }
        return min;
    }


}

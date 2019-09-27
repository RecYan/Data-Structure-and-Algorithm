package Algorithm.Array;

import java.util.Arrays;

/**
 * 顺子游戏
 * [一个关键点是0的个数，就是王的个数]。[另一个关键点是非0元素之间的差值和]。
 * 如果这个差值的和大于王的个数，那么王是无法填补里面的间隙的，那么就形不成顺子了。
 *      * 下面举个简单的例子。比如有五张牌，分别是1，3，4，5，0，那么0可以作为2，可以作为顺子，
 *      * 此时0 的个数是1，而间隙是(3-1-1)+(4-3-1)+(5-4-1)=1
 *      * 注意，数组要先排序，所以此时数组是0,1,3,4,5  而0不要参与计算。此时0的个数为1，差值也为1，
 *      * 所以0可以来填补这个间隙，所以可以作为顺子。
 *      1、排序
 *      2、计算所有相邻数字间隔总数
 *      3、计算0的个数
 *      4、如果2、3相等，就是顺子
 *      5、如果出现对子，则不是顺子
 */
public class IsContinuous {

    public static boolean isContinous(int[] numbers) {

        if (numbers == null || numbers.length <= 0) {
            return false;
        }
        //零的个数，即王的个数
        int zeroNum = 0;
        //排序后元素之间的差值
        int gapNum = 0;

        //数组排序
        Arrays.sort(numbers);
        //遍历数组
        for (int i = 0; i < numbers.length - 1; i++) {
            //统计王的个数，统计到一个就重新循环，因为不需要参与后面的差值计算
            //也不需要对比是不是顺子
            if (numbers[i] == 0) {
                zeroNum++;
                continue;
            }
            //不是王，并且还是对子，那肯定不是顺子了
            if (numbers[i] == numbers[i + 1]) {
                return false;
            }
            //不是王，计算一下两两的差值，最后与王的个数做比较 --> 间隙：相隔的数字个数
            gapNum += numbers[i + 1] - numbers[i] - 1;
        }
        //差值小于王的个数，说明可以用王来构成顺子
        if (gapNum <= zeroNum) {
            return true;
        }
        return false;
    }
}


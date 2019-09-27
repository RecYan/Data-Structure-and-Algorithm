package Algorithm.other;

import java.util.ArrayList;

/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *
 * 思路：
 *
 */
public class GetUglyNumber {

    //只计算丑数 不计算其他的数字
    //模拟3个队列 将三个队列头中最小的值出队 同时将该最小的数乘以2,3,5放入三个队列 重复操作
    public static int getUglyNumber(int index) {

        if(index < 0) {
            return -1;
        }

        ArrayList<Integer> result = new ArrayList<>();
        //三个下标用于记录丑数的位置
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;

        result.add(1); //第一个丑数

        while (result.size() < index) {
            //三个数都是可能的丑数，取最小的放进丑数数组里面
            //后一个丑数 一定有其前面的丑数生成
            int n2 = result.get(i2) * 2;
            int n3 = result.get(i3) * 3;
            int n5 = result.get(i5) * 5;
            int min = Math.min(n2, Math.min(n3, n5));
            result.add(min);
            /** 三个if说明
             * 丑数数组：1,2,3,4,5
             * 乘以2的队列：6,8,10，
             * 乘以3的队列：6,9,12,15
             * 乘以5的队列：10,15,20,25
             * 选择三个队列头里最小的数6加入丑数数组，但我们发现，有两个队列头都为6，所以我们弹出两个队列头
             */
            if (min == n2)
                i2++;
            if (min == n3)
                i3++;
            if (min == n5)
                i5++;
        }

        return result.size() - 1; //最后一个元素为最大的丑数
    }


}

package Algorithm.other;

import java.util.ArrayList;

/**
 * 1->n
 *输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 *   eg: 连续正数和为100的序列:18,19,20,21,22 9,10,11,12,13,14,15,16 .........
 *
 *   思路：
 *   滑动窗口：双指针技术，就是相当于有一个窗口，窗口的左右两边就是两个指针，
 *            我们根据窗口内值之和来确定窗口的位置和宽度。
 *
 */
public class FindContinuousSequence {

    public static ArrayList<ArrayList<Integer>> findContinuousSequence(int num) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        //1->n中  窗口两个边界 --> 窗口右移
        int low = 1;
        int high = 2;

        while (high > low) {
            //Sn=[(a0+an)*n]/2 连续数列
            int curSum = (low + high) * (high - low + 1) / 2;
            if(curSum == num) {
                //将窗口内的全部存到结果集中
                ArrayList<Integer> list = new ArrayList<>();
                for (int i=low; i<=high; i++) {
                    list.add(i);
                }
                result.add(list);
                low++; //计算下一组的curSum 窗口左移
            } else if(curSum < num) {
                //右边界右移 --> 扩大curSum和
                high++;
            } else {
                //curSum > num --> 减少curSum和
                low++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> result = findContinuousSequence(100);
        for(int i=0; i<result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}

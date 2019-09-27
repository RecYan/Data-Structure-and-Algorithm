package Algorithm.StackAndQueue;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}，
 * {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class MaxInWindows {

    public static ArrayList<Integer> maxInWindows(int[] nums, int length) {

        if(nums.length<0 || length<0 || nums.length < length) {
            return new ArrayList<>();
        }

        ArrayList<Integer> result = new ArrayList<>();
        //双端队列，记录每个窗口的最大值下标
        LinkedList<Integer> max = new LinkedList<>();
        for(int i=0; i<nums.length; i++) {
            //第二次开始：队列中已有的数字小于待存入的数字 则将队尾元素出队[队列中的元素就不可能为最大值了]
            while(!max.isEmpty() && nums[max.peekLast()] < nums[i]) {
                max.pollLast();
            }
            //元素入队
            max.addLast(i);
            //判断队首元素是否过期 过期则队首删除 [过期：待处理元素的下标与队首元素下标的差大于等于滑动窗口]
            if(i - max.peekFirst() >= length) {
                max.pollFirst();
            }
            //滑动窗口经过一个滑动窗口的大小，就获取当前的最大值，也就是队列的头元素
            if(i + 1 >= length) {
                result.add(nums[max.peekFirst()]);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        ArrayList<Integer> list;
        int[] nums = {2,3,4,2,6,2,5,1};
        list = maxInWindows(nums, 3);

        System.out.println(list);

    }

}

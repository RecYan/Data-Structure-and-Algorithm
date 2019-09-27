package Algorithm.Array;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 查找数组中重复出现n次的数字
 */
public class FindRepilcatedNums {

    public static HashMap<Integer, Integer> find(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(nums[i])) {
                int time = map.get(nums[i]);
                time ++;
                map.put(nums[i], time);
            } else {
                map.put(nums[i], 1);
            }
        }
        return map;
    }


    /**
     * hash散列法
     * 数组长度不是太长的
     */
    public static ArrayList<Integer> duplicateNum(int[] nums, int n) {

        if(nums == null || nums.length <0) {
            return null;
        }

        int[] res = new int[nums.length];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            res[nums[i]]++;
            if(res[nums[i]] == n) {
                list.add(nums[i]);
            }
        }
        return list;

    }



    /**
     * 1 把当前序列当成是一个下标和下标对应值是相同的数组；
     * 2 遍历数组，判断当前位的值和下标是否相等：
     *   2.1. 若相等，则遍历下一位；
     *   2.2. 若不等，则将当前位置i上的元素和a[i]位置上的元素比较：若它们相等，则找到重复数字
     *   若不等，则将它们两交换。重复上述过程
     */
    public static boolean duplicate(int array[],int length,int [] duplication) {
        if ( array==null ) return false;

        // 判断数组是否合法（每个数都在0~n-1之间）
        for ( int i=0; i<length; i++ ) {
            if ( array[i]<0 || array[i]>length-1 ) {
                return false;
            }
        }


        for( int i=0; i<length; i++ ){
            while( i!=array[i] ){
                if ( array[i] == array[array[i]] ) {
                    duplication[0] = array[i];
                    return true;
                }

                //交换array[i]和array[array[i]]
                int temp = array[i];
                array[i] = array[array[i]];
                array[array[i]] = temp;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        int[] num = new int[]{1, 2, 2, 2, 3, 3, 4, 4};
        /*HashMap<Integer, Integer> map = find(num);

        for(Integer i : map.keySet()) {
            //查找出现几次的数 map.get(i) == N
            if(map.get(i) == 2) {
                System.out.print(i + " ");
            }
        }*/

        ArrayList<Integer> list = duplicateNum(num, 3);
        for(int i : list) {
            System.out.print(i + " ");
        }

    }
}

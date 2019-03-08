package Algorithm.AlgorithmSloution;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yan_Jiang on 2019/3/8.
 * Given num = [2, 7, 11, 15] target = 9
 *  return i, j  where num[i] + num[j] = 9
 */
public class Two_Sum_in_Array {

    //O(n*n)
    public static int[] Soultion_1(int[] nums, int target) {
        //省略参数检查
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j <nums.length ; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    /**O(n)
     * 当需要使用嵌套for循环来查找或者定位的时候，
     * 尽量优先考虑是否能使用Map（值作为key，下标作为value）
     * 使用  map.containsKey(__) 方法来进行定位
    */
    public static int[] Solution_2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];

        for (int i = 0; i < nums.length ; i++) {
            map.put(nums[i], i); //元素存入map<value, index>
            if(map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                return result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //int[] nums = new int[2]
        //int[] num = new int[]{};
        int[] nums = {2, 7, 11, 15};
        System.out.println(Solution_2(nums, 9)[0]);
        System.out.println(Solution_2(nums, 9)[1]);
    }
}

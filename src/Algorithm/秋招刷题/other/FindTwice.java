package Algorithm.other;

/**
 * 一个数组中 只有两个元素只出现了一次 其他的元素都出现了2次
 */
public class FindTwice {

    //位运算
    public static int[] findTwiceII(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        int different = 0;
        for (int i : nums) {
            different ^= i;
        }

        different &= -different; //这个数字和相反数做与运算得到一个二进制位最右边一位为1的数字;
        int[] ans = {0, 0};
        for (int i : nums) {
            if ((different & i) == 0) { //分组
                ans[0] ^= i;
            } else {
                ans[1] ^= i;
            }
        }

        return ans;
    }



    //hash映射
    public static void findTwice(int[] nums) {

        if(nums == null || nums.length < 0) {
            return;
        }

        int[] hash = new int[nums.length];

        for(int i=0; i<nums.length; i++) {
            hash[nums[i]]++;
        }

        for(int i=0; i<hash.length; i++) {
            if(hash[i] == 1) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 4, 4, 5};
        findTwice(nums);

        /*int[] res = findTwiceII(nums);
        for(int i : res) {
            System.out.print(i+" ");
        }*/

    }

}

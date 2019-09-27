package Algorithm.Array;

//[1 2 3] --> [1 2 4]
//[1 2 9] --> [1 3 0]
//[9] --> [1 0]
public class PlusOne {

    //从最后一位出发，确定这个 1 应该加在哪个位置。
    //如果找不到位置，说明溢出了当前数组。新建一个 长度+1 的数组
    public static int[] plusOne(int[] digits) {

        for(int i=digits.length-1; i>=0; i--) {
            if(digits[i] != 9) {
                digits[i]++;
                return digits; //未溢出
            } else {
                digits[i] = 0; //[0, 0, 0, ..., 0]
            }
        }
        //[99....9]情况
        int[] newDigists = new int[digits.length+1];
        //[9] --> [10]
        newDigists[0] = 1; //溢出
        return newDigists;
    }

    public static void main(String[] args) {
        int[] nums = {9};
        int[] result = plusOne(nums);
        for(int i : result) {
            System.out.print(i + " ");
        }
    }
}

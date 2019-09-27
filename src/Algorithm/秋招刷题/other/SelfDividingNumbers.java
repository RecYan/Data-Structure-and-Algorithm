package Algorithm.other;

import java.util.ArrayList;

//求范围内的所有自除数
//自除数 是指可以被它包含的每一位数除尽的数。
//例如，128 是一个自除数，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
public class SelfDividingNumbers {

    public static void selfDividingNumbers(int left, int right) {

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=left; i<=right; i++) {
            if(helper(i)) {
                list.add(i);
            }
        }
        System.out.println(list);
    }

    //判断一个数 是否为自除数
    private static boolean helper(int n) {

        int val = n;
        while(val != 0) {
            if(val%10 != 0 && n%(val%10) == 0) {
                val = val / 10;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        selfDividingNumbers(1, 22);
        //System.out.println(helper(21));
    }
}

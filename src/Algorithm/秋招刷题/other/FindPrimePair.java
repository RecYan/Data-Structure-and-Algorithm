package Algorithm.other;

import java.util.ArrayList;

/**
 * 求和为n的素数对
 */
public class FindPrimePair {


    public static int findPrimePair(int n) {

        if(n < 0) {
            return -1;
        }

        ArrayList<Integer> list = new ArrayList<>(); //保存1->n的所有素数

        for(int i=2; i<=n; i++) {
            if(isPrim(i)) {
                list.add(i);
            }
        }

        int begain = 0;
        int end = list.size() - 1;
        int count = 0;

        while(begain <= end) {
            if(list.get(begain) + list.get(end) > n) {
                end--;
            } else if(list.get(begain) + list.get(end) < n) {
                begain++;
            }
            else {
                count++;
                begain++;
                end--;
            }
        }
        return count;
    }

    //素数判断 素数：2->n-1之间都不能被整除
    private static boolean isPrim(int num) {

        for(int i=2; i<=num-1; i++) {
            if(num%i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(findPrimePair(10));
    }

}

package Algorithm.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定两个数组，编写一个函数来计算它们的交集
 */
public class Intersection {

    public static int[] intersection(int[] num1, int[] num2) {

        if(num1 == null || num1.length < 0) {
            return null;
        }
        if(num2 == null || num2.length < 0) {
            return null;
        }


        Set<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();

        //存储num1
        for(int i : num1) {
            set.add(i);
        }
        //找出公共部分
        for(int i : num2) {
            if(set.contains(i)) {
                list.add(i);
            }
        }
        int[] result = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static ArrayList<Integer> intersectionII(int[] num1, int[] num2) {

        ArrayList<Integer> res = new ArrayList<Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<>();

        if(num1 == null || num1.length == 0 || num2 == null || num2.length == 0) {
            return res;
        }
        //num1存入map
        for(int i=0; i<num1.length; i++) {
            if(map.containsKey(num1[i])) {
                int time = map.get(num1[i]);
                time++;
                map.put(num1[i], time);
            } else {
                map.put(num1[i], 1);
            }
        }
        //num1存入list
        for(int i : num1) {
            list.add(i);
        }

        for(int i=0; i<num2.length; i++) {
            /*if(map.containsKey(num2[i])) {
                res.add(num2[i]);
            }*/
            if(list.contains(num2[i])) {
                res.add(num2[i]);
            }
        }
        return res;

    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};

        int[] a = intersection(nums1, nums2);

        for (int i : a) {
            System.out.print(i + " ");
        }

        System.out.println(intersectionII(nums1, nums2));
    }

}

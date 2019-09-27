package Algorithm.other;

import java.util.LinkedList;

/** 圆圈中最后剩下的数<约瑟夫环>
 * 首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
 * 从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,
 * 可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版
 *
 * // 上诉相当于 ==》 从1开始到n 数到m则删除该数 从下一个数从1继续计数
 */
public class LastRemaining {

    public static String helper(int[] input) {

        if(input == null || input.length <0) {
            return null;
        }
        int n = input[0];
        int m = input[1];
        //链表模拟圆圈
        LinkedList<Integer> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++) {
            list.add(i);
        }
        int index = 0;
        while(list.size() > 0) {
            index = index + m;
            //M倍数下标
            index = (index % list.size()) - 1;
            if(index < 0) { //队尾
                sb.append(list.get(list.size() -1));
                sb.append(" ");
                list.remove(list.size()-1);
                index = 0;
            } else {
                sb.append(list.get(index));
                sb.append(" ");
                list.remove(index);
            }
        }
        return sb.toString().trim();
    }

    /*public static void yuesefu(int totalNum, int countNum) {
        // 初始化人数
        List<Integer> start = new ArrayList<Integer>();
        for (int i = 1; i <= totalNum; i++) {
            start.add(i);
        }
        //从第K个开始计数
        int k = 0;
        while (start.size() > 0) {
            k = k + countNum;
            //第m人的索引位置
            k = k % (start.size()) - 1;
            // 判断是否到队尾
            if (k < 0) {
                System.out.println(start.get(start.size() - 1));
                start.remove(start.size() - 1);
                k = 0;
            } else {
                System.out.println(start.get(k));
                start.remove(k);
            }
        }
    }*/

    public static void main(String[] args) {
        //lastRemaining(6, 3);
        //System.out.println(yuesefu(6, 3));
        //yuesefu
        //yuesefu(6, 3);
    }

}

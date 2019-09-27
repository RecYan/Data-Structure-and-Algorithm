package Algorithm.Array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 用最大堆保存这k个数，每次只和堆顶比，
 *  如果比堆顶小，删除堆顶，新数入堆。
 *  否则元素进堆
 *  ------------------
 *  找出数组中最小的k个数
 */
public class TopK {

    public static ArrayList<Integer> getLeastNumbers(int[] num, int k) {

        ArrayList<Integer> result = new ArrayList<>();
        int length = num.length;
        if(k > length || k <= 0 || num == null) {
            return null;
        }

        /**构建最大堆
         * o1 - o2 升序
         * o2 - o1 降序
         */
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                /** O1-O2 jdk官方默认是升序
                 * < return -1
                 * = return 0
                 * > return 1
                 */
                return o2 - o1; //大根堆
            }
        });

        //数组元素入堆
        for(int i = 0; i < length; i++) {
            //构建堆
            if(maxHeap.size() != k) {
                maxHeap.add(num[i]);
            } else if (num[i] < maxHeap.peek() ) {
                maxHeap.remove(); //弹出堆顶元素
                maxHeap.add(num[i]); //新元素进堆
            }
        }
        for(Integer i : maxHeap) {
            result.add(i);
        }
        return result;
    }

    public static void main(String[] args) {

        int[] num = {4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(getLeastNumbers(num, 4));
    }

}

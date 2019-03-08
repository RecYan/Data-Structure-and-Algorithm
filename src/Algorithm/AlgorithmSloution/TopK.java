package Algorithm.AlgorithmSloution;

import java.util.*;

/**
 * Created by Yan_Jiang on 2019/3/3.
 * Top大问题解决思路：使用一个固定大小的最小堆，当堆满后，每次添加数据的时候与堆顶元素比较
 * ，若小于堆顶元素，则舍弃，若大于堆顶元素，则删除堆顶元素，添加新增元素，对堆进行重新排序。
 *Top小问题解决思路：使用一个固定大小的最大堆，当堆满后，每次添加数据到时候与堆顶元素进行比较，若大于堆顶元素，则舍弃，
 * 若小于堆顶元素，则删除堆顶元素，添加新增元素，对堆进行重新排序
 */
public class TopK {

    private PriorityQueue<Integer> queue; //默认小根堆
    private int maxSize; //TopK的k值

    public TopK(int maxSize){
        if (maxSize <= 0) {
            throw new IllegalStateException();
        }
        this.maxSize = maxSize;
        this.queue = new PriorityQueue<>(maxSize, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // 最大堆用o2 - o1，最小堆用o1 - o2
                return o1 - o2;
            }
        });
    }

    public void add(int num) {
        if(queue.size() < maxSize) {
            queue.add(num);
        } else {
            int top = queue.peek();
            if(top < num) { //添加的元素>堆顶元素 则用添加元素替换堆顶元素 调整堆结构
                queue.poll();
                queue.add(num); //加入大的元素
            }
        }
    }

    //将调整后的堆排序输出
    public List<Integer> sortedList() {
        List<Integer> list = new ArrayList<>(queue);
        Collections.sort(list);
        return list;
    }

    public static void main(String[] args) {
        int[] array = {4, 5, 1, 6, 2, 7, 3, 8,11};
        TopK pq = new TopK(4);
        for (int n : array) {
            pq.add(n);
        }
        System.out.println(pq.sortedList());
    }





}

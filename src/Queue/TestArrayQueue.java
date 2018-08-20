package Queue;

/**
 * Created by Yan_Jiang on 2018/8/20.
 * 测试
 */
public class TestArrayQueue {

    public static void main(String[] args) {

        ArrayQueue<Integer> queue = new ArrayQueue<Integer>();

        for (int i = 0; i <10 ; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if(i%3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }


    }
}

package Queue;

import java.util.Random;

/**
 * Created by Yan_Jiang on 2018/8/20.
 * 测试循环队列和数组队列的操作时间
 */
public class TestRunTime {


    private static double testQueue(Queue<Integer> q, int opCount) {

        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i <opCount ; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE)); //0-i中的随机数
        }

        for (int i = 0; i <opCount ; i++) {
            q.dequeue();
        }
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0; //转成秒
    }


    public static void main(String[] args) {

        int opCount = 100000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<Integer>();
        double time1 = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue time: "+ time1+ " s");

        LoopQueue<Integer> loopQueue = new LoopQueue<Integer>();
        double time2 = testQueue(loopQueue, opCount);
        System.out.println("loopQueue time: "+ time2+ " s");

    }



}

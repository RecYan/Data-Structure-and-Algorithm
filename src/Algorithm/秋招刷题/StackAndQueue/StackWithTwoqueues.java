package Algorithm.StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 两个队列模拟栈
 */

public class StackWithTwoqueues {

    private static Queue<Integer> q1 = new LinkedList<>();
    private static Queue<Integer> q2 = new LinkedList<>();


    // 第一次默认插入q1 后面则哪一个队列不为空就插入哪一个队列
    public void push(int num) {
        if(!q1.isEmpty()) {
            q1.add(num);
        }
        if(!q2.isEmpty()) {
            q2.add(num);
        }
        q1.add(num);
    }

    public int pop() throws Exception {

        if(q1.isEmpty() && q2.isEmpty()) {
            throw new Exception("stack is empty");
        }
        int result = 0; //带弹出的元素
        if(!q1.isEmpty()) {
            while(q1.size() > 1) {
                //前n-1个元素 入q2
                q2.add(q1.poll());
            }
            result = q1.poll();
        } else {
            while(q2.size() > 1) {
                //前n-1个元素 入q1
                q1.add(q2.poll());
            }
            result = q2.poll();
        }
        return result;
    }




}

package Algorithm.StackAndQueue;

import java.util.Stack;

/**
 * 两个栈模拟队列
 */
public class QueueWithTwoStacks {

    private static Stack<Integer> in = new Stack<>();
    private static Stack<Integer> out = new Stack<>();

    public void push(int num) {
        in.push(num);
    }

    public int pop() throws Exception {
        if(out.isEmpty()) {
            if(in.isEmpty()) {
                throw new Exception("queue is empty");
            }
            while(!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.pop();
    }
}

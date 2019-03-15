package Algorithm.AlgorithmSloution;

import java.util.Stack;

/**
 * Created by Yan_Jiang on 2019/3/15.
 *
 * 用两个栈模拟的队列
 * 用两个核实现一个队列。队列的声明如下，诸实现它的两个函数appendTail和deleteHead，
 * 分别完成在队列尾部插入结点和在队列头部删除结点的功能。
 *
 */
public class TwoStackToList<T> {

    Stack<T> stack1 = new Stack<>(); //数据插入栈
    Stack<T> stack2 = new Stack<>(); //数据弹出栈


    public void appendTail(T t) {

        stack1.push(t);
    }


    public T deleteHead() throws Exception {

        // 先判断弹出栈是否为空，如果为空就将插入栈的所有数据弹出栈，
        // 并且将弹出的数据压入弹出栈中
        if (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        if (stack2.isEmpty()) {
            throw new Exception("弹出栈为空");
        }
        return stack2.pop();
    }

}

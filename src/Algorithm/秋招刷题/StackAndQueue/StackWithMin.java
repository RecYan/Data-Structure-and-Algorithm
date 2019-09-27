package Algorithm.StackAndQueue;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 *  辅助栈元素小于数据栈元素 最小元素位于辅助栈栈顶
 */
public class StackWithMin {

    private static Stack<Integer> stackDate = new Stack<>();
    private static Stack<Integer> stackMin = new Stack<>();

    //stackDate直接塞，stackMin要塞比栈顶小的元素，要不然就重新塞一下栈顶元素
    public static void push(int node) {
        stackDate.push(node);
        if(stackMin.isEmpty() || stackMin.peek() > node) {
            stackMin.push(node);
        } else {
            //重新塞一下栈顶元素
            stackMin.push(stackMin.peek());
        }
    }
    //分别弹出
    public static void pop() {
        if(stackDate.isEmpty()){
            throw new RuntimeException("This stack is empty!");
        }
        stackDate.pop();
        stackMin.pop();
    }
    /*public static int top() {
        if(stackDate.isEmpty()){
            throw new RuntimeException("This stack is empty!");
        }
        int value = stackDate.peek();
        return value;
    }*/
    public static int min() {
        if(stackMin.isEmpty()){
            throw new RuntimeException("This stack is empty!");
        }else{
            return stackMin.peek();
        }
    }
}

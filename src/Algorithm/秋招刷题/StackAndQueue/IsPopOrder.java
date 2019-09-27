package Algorithm.StackAndQueue;

import java.util.Stack;

/**
    模拟堆栈操作：将原数列依次压栈，栈顶元素与所给出栈队列相比，如果相同则出栈，
    如果不同则继续压栈，直到原数列中所有数字压栈完毕。
    检测栈中是否为空，若空，说明出栈队列可由原数列进行栈操作得到。否则，说明出栈队列不能由原数列进行栈操作得到。
*/
public class IsPopOrder<psvm> {

    public static boolean IsPopOrder(int [] pushA, int [] popA) {

        if(pushA.length <= 0 || popA.length <= 0) {
            return false;
        }

        Stack<Integer> stack = new Stack<>(); //辅助栈
        int popIndex = 0; //弹出序列的位置
        for(int i=0; i<pushA.length; i++) {
            stack.push(pushA[i]);
            while(!stack.isEmpty() && stack.peek() == popA[popIndex]) {
                //peek: 获取栈顶元素但不删除
                stack.pop();
                popIndex ++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushA = {1,2,3,4,5};
        int [] popA = {4,3,5,1,2};
        System.out.println(IsPopOrder(pushA, popA));
    }



}

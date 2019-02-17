package Algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
/**
	两个栈结构实现队列结构
	两个队列结构实现栈结构
	
*/
public class StackAndQueueConvert {

	//两个栈实现队列
	public static class TwoStacksQueue {
		private Stack<Integer> stackPush;
		private Stack<Integer> stackPop;

		public TwoStacksQueue() {
			stackPush = new Stack<Integer>();
			stackPop = new Stack<Integer>();
		}

		//入队操作 push栈压入所有元素
		public void push(int pushInt) {
			stackPush.push(pushInt);
		}

		//出队操作 将push栈中所有的元素重新弹出到pop栈中 从pop栈中弹出元素
		public int poll() {
			if (stackPop.empty() && stackPush.empty()) {
				throw new RuntimeException("Queue is empty!");
			} else if (stackPop.empty()) { //pop栈为空时 将push栈中所有元素 弹出到pop栈中
				while (!stackPush.empty()) {
					stackPop.push(stackPush.pop());
				}
			}
			return stackPop.pop();
		}

		public int peek() {
			if (stackPop.empty() && stackPush.empty()) {
				throw new RuntimeException("Queue is empty!");
			} else if (stackPop.empty()) {
				while (!stackPush.empty()) {
					stackPop.push(stackPush.pop());
				}
			}
			return stackPop.peek();
		}
	}

	//两个队列实现栈
	public static class TwoQueuesStack {
		private Queue<Integer> data; //数据队列
		private Queue<Integer> help; //辅助队列

		public TwoQueuesStack() {
			data = new LinkedList<Integer>();
			help = new LinkedList<Integer>();
		}

		//入栈操作
		public void push(int pushInt) {
			data.add(pushInt);
		}

		//取出栈顶元素
		public int peek() {
			if (data.isEmpty()) {
				throw new RuntimeException("Stack is empty!");
			}
			while (data.size() != 1) {
				help.add(data.poll());
			}
			int res = data.poll();
			help.add(res); //需要将栈顶元素继续入队
			swap();
			return res;
		}

		public int pop() {
			if (data.isEmpty()) {
				throw new RuntimeException("Stack is empty!");
			}
			// 出栈时 将最后一个元素前面的所有元素 入辅助队列中
			while (data.size() > 1) {
				help.add(data.poll());
			}
			int res = data.poll(); //弹出 data队列中的最后一个元素
			swap();
			return res;
		}

		//交换两个队列的引用 
		private void swap() {
			Queue<Integer> tmp = help;
			help = data;
			data = tmp;
		}

	}

}

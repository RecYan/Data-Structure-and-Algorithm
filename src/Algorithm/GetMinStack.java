package Algorithm;

import java.util.Stack;

/**
	实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返
	回栈中最小元素的操作
	pop、push、getMin操作的时间复杂度都是O(1)

*/
public class GetMinStack {
	// public static class MyStack1 {
		// private Stack<Integer> stackData;
		// private Stack<Integer> stackMin;

		// public MyStack1() {
			// this.stackData = new Stack<Integer>();
			// this.stackMin = new Stack<Integer>();
		// }

		// public void push(int newNum) {
			// if (this.stackMin.isEmpty()) {
				// this.stackMin.push(newNum);
			// } else if (newNum <= this.getmin()) {
				// this.stackMin.push(newNum);
			// }
			// this.stackData.push(newNum);
		// }

		// public int pop() {
			// if (this.stackData.isEmpty()) {
				// throw new RuntimeException("Your stack is empty.");
			// }
			// int value = this.stackData.pop();
			// if (value == this.getmin()) {
				// this.stackMin.pop();
			// }
			// return value;
		// }

		// public int getmin() {
			// if (this.stackMin.isEmpty()) {
				// throw new RuntimeException("Your stack is empty.");
			// }
			// return this.stackMin.peek();
		// }
	// }

	public static class MyStack2 {
		private Stack<Integer> stackData; //存放数据的栈
		private Stack<Integer> stackMin; //存放数据中最小值的栈

		public MyStack2() {
			this.stackData = new Stack<Integer>();
			this.stackMin = new Stack<Integer>();
		}

		/**
			stackData栈中 正常压入数据
			stackMin栈中 栈顶的元素 与 数据栈中的元素比较
				若带压入的数据 大于最小栈中的栈顶元素 则 最小栈压入本身的栈顶元素
				否则 就压入带压入数据栈的元素
		*/
		public void push(int newNum) {
			if (this.stackMin.isEmpty()) {
				this.stackMin.push(newNum);
			} else if (newNum < this.getmin()) {
				this.stackMin.push(newNum);
			} else {
				int newMin = this.stackMin.peek();
				this.stackMin.push(newMin);
			}
			this.stackData.push(newNum);
		}

		/**
			弹栈操作 两个栈保持同步即可
		*/
		public int pop() {
			if (this.stackData.isEmpty()) {
				throw new RuntimeException("Your stack is empty.");
			}
			this.stackMin.pop();
			return this.stackData.pop();
		}

		//弹出最小栈的栈顶
		public int getmin() {
			if (this.stackMin.isEmpty()) {
				throw new RuntimeException("Your stack is empty.");
			}
			return this.stackMin.peek();
		}
	}

	

}

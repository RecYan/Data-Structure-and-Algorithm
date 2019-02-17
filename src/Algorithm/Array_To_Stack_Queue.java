package Algorithm;

/**
	数组实现固定大小的栈和队列
*/
public class Array_To_Stack_Queue {

	public static class ArrayStack {
		private Integer[] arr;
		private Integer size; //数组下标index[待加入的数的位置] 即现在元素下标+1

		public ArrayStack(int initSize) {
			if (initSize < 0) {
				throw new IllegalArgumentException("The init size is less than 0");
			}
			arr = new Integer[initSize];
			size = 0;
		}

		//取出栈顶元数
		public Integer peek() {
			if (size == 0) {
				return null;
			}
			return arr[size - 1];
		}

		public void push(int obj) {
			if (size == arr.length) {
				throw new ArrayIndexOutOfBoundsException("The stack is full");
			}
			arr[size] = obj;
			size++;
		}

		public Integer pop() {
			if (size == 0) {
				throw new ArrayIndexOutOfBoundsException("The stack is empty");
			}
			return arr[--size];
		}
	}

	public static class ArrayQueue {
		private Integer[] arr;
		/**
			size不等于数组长度 end可以下移 到底部时 直接返回初始位置
			size不等于0 start下移 到底部时 直接返回初始位置
			start 追赶 end 
		*/
		private Integer size; //通过size变量 将start和end解耦
		private Integer start; //出队指针
		private Integer end; //入队指针

		public ArrayQueue(int initSize) {
			if (initSize < 0) {
				throw new IllegalArgumentException("The init size is less than 0");
			}
			arr = new Integer[initSize];
			size = 0;
			start = 0;
			end = 0;
		}

		public Integer peek() {
			if (size == 0) {
				return null;
			}
			return arr[start];
		}

		public void push(int obj) {
			if (size == arr.length) {
				throw new ArrayIndexOutOfBoundsException("The queue is full");
			}
			size++;
			arr[end] = obj;
			// end == arr.length - 1 end返回初始位置
			//end 到底就返回初始位置 否则就继续下移
			end = end == arr.length - 1 ? 0 : end + 1;
		}

		public Integer poll() {
			if (size == 0) {
				throw new ArrayIndexOutOfBoundsException("The queue is empty");
			}
			size--;
			int tmp = start;
			start = start == arr.length - 1 ? 0 : start + 1;
			return arr[tmp];
		}
	}

	public static void main(String[] args) {

	}

}

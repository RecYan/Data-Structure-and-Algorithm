package Algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;
/**
	输入一个数组，返回分割的最小代价
*/
public class Less_Money {

	public static int lessMoney(int[] arr) {
		//优先队列模拟最小堆
		// 自定义比较器 可实现最大堆
		PriorityQueue<Integer> pQ = new PriorityQueue<>();
		for (int i = 0; i < arr.length; i++) {
			pQ.add(arr[i]);
		}
		int sum = 0;
		int cur = 0;
		while (pQ.size() > 1) {
			//从小根堆中 取出最小的两个元素 累加
			cur = pQ.poll() + pQ.poll();
			sum += cur;
			//累加的和 加入小根堆
			pQ.add(cur);
		}
		return sum;
	}

	public static class MinheapComparator implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o1 - o2; // < 0  o1 < o2  负数
		}

	}

	public static class MaxheapComparator implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2 - o1; // <   o2 < o1
		}

	}

	

}

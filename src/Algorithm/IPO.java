package Algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;


public class IPO {
	public static class Node {
		public int p; // 项目利润
		public int c; // 项目花费

		public Node(int p, int c) {
			this.p = p;
			this.c = c;
		}
	}

	// cost小根堆 比较器
	public static class MinCostComparator implements Comparator<Node> {

		@Override
		public int compare(Node o1, Node o2) {
			return o1.c - o2.c;
		}

	}
	
	// profits大根堆 比较器
	public static class MaxProfitComparator implements Comparator<Node> {

		@Override
		public int compare(Node o1, Node o2) {
			return o2.p - o1.p;
		}

	}
	
	/**
		在k次项目的约束下
			以最小的cost --> 最大的profits
			w: 成本
			Capital: 项目花费
	*/
	public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
		Node[] nodes = new Node[Profits.length];
		for (int i = 0; i < Profits.length; i++) {
			nodes[i] = new Node(Profits[i], Capital[i]);
		}

		PriorityQueue<Node> minCostQ = new PriorityQueue<>(new MinCostComparator());
		PriorityQueue<Node> maxProfitQ = new PriorityQueue<>(new MaxProfitComparator());
		/**
			将node节点放入小根堆 Capital形成小根堆
		*/
		for (int i = 0; i < nodes.length; i++) {
			minCostQ.add(nodes[i]);
		}
		// k次项目
		for (int i = 0; i < k; i++) {
			// 小根堆中cost小于w的 放入大根堆
			while (!minCostQ.isEmpty() && minCostQ.peek().c <= W) {
				maxProfitQ.add(minCostQ.poll());
			}
			// w < 小根堆的头结点时 --> 本钱不够做项目了
			if (maxProfitQ.isEmpty()) {
				return W;
			}
			W += maxProfitQ.poll().p;
		}
		return W;
	}

}

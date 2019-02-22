package Algorithm;

import java.util.HashMap;
import java.util.List;
/**
	并查集 
		查看A B元素是否在同一个集合中
		合并A B元素所在的两个集合
*/
public class UnionFind {

	public static class Node {
		// whatever you like
	}

	public static class UnionFindSet {
		public HashMap<Node, Node> fatherMap; // key:子节点 value:该子节点对应的父节点
		public HashMap<Node, Integer> sizeMap; // node元素所在集合的大小

		public UnionFindSet() {
			fatherMap = new HashMap<Node, Node>();
			sizeMap = new HashMap<Node, Integer>();
		}

		/**
			并查集初始化 每个元素都是自己集合的代表节点且集合中只有自己
		*/
		public void makeSets(List<Node> nodes) {
			fatherMap.clear();
			sizeMap.clear();
			for (Node node : nodes) {
				fatherMap.put(node, node);
				sizeMap.put(node, 1); //每个初始集合大小为1 
			}
		}

		// 找节点的父节点 并将原链上的所有节点做扁平处理
		private Node findHead(Node node) {
			Node father = fatherMap.get(node);
			if (father != node) {
				father = findHead(father);
			}
			fatherMap.put(node, father); //扁平处理：将所有节点指向代表节点
			return father;
		}
		
		public boolean isSameSet(Node a, Node b) {
			return findHead(a) == findHead(b);
		}

		//集合合并
		public void union(Node a, Node b) {
			if (a == null || b == null) {
				return;
			}
			Node aHead = findHead(a);
			Node bHead = findHead(b);
			if (aHead != bHead) {
				//代表头结点的size 代表整个当前集合的size
				int aSetSize= sizeMap.get(aHead);
				int bSetSize = sizeMap.get(bHead);
				//小集合 挂到 大集合下面
				if (aSetSize <= bSetSize) {
					fatherMap.put(aHead, bHead);
					sizeMap.put(bHead, aSetSize + bSetSize);
				} else {
					fatherMap.put(bHead, aHead);
					sizeMap.put(aHead, aSetSize + bSetSize);
				}
			}
		}

	}

	

}

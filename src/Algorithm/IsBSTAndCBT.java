package Algorithm;

import java.util.LinkedList;
import java.util.Queue;
/**
	判断一个二叉树 是否为搜索二叉树和平衡二叉树
*/
public class IsBSTAndCBT {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	/**
		中序遍历二叉树 看节点元素 是否升序排列
	*/
	public static boolean isBST(Node head) {
			return true;
		}
		boolean res = true;
		Node pre = null;
		Node cur1 = head;
		Node cur2 = null;
		while (cur1 != null) {
			cur2 = cur1.left;
			if (cur2 != null) {
				while (cur2.right != null && cur2.right != cur1) {
					cur2 = cur2.right;
				}
				if (cur2.right == null) {
					cur2.right = cur1;
					cur1 = cur1.left;
					continue;
				} else {
					cur2.right = null;
				}
			}
			if (pre != null && pre.value > cur1.value) {
				res = false;
			}
			pre = cur1;
			cur1 = cur1.right;
		}
		return res;
	}

	/**
		情况一 任意节点 如有右孩子没有左孩子 --> false
		情况二 头节点的左孩子、右孩子不全 则剩下的节点必须都是叶子节点 --> true
	*/
	public static boolean isCBT(Node head) {
		if (head == null) {
			return true;
		}
		Queue<Node> queue = new LinkedList<Node>();
		boolean leaf = false; //叶节点条件判断标记
		Node l = null;
		Node r = null;
		queue.offer(head);
		while (!queue.isEmpty()) {
			head = queue.poll();
			l = head.left;
			r = head.right;
			if ((leaf && (l != null || r != null)) //开启叶节点判断是 节点的左右孩子必须为空
				|| (l == null && r != null)) { //情况一
				return false;
			}
			if (l != null) {
				queue.offer(l);
			}
			if (r != null) {
				queue.offer(r);
			} 
			if(l == null || r ==null) {
				leaf = true;
			}
		}
		return true;
	}

	
}
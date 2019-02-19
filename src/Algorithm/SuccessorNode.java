package Algorithm;

/**
	在二叉树中找到一个节点的后继节点
*/
public class SuccessorNode {

	public static class Node {
		public int value;
		public Node left;
		public Node right;
		public Node parent; //当前节点的父节点

		public Node(int data) {
			this.value = data;
		}
	}
	/**
		1 当前节点有右子树 后继节点为该右子树的最左节点
		2 当前节点无右子树 向上找该节点的父节点 判断该父节点是否为该父节点的父节点的左孩子
			如果是 该父节点则为该节点的后继节点
	*/
	public static Node getSuccessorNode(Node node) {
		if (node == null) {
			return node;
		}
		//1
		if (node.right != null) {
			return getLeftMost(node.right);
		} else {
			//2
			Node parent = node.parent;
			while (parent != null && parent.left != node) {
				node = parent;
				parent = node.parent;
			}
			return parent;
		}
	}

	//寻找 node最根节点的子树最左节点
	public static Node getLeftMost(Node node) {
		if (node == null) {
			return node;
		}
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}

	
}

package Algorithm;

import java.util.Stack;
/**
实现二叉树的先序、中序、后序遍历，包括递归方式和非递归方式

*/

public class PreInPosTraversal {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	public static void preOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		System.out.print(head.value + " ");
		preOrderRecur(head.left);
		preOrderRecur(head.right);
	}

	public static void inOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		inOrderRecur(head.left);
		System.out.print(head.value + " ");
		inOrderRecur(head.right);
	}

	public static void posOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		posOrderRecur(head.left);
		posOrderRecur(head.right);
		System.out.print(head.value + " ");
	}

	public static void preOrderUnRecur(Node head) {
		System.out.print("pre-order: ");
		if (head != null) {
			Stack<Node> stack = new Stack<Node>();
			/**
				共同点：
				add，push都可以向stack中添加元素。
				不同点：
				add是继承自Vector的方法，且返回值类型是boolean。
				push是Stack自身的方法，返回值类型是参数类类型。
			*/
			stack.add(head); //压入头结点
			while (!stack.isEmpty()) {
				head = stack.pop(); //打印栈顶节点
				System.out.print(head.value + " ");
				//压入顺序 右 左 --> 弹出 左 右
				if (head.right != null) {
					stack.push(head.right);
				}
				if (head.left != null) {
					stack.push(head.left);
				}
			}
		}
		System.out.println();
	}

	public static void inOrderUnRecur(Node head) {
		System.out.print("in-order: ");
		/**
			思路：
				当前节点为空时，从栈中弹出元素，指针移动到拿出节点的右侧
				当前接待非空时，向栈压入元素，指针移动到压入节点的左侧
		*/
		if (head != null) {
			Stack<Node> stack = new Stack<Node>();
			while (!stack.isEmpty() || head != null) {
				if (head != null) {
					stack.push(head);
					head = head.left;
				} else {
					head = stack.pop();
					System.out.print(head.value + " ");
					head = head.right;
				}
			}
		}
		System.out.println();
	}

	public static void posOrderUnRecur1(Node head) {
		System.out.print("pos-order: ");
		/**
			思路：
				1 参考前序非递归遍历 中 右 左
				2 将遍历弹出的元素 放到另一个辅助栈中
				3 遍历结束后 将辅助栈中元素 弹出
		*/
		if (head != null) {
			Stack<Node> s1 = new Stack<Node>();
			Stack<Node> s2 = new Stack<Node>(); //辅助栈
			s1.push(head);
			while (!s1.isEmpty()) {
				head = s1.pop();
				s2.push(head); // 弹出元素 压入辅助栈
				if (head.left != null) {
					s1.push(head.left);
				}
				if (head.right != null) {
					s1.push(head.right);
				}
			}
			//打印栈中元素 左 右 中
			while (!s2.isEmpty()) {
				System.out.print(s2.pop().value + " ");
			}
		}
		System.out.println();
	}

	public static void posOrderUnRecur2(Node h) {
		System.out.print("pos-order: ");
		if (h != null) {
			Stack<Node> stack = new Stack<Node>();
			stack.push(h);
			Node c = null;
			while (!stack.isEmpty()) {
				c = stack.peek();
				if (c.left != null && h != c.left && h != c.right) {
					stack.push(c.left);
				} else if (c.right != null && h != c.right) {
					stack.push(c.right);
				} else {
					System.out.print(stack.pop().value + " ");
					h = c;
				}
			}
		}
		System.out.println();
	}

	
}

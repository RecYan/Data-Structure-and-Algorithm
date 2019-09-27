package Algorithm.Tree;

import java.util.Stack;

/**
 * Created by Yan_Jiang on 2019/5/21.
 * 中序 递归 非递归遍历
 */
public class InorderTraversal {

    static class Node{
        int val = 0;
        Node left = null;
        Node right = null;

        public Node(int val){
            this.val = val;
        }
    }

    //递归实现
    public static void inorderTraversalRec(Node root) {
        if(root == null) {
            return;
        }
        inorderTraversalRec(root.left);
        System.out.print(root.val + " ");
        inorderTraversalRec(root.right);
    }

    //非递归实现
    public static void inorderTraversal(Node root) {
        Stack<Node> stack = new Stack<>();
        Node cur = root;

        while(cur != null || !stack.isEmpty()) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            //换节点
            cur = stack.pop();
            System.out.print(cur.val + " ");
            cur = cur.right;
        }
    }

    public static void review(Node root) {
        Stack<Node> stack = new Stack<>();
        Node cur = root;

        while(cur != null || !stack.isEmpty()) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            System.out.print(cur.val + " ");
            cur = cur.right;

        }


    }


    public static void main(String[] args) {
        Node root = new Node(5);
        Node a = new Node(3);
        Node b = new Node(6);
        Node c = new Node(2);
        Node d = new Node(4);
        Node e = new Node(8);

        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.right = e;

        inorderTraversalRec(root);
        System.out.println();
        inorderTraversal(root);
        System.out.println();
        review(root);
    }
}

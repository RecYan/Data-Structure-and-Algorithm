package Algorithm.Tree;

import java.util.Stack;

/**
 * Created by Yan_Jiang on 2019/5/29.
 * 二叉搜索树的第K小的节点
 *  第K小 中序遍历 数据从小到大递增
 *
 */
public class KthNode {

    static class Node{
        int val = 0;
        Node left = null;
        Node right = null;

        public Node(int val){
            this.val = val;
        }
    }

    private static int count = 0;


    //第K小
    public static Node kthNodeMin(Node root, int k) {

        if(root == null || k < 0 ) {
            return null;
        }

        Stack<Node> stack = new Stack<>();
        Node cur = root;

        while(cur != null || !stack.isEmpty()) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            System.out.print(cur.val + " ");
            count ++;
            if(count == k) {
                return cur;
            }
            cur = cur.right;
        }
        return null;
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

        System.out.println(" --> "+ kthNodeMin(root, 3).val);
    }
}

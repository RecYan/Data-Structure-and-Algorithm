package Algorithm.Tree;

import java.util.Stack;

/**
 * Created by Yan_Jiang on 2019/5/21.
 * 前序 递归 非递归遍历
 */
public class PreorderTraversal {

    static class Node{
        int val = 0;
        Node left = null;
        Node right = null;

        public Node(int val){
            this.val = val;
        }
    }

    //递归前序遍历
    public static void preorderTraversalRec(Node root) {

        if(root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preorderTraversalRec(root.left);
        preorderTraversalRec(root.right);
    }

    //非递归前序遍历 -- 栈
    /**
     将节点左子树全部压栈
     如果栈不为空则弹出栈顶元素并将其加入遍历结果，指向当前节点右子树
     若当前节点和栈均为空，则结束遍历；否则继续循环上述操作
     */
    public static void preorderTraversal(Node root) {

        Stack<Node> stack = new Stack<>();
        Node cur = root;

        while(cur != null || !stack.isEmpty()) {
            while(cur != null) {
                System.out.print(cur.val + " ");
                stack.push(cur);
                cur = cur.left;
            }
            //换节点
            cur = stack.pop();
            cur = cur.right;
        }

    }


    public static void review2(Node root) {
        Stack<Node> stack = new Stack<>();
        Node cur = root;

        while(cur != null || !stack.isEmpty()) {
            while(cur != null) {
                System.out.print(cur.val + "");
                stack.push(cur);
                cur = cur.left;
            }
            //换右节点
            stack.pop();
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

        preorderTraversalRec(root);
        System.out.println();
        //review1(root);
        System.out.println();
        preorderTraversal(root);
    }
}

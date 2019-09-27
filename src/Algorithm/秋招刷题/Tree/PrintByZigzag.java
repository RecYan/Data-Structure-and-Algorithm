package Algorithm.Tree;

import java.util.Stack;

/**
 * Created by Yan_Jiang on 2019/5/25.
 * 之字形打印二叉树
 * 偶数层 右向左
 * 奇数层 左向右
 * 需要两个栈。我们在打印某一行结点时，
 * 把下一层的子结点保存到相应的栈里。
 * 奇数层，则先保存左子结点再保存右子结点到一个栈里；
 * 偶数层，则先保存右子结点再保存左子结点到第二个栈里。
 */
public class PrintByZigzag {

    static class Node{
        int val = 0;
        Node left = null;
        Node right = null;

        public Node(int val){
            this.val = val;
        }
    }

    public static void printZigzag(Node root) {

        if(root == null) {
            return;
        }

        Stack<Node> cur = new Stack<>(); //当前
        Stack<Node> reverse = new Stack<>(); //下一层
        int flag = 0;
        Node node = null;

        cur.push(root);
        while(!cur.isEmpty()) {
            node = cur.pop();
            System.out.print(node.val + " ");
            //左往右打印，下层节点从左往右入栈
            if(flag == 0) {
                if(node.left != null) {
                    reverse.push(node.left);
                }
                if(node.right != null) {
                    reverse.push(node.right);
                }
            } else {
                //右往左打印，下层节点从右往左入栈
                if(node.right != null) {
                    reverse.push(node.right);
                }
                if(node.left != null) {
                    reverse.push(node.left);
                }
            }
            //换行逻辑处理
            if(cur.isEmpty()) {
                flag = 1 - flag;
                //cur与reverse交换
                Stack<Node> tmp = cur;
                cur = reverse;
                reverse = tmp;
                System.out.println();
            }
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

        printZigzag(root);

    }
}

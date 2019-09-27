package Algorithm.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Yan_Jiang on 2019/5/25.
 * 按行打印二叉树
 *  对比层序打印
 */
public class PrintByLine {

    static class Node{
        int val = 0;
        Node left = null;
        Node right = null;

        public Node(int val){
            this.val = val;
        }
    }

    public static void printByLine(Node root) {

        if(root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int nextLevel = 0; //下一层节点数
        int curLevel = 1; //当前层节点数

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            curLevel --;
            System.out.print(node.val + " ");
            if(node.left != null) {
                queue.add(node.left);
                nextLevel ++;
            }
            if(node.right != null) {
                queue.add(node.right);
                nextLevel ++;
            }
            //换行打印
            if(curLevel == 0) {
                System.out.println();
                curLevel = nextLevel;
                nextLevel = 0;
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

        printByLine(root);

    }
}

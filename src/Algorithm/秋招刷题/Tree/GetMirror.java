package Algorithm.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Yan_Jiang on 2019/5/23.
 *  求树的镜像
 *
 *   根结点是不用交换
 *   只需要把根节点的左右孩子一一交换
 */
public class GetMirror {

    static class Node{
        int val = 0;
        Node left = null;
        Node right = null;

        public Node(int val){
            this.val = val;
        }
    }

    public static void getMirror(Node root) {

        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            return;
        }

        swap(root.left, root.right);
        if(root.left != null) {
            getMirror(root.left);
        }
        if(root.right != null) {
             getMirror(root.right);
        }
    }

    //交换节点
    private static void swap(Node left, Node right) {
        Node temp = left;
        left = right;
        right = temp;
    }

    private static void review(Node root) {
        //前序遍历
        if(root == null) {
            return;
        }
        //叶子节点结束遍历
        if(root.left == null && root.right == null) {
            return;
        }
        //交换节点
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        if(root.left != null){
            review(root.left);
        }
        if(root.right != null) {
            review(root.right);
        }
    }

    public static void levelorderTraversal(Node root) {

        Queue<Node> queue = new LinkedList<>();
        Node cur = root;

        queue.add(cur);
        while(!queue.isEmpty()) {
            cur = queue.poll();
            System.out.print(cur.val + " ");
            if(cur.left != null) {
                queue.add(cur.left);
            }
            if(cur.right != null) {
                queue.add(cur.right);
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

        getMirror(root);
        levelorderTraversal(root);



    }
}

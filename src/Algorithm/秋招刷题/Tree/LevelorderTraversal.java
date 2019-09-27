package Algorithm.Tree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Yan_Jiang on 2019/5/21.
 * 层序遍历
 */
public class LevelorderTraversal {

    static class Node{
        int val = 0;
        Node left = null;
        Node right = null;

        public Node(int val){
            this.val = val;
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


    public static void review(Node root) {

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


    }
}

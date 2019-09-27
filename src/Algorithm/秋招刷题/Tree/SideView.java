package Algorithm.Tree;


import java.util.LinkedList;

import java.util.Queue;

/**
 * 二叉树锯齿形遍历
 */
public class SideView {

    static class Node {
        int val = 0;
        Node left = null;
        Node right = null;
        Node parent = null;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void LeftSideView(Node root) {

        if(root == null) {
            return;
        }
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        //当前层节点个数
        int size = 1;
        //记录下一层节点数
        int nextLevel = 0;
        while (!queue.isEmpty()) {
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                size--;
                /**
                 * 左视图 i = 0,说明是该层第一个结点
                 * 右视图 则是 i == size-1
                 */
                if (i == 0) {
                    System.out.print(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                    nextLevel ++;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    nextLevel ++;
                }
            }
            //换行 nextLevel需要清零
            if(size == 0) {
                System.out.println();
                size = nextLevel;
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

        LeftSideView(root);
    }
}


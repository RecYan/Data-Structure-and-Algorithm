package Algorithm.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Yan_Jiang on 2019/5/21.
 * 获取数的节点个数
 * 如果二叉树为空，节点个数为0
   如果二叉树不为空，二叉树节点个数 = 左子树节点个数 + 右子树节点个数 + 1
 */
public class GetNodeNum {

    static class Node{
        int val = 0;
        Node left = null;
        Node right = null;

        public Node(int val){
            this.val = val;
        }
    }

    public static int getNodeNumRec(Node root) {
        if(root == null) {
            return 0;
        }
        return getNodeNumRec(root.left) + getNodeNumRec(root.right) + 1;
    }

    //非递归 -- 层序遍历的时候加入计算
    public static int getNodeNum(Node root) {

        Queue<Node> queue = new LinkedList<>();
        Node cur = root;
        int count = 1;

        queue.add(cur);
        while(!queue.isEmpty()) {
            cur = queue.poll();
            if(cur.left != null) {
                queue.add(cur.left);
                count ++;
            }
            if(cur.right != null) {
                queue.add(cur.right);
                count ++;
            }
        }
        return count;
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

        System.out.println(getNodeNumRec(root));
        System.out.println(getNodeNum(root));

    }
}

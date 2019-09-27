package Algorithm.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Yan_Jiang on 2019/5/21.
 * 树的叶子节点数量
 *如果二叉树为空，返回0
  如果二叉树是叶子节点，返回1
  如果二叉树不是叶子节点，二叉树的叶子节点数 = 左子树叶子节点数 + 右子树叶子节点数
 */
public class GetNodeNumLeaf {

    static class Node{
        int val = 0;
        Node left = null;
        Node right = null;

        public Node(int val){
            this.val = val;
        }
    }

    //递归实现
    public static int getNodeNumLeafRec(Node root) {

        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        return getNodeNumLeafRec(root.left) + getNodeNumLeafRec(root.right);
    }

    //非递归 -- 层序遍历计数
    public static int getNodeNumLeaf(Node root) {

        Queue<Node> queue = new LinkedList<>();
        Node cur = root;
        int count = 0;

        queue.add(cur);
        while(!queue.isEmpty()) {
            cur = queue.poll();
            //计数判断
            if(cur.left == null && cur.right == null) {
                count ++;
            }

            if(cur.left != null) {
                queue.add(cur.left);
            }
            if(cur.right != null) {
                queue.add(cur.right);
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

        System.out.println(getNodeNumLeafRec(root));
        System.out.println(getNodeNumLeaf(root));

    }
}

package Algorithm.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Yan_Jiang on 2019/5/21.
 * 树的深度
 * 如果二叉树为空，二叉树的深度为0
   如果二叉树不为空，二叉树的深度 = max(左子树深度， 右子树深度) + 1
 */
public class getDepth {

    static class Node{
        int val = 0;
        Node left = null;
        Node right = null;

        public Node(int val){
            this.val = val;
        }
    }

    public static int getDepthRec(Node root) {
        if(root == null) {
            return 0;
        }
        return Math.max(getDepthRec(root.left), getDepthRec(root.right)) + 1;
    }

    //非递归 层序遍历计算
    public static int getDepth(Node root) {
        if(root == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        Node cur = root;
        int depth = 0;
        int currentLevelCount = 1; // 当前层的节点数量
        int nextLevelCount = 0; // 下一层节点数量

        queue.add(cur);
        while(!queue.isEmpty()) {
            cur = queue.poll();
            currentLevelCount --; //当前层节点数减一
            if(cur.left != null) {
                queue.add(cur.left);
                nextLevelCount ++;
            }
            if(cur.right != null) {
                queue.add(cur.right);
                nextLevelCount ++;
            }
            //当前层遍历结束
            if(currentLevelCount == 0) {
                depth ++;
                currentLevelCount = nextLevelCount; //下一层计数
                nextLevelCount = 0;  //本层的下一层归零
            }
        }
        return depth;
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

        System.out.println(getDepthRec(root));
        System.out.println(getDepth(root));

    }


}

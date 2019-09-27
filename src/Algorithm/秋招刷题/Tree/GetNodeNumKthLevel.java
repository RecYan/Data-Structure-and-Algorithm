package Algorithm.Tree;

/**
 * Created by Yan_Jiang on 2019/5/21.
 * 求树第K层节点的数量
 *  如果二叉树为空或者k<1，返回0
    如果二叉树不为空并且k==1，返回1
    如果二叉树不为空且k>1，返回root左子树中k-1层的节点个数与root右子树k-1层节点个数之和
 */
public class GetNodeNumKthLevel {

    static class Node{
        int val = 0;
        Node left = null;
        Node right = null;

        public Node(int val){
            this.val = val;
        }
    }

    public static int getNodeNumKthLevel(Node root, int k) {

        if(root == null || k < 0) {
            return 0;
        }
        if(k == 1) {
            return 1;
        }
        return getNodeNumKthLevel(root.left, k-1) + getNodeNumKthLevel(root.right, k-1);
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

        System.out.println(getNodeNumKthLevel(root, 3));


    }
}

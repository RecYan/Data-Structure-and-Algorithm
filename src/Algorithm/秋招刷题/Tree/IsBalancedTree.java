package Algorithm.Tree;

/**
 * Created by Yan_Jiang on 2019/5/21.
 * 判断是否为平衡二叉树 --> 树中任意一个左右子树的高度差小于等于1
 * 如果二叉树为空， 返回真
   如果二叉树不为空，如果任意一个左子树和右子树高度相差不大于1，返回真，其他返回假
 */
public class IsBalancedTree {

    static class Node{
        int val = 0;
        Node left = null;
        Node right = null;

        public Node(int val){
            this.val = val;
        }
    }

    private static boolean isBalance = true;

    public static boolean isBalancedTree(Node root) {
        if(root == null) {
            return true;
        }
        if(Math.abs(getDepth(root.left)- getDepth(root.right)) > 1){
            return false;
        }
        return isBalancedTree(root.left) && isBalancedTree(root.right);
    }



    //非递归 后续遍历 记录每个节点的深度
    public static boolean isBalancedTree2(Node root){
        getDepth(root);
        return isBalance;
    }

    public static int getDepth(Node root) {
        if(root == null) {
            isBalance = true;
            return 0;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.left);

        if(Math.abs(leftDepth - rightDepth) >1 ) {
            isBalance = false;
        }
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
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

        System.out.println(isBalancedTree(root));
        System.out.println(isBalancedTree2(root));

    }

}

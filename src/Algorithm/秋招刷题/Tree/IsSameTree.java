package Algorithm.Tree;

/**
 * Created by Yan_Jiang on 2019/5/21.
 * 判断两个树是否为同一颗树
 *  如果两棵二叉树都为空，返回真
    如果两棵二叉树一棵为空，另外一棵不为空，返回假
    如果两棵二叉树都不为空，如果对应的左子树和右子树都同构返回真，其他返回假
 */
public class IsSameTree {

    static class Node{
        int val = 0;
        Node left = null;
        Node right = null;

        public Node(int val){
            this.val = val;
        }
    }

    public static boolean isSameRec(Node root1, Node root2) {

        if(root1 == null && root2 == null) {
            return true;
        }

        if(root1 == null || root2 == null) {
            return false;
        }
        if(root1.val != root2.val) {
            return false;
        }
        return (isSameRec(root1.left, root2.left) && isSameRec(root1.right, root2.right));
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

        Node root2 = new Node(5);
        Node a2 = new Node(3);
        Node b2 = new Node(6);
//        Node c2 = new Node(2);
//        Node d2 = new Node(4);
//        Node e2 = new Node(8);

        root2.left = a2;
        root2.right = b2;
//        a2.left = c2;
//        a2.right = d2;
//        b2.right = e2;

        System.out.println(isSameRec(root, root2));


    }
}

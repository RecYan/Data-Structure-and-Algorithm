package Algorithm.Tree;

/**
 * Created by Yan_Jiang on 2019/5/22.
 * 判断树是否镜像对称
 *  比较r1的左子树的镜像是不是r2的右子树
    比较r1的右子树的镜像是不是r2的左子树
    [判断两个树是否为同一个树改版]
 */
public class IsMirror {

    static class Node{
        int val = 0;
        Node left = null;
        Node right = null;

        public Node(int val){
            this.val = val;
        }
    }

    public static boolean isMirrorRec(Node root) {
        return isMirrorRec(root, root);
    }

    private static boolean isMirrorRec(Node root1, Node root2) {

        if(root1 == null && root2 == null) {
            return true;
        }
        if(root1 == null || root2 == null) {
            return false;
        }
        if(root1.val != root2.val) {
            return false;
        }
        return isMirrorRec(root1.left, root2.right) && isMirrorRec(root1.right, root2.left);
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

        System.out.println(isMirrorRec(root));


    }
}

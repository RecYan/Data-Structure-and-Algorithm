package Algorithm.Tree;

/**
 * Created by Yan_Jiang on 2019/5/23.
 * 判断一个子树B是否是树A的子结构
 *  1. 树A中找到和子树B一样的节点R -- 遍历
 *  2. 判断树A中以R为节点的子树是否与子树B一样的结构 -- 树判断是否为同一个树
 */
public class HasSubTree {

    private static boolean result = false;

    static class Node{
        int val = 0;
        Node left = null;
        Node right = null;

        public Node(int val){
            this.val = val;
        }
    }

    /*//root1是否为root2中的一部分
    public static boolean hasSubTree(Node root1, Node root2) {

        if(root1 != null && root2 != null) {

            if(root1.val == root2.val) {
                result = isSameTree(root1, root2);
            }
            if(!result) {
                hasSubTree(root1.left, root2);
            }
            if(!result) {
                hasSubTree(root1.right, root2);
            }
        }
        return result;

    }

    //子树判断 - 子结构在判断在上面
    private static boolean isSameTree(Node root1, Node root2) {

        if(root2 == null) {
            return true;
        }
        if(root1 == null) {
            return false;
        }
        if(root1.val != root2.val) {
            return false;
        }
        return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
    }*/

    //在root1中找到与root2根节点相同的节点
    public static boolean review(Node root1, Node root2) {

        boolean result = false;
        if(root1 != null && root2 != null) {
            //找到了相同的根节点
            if(root1.val == root2.val) {
                result = hasSubTree(root1, root2);
            }
            if(!result) {
                result = review(root1.left, root2);
            }
            if(!result) {
                result = review(root1.right, root2);
            }
        }
        return result;
    }

    //根节点相同的树 判断结构是都相同<节点值是否相等> 终止条件为 遍历到了root1或root2的叶节点
    private static boolean hasSubTree(Node root1, Node root2) {

        if(root2 == null) {
            return true;
        }
        if(root1 == null) {
            return false;
        }

        if(root1.val != root2.val) {
            return false;
        }
        //递归判断 左 右 节点元素是否相同
        return hasSubTree(root1.left, root2.left) && hasSubTree(root1.right, root2.right);

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

        root2.left = a2;
        root2.right = b2;


        System.out.println(hasSubTree(root, root2));


    }
}

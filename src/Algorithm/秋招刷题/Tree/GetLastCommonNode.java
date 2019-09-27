package Algorithm.Tree;

/**
 * Created by Yan_Jiang on 2019/5/23.
 * 求树中两个节点的公共最低祖先
 */
public class GetLastCommonNode {

    static class Node{
        int val = 0;
        Node left = null;
        Node right = null;

        public Node(int val){
            this.val = val;
        }
    }

    //BST情况
    /**
     * 假设是二叉搜索树（二叉搜索树是一个排序的二叉树，左子树的结点小于根结点，右子树的结点大于根结点），
     * 故找到一个结点，使其大于左子结点小于右子结点即可。
     * */
    public static Node getLastCommonNode(Node right, Node left, Node root) {

        Node node = root;

        if(node == null || left.val > right.val) {
            return null;
        }

        if(node.val >= right.val) {
            node = getLastCommonNode(node.left, right, left);
        }
        if(node.val <= left.val) {
            node = getLastCommonNode(node.right, right, left);
        }
        if(node.val >= left.val && node.val <= right.val) {
            return node;
        }
        return node;
    }
}

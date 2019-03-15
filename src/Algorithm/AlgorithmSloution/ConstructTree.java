package Algorithm.AlgorithmSloution;

/**
 * Created by Yan_Jiang on 2019/3/13.
 * 输入某二叉树的前序遍历和中序遍历的结果，
 *  请重建出该二节树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *      前序确定root节点的值
 *          中序中确定root节点的位置 --> root节点之前的元素为树的左孩子 root节点之后的元素为数的右孩子
 */
public class ConstructTree {

    /**
     * 二叉树节点类
     */
    public static class BinaryTreeNode {
        private int value; //节点值
        private BinaryTreeNode left; //左孩子
        private BinaryTreeNode right; //右孩子
    }

    public static BinaryTreeNode construct(int[] preorder, int[] inorder) {
        // 输入的合法性判断，两个数组都不能为空，并且都有数据，而且数据的数目相同
        if (preorder == null || inorder == null || preorder.length != inorder.length || inorder.length < 1) {
            return null;
        }
        return construct(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    /**
     *  preorder 前序遍历
     *  ps       前序遍历的开始位置
     *  pe       前序遍历的结束位置
     * inorder  中序遍历
     * is       中序遍历的开始位置
     * ie       中序遍历的结束位置
     * */
    private static BinaryTreeNode construct(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {

        // 开始位置大于结束位置说明已经没有需要处理的元素了
        if (ps > pe) {
            return null;
        }
        // 取前序遍历的第一个数字，就是当前的根结点
        int value = preorder[ps];
        int index = is;
        // 在中序遍历的数组中找根结点的位置
        while (index <= ie && inorder[index] != value) {
            index++;
        }
        // 如果在整个中序遍历的数组中没有找到，说明输入的参数是不合法的，抛出异常
        if (index > ie) {
            throw new RuntimeException("Invalid input");
        }
        // 创建当前的根结点，并且为结点赋值
        BinaryTreeNode node = new BinaryTreeNode();
        node.value = value;
        // 递归构建当前根结点的左子树，左子树的元素个数：index-is+1个
            // 左子树在前序遍历的位置在[ps+1, ps+index-is]
            // 左子树在中序遍历的位置在[is, index-1]
        node.left = construct(preorder, ps + 1, ps + index - is, inorder, is, index - 1);
        // 递归构建当前根结点的右子树，右子树的元素个数：ie-index个
            // 右子树在前序遍历的位置在[ps+index+1-is, pe]
            // 右子树在中序遍历的位置在[index+1, ie]
        node.right = construct(preorder, ps + index - is + 1, pe, inorder, index + 1, ie);
        // 返回创建的根结点
        return node;

    }

    // 中序遍历二叉树
    public static void printTree(BinaryTreeNode root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.value + " ");
            printTree(root.right);
        }
    }


}

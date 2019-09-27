package Algorithm.Tree;

/**
 * Created by Yan_Jiang on 2019/5/24.
 * 判断一组数是否为BST的后续遍历结果
 *      后续遍历 左右根 ， BST 左<根<右 递归判断
 *      [5,7,6,9，11,10,8] --> 左 5,7,6 右 9,11,10, 根 8
 *
 *  BST判断
 */
public class VerifySquenceofBST {

    public static boolean verifySequenceOfBST(int[] seqence) {
        if(seqence == null || seqence.length < 0) {
            return false;
        }
        return verifySequenceOfBST(seqence, 0 , seqence.length-1);
    }

    private static boolean verifySequenceOfBST(int[] sequence, int start, int end) {
        // 如果对应要处理的数据只有一个或者已经没有数据要处理（start>end）就返回true
        if (start >= end) {
            return true;
        }
        // 左子树截止节点下标
        int index = start;
        while (index < end - 1 && sequence[index] < sequence[end]) {
            index++;
        }
        // 执行到此处[start, index-1]的元素都是小于根结点的（sequence[end]）
        // [start, index-1]可以看作是根结点的左子树
        // 接下来要保证[index, end-1]的所有元素都是大于根点的
        // 因为[index, end-1]只有成为根结点的右子树
        // 从第一个不小于根结点的元素开始，找第一个不大于根结点的元素
        while (index < end - 1 && sequence[index] > sequence[end]) {
            index++;
        }
        // 如果条件满足，那么一定有index=end-1，
        // 如果不满足那说明根结点的右子树[index, end-1]中有小于等于根结点的元素，
        // 不符合二叉搜索树的定义，返回false
        if (index != end - 1) {
            return false;
        }
        // 执行到此处说明直到目前为止，还是合法的
        // [start, index-1]为根结点左子树的位置
        // [index, end-1]为根结点右子树的位置
        return verifySequenceOfBST(sequence, start, index - 1) && verifySequenceOfBST(sequence, index, end - 1);
    }

    public static void main(String[] args) {
        int[] seq = {5,7,6,9, 11,10,8};
        System.out.println(verifySequenceOfBST(seq));
    }
}

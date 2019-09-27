package Algorithm.Tree;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *   左右等分建立左右子树，中间节点作为子树根节点，递归该过程
 */
public class SortedArrayToBST {

    static class Node{
        int val = 0;
        Node left = null;
        Node right = null;

        public Node(int val){
            this.val = val;
        }
    }

    public static Node sortedArrayToBST(int[] nums) {

       if(nums == null || nums.length <0) {
           return null;
       }
       return sortedArrayToBST(nums, 0, nums.length-1);

    }

    private static Node sortedArrayToBST(int[] nums, int L, int R) {

        if(L > R) {
            return null;
        }

        int mid = L + (R-L)/2;
        Node root = new Node(nums[mid]);
        root.left = sortedArrayToBST(nums, L, mid-1);
        root.right = sortedArrayToBST(nums, mid+1, R);
        return root;
    }
}

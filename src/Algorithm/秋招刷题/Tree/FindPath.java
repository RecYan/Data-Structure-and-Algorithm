package Algorithm.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yan_Jiang on 2019/5/24.
 * 二叉树中和为某一值的路径
 *   路径：根节点到叶节点元素路径
 *   当用前序遍历的方式访问到某一节点时，我们把该结点添加到路径上，并累加该结点的值。
 *   如果该结点为叶结点并且路径中结点值的和刚好为输入的整数，则当前的路径符合要求，我们把它打印出来。
 *   如果当前的结点不是叶结点，则继续访问它的子节点。当前结点访问结束后，递归函数将自动回到它的父节点。
 *   因此我们在函数退出之前要在路径上删除当前结点并减去当前结点的值，以确保返回父节点时路径刚好是从根节点到父节点的路径。
 */
public class FindPath {

    static class Node{
        int val = 0;
        Node left = null;
        Node right = null;

        public Node(int val){
            this.val = val;
        }
    }

    public static void findPath(Node root, int expectSum) {
        List<Integer> list = new ArrayList<>(); //保存路径
        if(root != null) {
            findPath(root, 0, expectSum, list);
        }
    }

    private static void findPath(Node root, int curSum, int expectSum, List<Integer> list) {

            curSum = curSum + root.val;
            list.add(root.val); //保存路径

            //找到了且遍历到叶子节点 打印输出
            if (curSum == expectSum) {
                //叶节点 输出结果
                if (root.left == null && root.right == null) {
                    System.out.println(list);
                }
            }
            //不是叶子节点 则访问 左 右 子节点
            if(root.left != null) {
                findPath(root.left, curSum, expectSum, list);
            }
            if(root.right != null) {
                findPath(root.right, curSum, expectSum, list);
            }
            //利用list模拟栈 -- 返回父节点之前 删除当前节点
            list.remove(list.size() - 1);
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

        findPath(root, 10);



    }




}

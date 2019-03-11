package Algorithm.AlgorithmSloution;


import java.util.Stack;

/**
 * Created by Yan_Jiang on 2019/3/10.
 * 单链表反转
 *  1-2-3-4-5
 *  -> 5-4-3-2-1
 */
public class ReverseList {

    //节点对象
    public static class ListNode {
        int val; // 结点的值
        ListNode next; // 下一个结点
    }


    //使用栈辅助
    public static void Solution1(ListNode root) {

        Stack<ListNode> stack = new Stack<>();

        if(root != null) {
            stack.push(root);
            root = root.next;
        }
        ListNode tmp = null;
        while(!stack.isEmpty()) {
            tmp = stack.pop();
            System.out.println("after reverse: " + tmp.val +" ");
        }
    }

    //递归
    public static void Solution2(ListNode root) {

        if(root != null) {
            Solution2(root.next);
            System.out.println("after reverse: " + root.val +" ");
        }
    }

    //改变链表结构 遍历实现
    public static void Solution3(ListNode root) {


    }


}

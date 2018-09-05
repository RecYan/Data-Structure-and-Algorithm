package Recursion;

/**
 * Created by Yan_Jiang on 2018/9/5.
 * 使用递归来完成链表删除操作
 */
public class Solution2 {

    public ListNode removeElements(ListNode head, int val) {

       if(head == null) {
           return null;
       }

       head.next = removeElements(head.next, val);

       return head.val == val ? head.next : head;
       /*ListNode res = removeElements(head.next, val);

       // 头结点数据为需要删除的数据时
       if(head.val == val) {
           return res; //删除头结点之后的链表
        } else {
           // 表中重复元素操作
           head.next = res; // 头结点 + 已经删去重复元素的链表
           return head;
       }*/
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 6, 3, 4, 6};
        ListNode listNode = new ListNode(nums);
        System.out.println(listNode);

        ListNode node = (new Solution2()).removeElements(listNode, 6);
        System.out.println(node);

    }

}

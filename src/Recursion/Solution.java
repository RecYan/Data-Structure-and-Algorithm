package Recursion;

/**
 * Created by Yan_Jiang on 2018/9/5.
 * 输入: 1->2->6->3->4->5->6, val = 6
   输出: 1->2->3->4->5
 */
public class Solution {

    public ListNode removeElements(ListNode head, int val) {

        //使用虚拟头结点 统一链表头和链表中中间节点的操作 简化代码逻辑
        ListNode dummyHead = new ListNode(-1); //虚拟头结点 指向head的前一个节点 对用户屏蔽

        ListNode prev = dummyHead.next;
        while(prev.next != null) {
            if((prev.next).val == val) {

                ListNode delNode = prev.next;
                prev.next = (prev.next).next;
                delNode.next = null;
            } else {
                prev = prev.next;
            }
        }

        return dummyHead.next;


        /*//不使用虚拟头结点
        //链表为空处理
        if(head == null) {
            return null;
        }
        //处理头结点情况
        while(head != null && head.val == val) {

            ListNode delNode = head; //保存带删除的节点
            head = head.next;
            delNode.next = null;
        }
        //处理中间节点情况 -- 关键在于找待删除节点的前一个节点
        ListNode prev = head; //初始时候 和head指向相同 指向待删除节点的前一个节点
        while(prev.next != null) {
            if((prev.next).val == val) {

                ListNode delNode = prev.next;
                prev.next = (prev.next).next;
                delNode.next = null;
            } else {
                prev = prev.next;
            }
        }
        return  head;*/
    }
}

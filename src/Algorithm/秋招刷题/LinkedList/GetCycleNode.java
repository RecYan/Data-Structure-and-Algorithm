package Algorithm.LinkedList;

/**
 * Created by Yan_Jiang on 2019/5/19.
 * 获取链表环入口结点
 */
public class GetCycleNode {

    static class Node {
        Node next = null;
        int val;
        public Node(int val) {
            this.val = val;
        }
    }

    /**
     * 快慢指针相遇时
     *  将其中任一指针移向链表头部 两个指针已相同步长向前移动 直到再次相遇
     * @param head
     * @return
     */
    public static Node getCycleNode(Node head) {

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                slow = head; //指针移到头部
                while(slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return new Node(-1);
    }
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2); //环入口节点
        Node c = new Node(3);
        Node d = new Node(4);
        Node f = new Node(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = f;
        f.next= b;
        System.out.println(getCycleNode(a).val);
    }
}

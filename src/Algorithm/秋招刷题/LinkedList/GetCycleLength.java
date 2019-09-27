package Algorithm.LinkedList;

/**
 * Created by Yan_Jiang on 2019/5/19.
 * 获取链表环大小
 */
public class GetCycleLength {

    static class Node {
        Node next = null;
        int val;
        public Node(int val) {
            this.val = val;
        }
    }

    public static Node isLoopList(Node head) {

        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                return slow;
            }
        }
        return new Node(-1);
    }

    public static int getCycleLength(Node head) {

        Node first = isLoopList(head); //指针第一次相遇节点
        Node cur = first.next;

        int lenth = 1;
        while(cur != first) {
            lenth ++;
            cur = cur.next;
        }
        return lenth;
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node f = new Node(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = f;
        f.next= b;
        System.out.println(getCycleLength(a));
    }

}

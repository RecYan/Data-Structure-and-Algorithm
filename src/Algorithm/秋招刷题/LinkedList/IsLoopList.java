package Algorithm.LinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Yan_Jiang on 2019/5/18.
 * 链表判断环
 *  //快指针是否越界处理
 */
public class IsLoopList {
    static class Node {
        Node next = null;
        int val;
        public Node(int val) {
            this.val = val;
        }
    }

    public static boolean isLoopList(Node head) {

        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
               // System.out.println(fast.val);
                return true;
            }
        }
        return false;
    }

    //利用辅助空间 set去重
    public static boolean isLoopListII(Node head) {
        Set<Node> node = new HashSet<>();
        while (head != null) {
            if (node.contains(head))
                return true;
            else
                node.add(head);
            head = head.next;
        }
        return false;
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
        System.out.println(isLoopList(a));
        System.out.println(isLoopListII(a));

    }
}

package Algorithm.LinkedList;

import java.util.Stack;

/**
 * 从尾到头打印链表
 *  栈辅助
 */
public class PrintReversingly {

    static class Node {
        Node next = null;
        int val;
        public Node(int val) {
            this.val = val;
        }
    }

    public static void printReversingly(Node head) {

        if(head == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while(cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        while(!stack.isEmpty()) {
            cur = stack.pop();
            System.out.print(cur.val + " ");
        }
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
        f.next = null;
        //f.next= b;
        printReversingly(a);
    }
}

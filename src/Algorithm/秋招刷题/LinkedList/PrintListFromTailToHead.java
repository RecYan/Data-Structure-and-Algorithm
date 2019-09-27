package Algorithm.LinkedList;

import java.util.Stack;

/**
 * Created by Yan_Jiang on 2019/5/20.
 * 从尾到头打印链表
 *  栈
 *  ArrayList倒序遍历
 *  反转链表后遍历打印
 */
public class PrintListFromTailToHead {

    static class Node {
        Node next = null;
        int val;
        public Node(int val) {
            this.val = val;
        }
    }

    public static void printListFromTailToHead (Node head) {

        Stack<Integer> stack = new Stack<>();

        Node node = head;

        while(node != null) {
            stack.push(node.val);
            node = node.next;
        }

        while(!stack.isEmpty()) {
            System.out.print(stack.pop()+" ");
        }
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
        f.next = null;
        //f.next= b;
       printListFromTailToHead(a);
    }
}

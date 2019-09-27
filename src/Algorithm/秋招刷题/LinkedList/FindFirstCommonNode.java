package Algorithm.LinkedList;

/**
 * Created by Yan_Jiang on 2019/5/20.
 * 两个链表的第一个公共节点
 * 开始遍历两遍链表获取两个表的长度，比较长度让长的一个先走差值个步长，
    再两个一起走。（快慢指针思想，也是链表问题的一般性思路）
 */
public class FindFirstCommonNode {

    static class Node {
        Node next = null;
        int val;
        public Node(int val) {
            this.val = val;
        }
    }

    public static Node findFirstCommonNode(Node node1, Node node2) {

        Node p  = node1;
        Node q = node2;
        int length1 = getLength(node1);
        int length2 = getLength(node2);

        if(length1 >= length2) {
            int lengthDif = length1 - length2;
            while (lengthDif > 0){
                p = p.next;
                lengthDif --;
            }
        } else {
            int lengthDif = length2 - length1;
            while(lengthDif > 0) {
                q = q.next;
                lengthDif --;
            }
        }
        while (p!=null && q!=null) {
            if(p.val == q.val) {
                return p;
            }
            p = p.next;
            q = q.next;
        }
        return null;
    }

    public static int getLength(Node head) {
        int count = 0;
        while(head != null) {
            count ++;
            head = head.next;
        }
        return count;
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(6);
        Node f = new Node(7);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = f;

        Node a1 = new Node(4);
        Node a2 = new Node(5);
        Node a3 = new Node(6);
        Node a4 = new Node(7);
        a1.next = a2;
        a2.next = a3;
        a3.next =a4;

        Node node = findFirstCommonNode(a, a1);
        System.out.println(node.val);


    }
}

package Algorithm.LinkedList;

/**
 * Created by Yan_Jiang on 2019/5/20.
 * 反转单链表
 *  三个指针 前置指针 当前指针 后置指针
 */
public class ReverseList {

    static class Node {
        Node next = null;
        int val;
        public Node(int val) {
            this.val = val;
        }
    }


    public static Node reverseList2(Node head) {

        //空链表 单节点 直接返回
        if(head == null || head.next == null) {
            return head;
        }

        Node prev = null;
        Node cur = head;
        Node next = null;
        Node reverseHead = null; //翻转后的头结点

        //循环法 -- 就地逆置法
        //每次循环，都将当前节点指向它前面的节点，然后当前节点和前节点后移
        while(cur != null) {
            next = cur.next; //保存后一个节点
            if(next == null) { //遍历到链表尾部
                reverseHead = cur; //返回新的头结点
            }
            cur.next = prev; //改变指针指向
            prev = cur; //prev后移
            cur = next; //cur后移
        }
        return reverseHead;
    }



    /*public static Node reverseList(Node head) {

        if(head == null ) {
            return null;
        }

        Node reverseHead = null; //翻转后的头结点
        Node pre = null; //前置节点
        Node node = head; //当前节点

        while(node != null) {
            Node next = node.next;
            if(next == null) {
                reverseHead = node; //遍历到链表尾部
            }
            node.next = pre; //修改指针指向
            pre = node; //修改指针指向

            node = next; //保存节点 指针后移
        }
        return reverseHead;
    }*/

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
        Node node = reverseList2(a);
        while(node != null) {
            System.out.print(node.val+" ");
            node = node.next;
        }
    }

}

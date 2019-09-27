package Algorithm.LinkedList;

/**
 * Created by Yan_Jiang on 2019/5/17.
 * 删除链表重复元素
 */
public class DeleteDuplecate {
    static class Node {
        Node next = null;
        int val;
        public Node(int val) {
            this.val = val;
        }
    }

    // 1223 --> 123 (留一个)
    public static void deleteDuplcate(Node head) {

        Node p = head; //p指针外循环
        Node root = head;
        while(p != null) {
            Node q = p; //q指针内循环 删除重复元素
            while(q.next != null) {
                if(p.val == q.next.val) { //删除相等的数
                    q.next = q.next.next;
                } else {
                    q = q.next;
                }
            }
            p = p.next;//下一次
        }
        while(root != null) {
            System.out.println(root.val);
            root = root.next;
        }
    }

    //1223 --> 13 (不留，需要前置指针)
    public static void deleteDuplcate1(Node head) {

        Node dummyHead = new Node(-1); //引入虚拟节点
        dummyHead.next = head;

        Node p = head; //当前指针
        Node root = head; //打印使用
        Node last = dummyHead; //前置指针

        while(p != null && p.next != null) {
            if(p.val == p.next.val) {
                int val = p.val; //记录当前重复值
                while(p != null && p.val == val) {
                    p = p.next; //向后找重复的
                }
                last.next = p; //删除重复
            } else {
                //没有相同的值 则向后移动指针
                last = p;
                p = p.next;
            }
        }
        while(root != null) {
            System.out.println(root.val);
            root = root.next;
        }
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(2);
        Node d = new Node(3);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = null;
        deleteDuplcate(a);
        System.out.println("-----------------");
        deleteDuplcate1(a);

    }

}

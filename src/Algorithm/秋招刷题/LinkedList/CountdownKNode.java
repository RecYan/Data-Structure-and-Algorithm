package Algorithm.LinkedList;

/**
 * Created by Yan_Jiang on 2019/5/19.
 * 链表倒数第K个数
 *   1->2->3->4->5->2
 *   快指针提前走k-1步，
 *      快 慢指针再开始[步长为1]走 当快指针走到结尾时候，返回慢指针的位置
 */
public class CountdownKNode {
    static class Node {
        Node next = null;
        int val;
        public Node(int val) {
            this.val = val;
        }
    }

    public static Node countdownKNode(Node head, int k){

        if(head == null || k<0) {
            return null;
        }

        Node slow = head;
        Node fast = head;

        for(int i=0; i<k-1; i++) {
            if(fast.next != null) {
                fast = fast.next;
            }
        }

        while(fast !=null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;



    }





    /*public static Node countdownKNode(Node head, int k) {

        if (head == null || k <= 0){
            return new Node(-1);
        }
        Node slow = head;
        Node fast = head;

        for (int i=0; i<k-1; i++){
            if(fast.next != null) {
                fast = fast.next;
            } else {
                return new Node(-1);
            }
        }

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }*/

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
        System.out.println(countdownKNode(a, 2).val);
    }
}

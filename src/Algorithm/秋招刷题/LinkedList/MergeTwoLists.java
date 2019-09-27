package Algorithm.LinkedList;

/**
 * Created by Yan_Jiang on 2019/5/20.
 * 合并两个有序的链表
 */
public class MergeTwoLists {

    static class Node {
        Node next = null;
        int val;
        public Node(int val) {
            this.val = val;
        }
    }

    public static Node mergeTwoLists(Node node1, Node node2) {

        if(node1 == null) {
            return node2;
        } else if(node2 == null) {
            return node2;
        }

        Node mergeHead = null;

        if(node1.val <= node2.val) {
            mergeHead = node1;
            mergeHead.next = mergeTwoLists(node1.next, node2);
        } else if(node1.val > node2.val){
            mergeHead = node2;
            mergeHead.next = mergeTwoLists(node1, node2.next);
        }
        return mergeHead;
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);

        Node d = new Node(1);
        Node f = new Node(4);
        //Node g = new Node(5);
        a.next = b;
        b.next = c;
       //c.next = null;
        d.next = f;
      //  f.next = g;
        //f.next= b;
        Node node = mergeTwoLists(a, d);
        while(node != null) {
            System.out.print(node.val+" ");
            node = node.next;
        }
    }
}

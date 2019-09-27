package Algorithm.LinkedList;

/**
 * 链表部分翻转 从第n个至第m个
 *   头插法：依次取原链表中的每一个节点，将其作为第一个节点插入到新链表中
 *
 *   以1->2->3->4->5, m = 2, n=4 为例:
 *   定位到要反转部分的头节点 2，head = 2；前驱结点 1，pre = 1；
 *   当前节点的下一个节点3调整为前驱节点的下一个节点 1->3->2->4->5,
 *   当前结点仍为2， 前驱结点依然是1，重复上一步操作。。。
 *   1->4->3->2->5.
 */
public class ReverseListFromNtoM {

    static class Node {
        Node next = null;
        int val;
        public Node(int val) {
            this.val = val;
        }
    }


    /***
     * 1 -> 2 -> 3 -> 4 -> 5 -> NULL
     *
     * 1 -> 3 -> 2 -> 4 -> 5 -> NULL
     *
     * 1 -> 4 -> 3 -> 2 -> 5 -> NULL
     *
     * 依次交换一个
     *
     * 第一步是将结点3放到结点1的后面，第二步将结点4放到结点1的后面。
     * 刚开始，pre指向结点1，cur指向结点2，然后我们建立一个临时的结点t，指向结点3（注意我们用临时变量保存某个结点就是为了首先断开该结点和前面结点之间的联系，这可以当作一个规律记下来），
     * 然后我们断开结点2和结点3，将结点2的next连到结点4上，也就是 cur->next = t->next，
     * 再把结点3连到结点1的后面结点（即结点2）的前面，即 t->next = pre->next，
     * 最后再将原来的结点1和结点2的连接断开，将结点1连到结点3，即 pre->next = t。
     * 这样我们就完成了将结点3取出，加入结点1的后方。
     */

    public static Node reverseList(Node head, int n, int m) {

        //空链表 单节点 直接返回
        if(head == null || head.next == null) {
            return head;
        }
        if(n > m || n < 0 || m < 0) {
            return null;
        }

        //创建虚拟头结点 --新链表
        Node reverseHead = new Node(-1);
        reverseHead.next = head;
        //找到待反转的位置 [前一个节点与n位置点]
        Node cur = reverseHead;
        for(int i=1; i<n; i++) {
            cur = cur.next;
        }
        Node prev = cur; //n-1位置
        cur = prev.next;// n位置
        Node next = null;
        //头插法
        for(int i=n; i<m; i++) {
            next = cur.next; //保存下一个节点
            cur.next = next.next; //断开2->3
            next.next = prev.next; //改变指向
            prev.next = next; //断开1->2
        }
        return reverseHead.next;
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
        Node node = reverseList(a, 1, 4);
        while(node != null) {
            System.out.print(node.val+" ");
            node = node.next;
        }
    }




}

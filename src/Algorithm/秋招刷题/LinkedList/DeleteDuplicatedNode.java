package Algorithm.LinkedList;

/**
 * 删除链表中重复的节点
 *  需要保证链表有序
 */
public class DeleteDuplicatedNode {

    static class Node {
        Node next = null;
        int val;
        public Node(int val) {
            this.val = val;
        }
    }
    
    public static Node deleteDuplicatedNode(Node head) {
        
        //空链表和单个链表元素处理
        if(head == null) {
            return null;
        }
        if(head.next == null) {
            return head;
        }
        
        //链表长度>2 需要设置虚拟节点 防止链表头需要删除
        Node dummyHead = new Node(-1);
        dummyHead.next = head;
        //prev指针指向 当前确定不重复的那个节点
        Node prev = dummyHead;
        //当前处理的节点
        Node cur = head;
        while(cur != null && cur.next != null) {
            //找到第一个相同节点
            if(cur.val == cur.next.val) {
                //找到最后的一个相同节点
                while(cur.next!= null && cur.next.val == cur.val) {
                    cur = cur.next;
                }
                //删除重复元素
                prev.next = cur.next;
                //移动cur指针
                cur = cur.next;
            } else {
                // 相邻两个值不同，说明node不可删除，要保留 移动prev next
                prev = prev.next;
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        Node a = new Node(2);
        Node b = new Node(2);
        Node c = new Node(4);
        Node d = new Node(4);
        Node f = new Node(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = f;
        f.next = null;
        //f.next= b;
        Node node = deleteDuplicatedNode(a);
        while(node != null) {
            System.out.print(node.val+" ");
            node = node.next;
        }
    }

    
}

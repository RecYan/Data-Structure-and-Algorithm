package Algorithm.LinkedList;

/**
 * Created by Yan_Jiang on 2019/5/20.
 * O(1)时间内删除链表中的节点
 */
public class DeleteNode {

    static class Node {
        Node next = null;
        int val;
        public Node(int val) {
            this.val = val;
        }
    }

    public static void deleteNode(Node head, Node deleteNode){

        if(head == null || deleteNode == null){
            return;
        }

        //节点在链表中且不是尾节点 -->O(1)[后置节点]
        if(deleteNode.next != null) {
            //复制待删除节点后一个节点的值，改变待删除节点的next指向
            //相当于用待删除节点的下一个节点替换掉待删除节点
            deleteNode.val = deleteNode.next.val; //当前节点保存下一个节点的值
            deleteNode.next = deleteNode.next.next; //修改当前节点指针指向
        }
        else if (head == deleteNode) {
            //链表只有一个节点
            return;
        } else {
            //遍历删除尾节点--> O(n) --> 找到deleteNode的前一个节点
            Node node = head;
            while(node.next != deleteNode){
                node = node.next;
            }
            node.next = null; //删除尾节点
        }
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        a.next = b;
        b.next = c;

        deleteNode(a, c);
        Node node = a;
        while(node != null) {
            System.out.print(node.val+" ");
            node = node.next;
        }
    }
}

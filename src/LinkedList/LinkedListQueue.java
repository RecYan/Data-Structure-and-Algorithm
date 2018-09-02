package LinkedList;

/**
 * Created by Yan_Jiang on 2018/9/1.
 * 基于尾指针链表 实现队列结构
 */
public class LinkedListQueue<E> implements Queue<E> {

    //节点以内部类形式存在
    private class Node {

        public E e; //节点中储存的数据
        public Node next; //指向下一个节点

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    //链表属性
    private Node head;
    private Node tail; //尾指针

    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpity() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        //链表为空时  初始为空时 head和tail指向相同 即从null变成新插入的节点
        if(tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e); //链表非空
            tail = tail.next;
        }
        size ++;

    }

    @Override
    public E dequeue() {
        if(isEmpity()) {
            throw new IllegalArgumentException("empty queue.....")
        }

        Node dequeueNode = head; //需要出队的节点
        head = head.next;
        dequeueNode.next = null //手动回收内存
        // 考虑空链表情况 即head tail 指向null
        if(head == null) {
            tail = null
        }
        size --;

        return dequeueNode.e;
    }

    @Override
    public E getFront() {
        if(isEmpity()) {
            throw new IllegalArgumentException("empty queue.....")
        }

        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("LinkedListQueue: Front");

        Node cur = head; //遍历链表
        while(cur != null) {
            res.append(cur+"->");
            cur = cur.next;
        }
        res.append("NULL Tail")

        return res.toString();
    }
}

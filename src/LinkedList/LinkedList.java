package LinkedList;

/**
 * Created by Yan_Jiang on 2018/8/23.
 * 链表底层实现
 */
public class LinkedList<E> {

    //节点以内部类形式存在
    private class Node {

        public E e; //节点中储存的数据
        public Node next; //指向下一个节点

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
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
    //-------------------------------- NOde ------------
    private Node head; //头节点 并指向下一个节点
    private int size; //链表中节点的个数

    public LinkedList() {
        head = null;
        size = 0;
    }

    //获取链表中的节点个数
    public int getSize() {
        return size;
    }

    //判断链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //向链表头添加新的节点e
    public void addFirst(E e) {
//        Node node = new Node(e); //待添加的节点
//        node.next = head; //将node的next指向head
//        node = head; //更新head
        head = new Node(e, head); //等价于上面的代码

        size ++;
    }

    //向链表的index位置添加新的元素e




}

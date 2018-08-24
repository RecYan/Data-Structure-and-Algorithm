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
    private Node dummyHead; //虚拟头节点 指向下一个真正的节点
    private int size; //链表中节点的个数

    public LinkedList() {
        dummyHead = new Node(null, null);
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

    //向链表的index位置添加新的元素e
    public void add(int index, E e) {
        if(index < 0 || index > size) {//可以取到size即在链表末尾添加元素
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        //在head处新创建一个prev引用
        Node prev = dummyHead; //*** dummyHead：索引为0这个节点的前一个节点
        //遍历链表，找到index-1处的索引
        for(int i=0; i<index; i++) {
            prev = prev.next; //将prev依次向前移动到index-1处
        }
        /*//待插入的node
        Node newNode = new Node(e);
        //改变引用  ---> 顺序不可改变
        newNode.next = prev.next;
        prev.next = newNode;*/
        //同理 上面三行代码等价于下行代码
        prev.next = new Node(e, prev.next);

        size ++;
    }

    //向链表头添加新的节点e
    public void addFirst(E e) {
        add(0, e);

        size ++;
    }

    //向链表末尾处添加新的元素e
    public void addLast(E e) {
        add(size, e);
    }





}

package LinkedList;

/**
 * Created by Yan_Jiang on 2018/8/23.
 * 链表底层实现
 * prev 指向dummyHead节点
 * cur 指向dummyHead.next节点
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
        //在head处新创建一个prev引用 -- 寻找index-1处元素
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

    //获取链表第index处的元素 --（0-baesd）
    public E get(int index) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("get failed. Illegal index.");
        }

        Node cur = dummyHead.next; //从第0处索引开始遍历 注意与add遍历的区别
        for(int i=0; i<index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    //获取链表中第一个位置的元素
    public E getFirst() {
        return get(0);
    }

    //获取链表中最后一个位置上的元素
    public E getLast() {
        return get(size - 1);
    }

    //修改链表中inedx处的元素为e
    public void set(int index, E e) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("set failed. Illegal index.");
        }

        Node cur = dummyHead.next;
        for(int i=0; i<index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    //查找链表中是否有元素e
    public boolean contains(E e) {

        Node cur = dummyHead.next; //从虚拟头结点向后遍历
        //遍历链表中所有的节点
        while (cur != null) {
            if ((cur.e).equals(e)) {
                return true;
            }
            //没有则继续向后找
            cur = cur.next;
        }
        return false; //遍历所有之后 仍然没有则判空
    }

    //删除index处的元素 并返回被删除的元素
    public E remove(int index) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("remove failed. Illegal index.");
        }

        //找到被删除元素之前的一个索引位置
        Node prev = dummyHead;
        for(int i=0; i<index; i++) {
            prev = prev.next;
        }
        Node delNode = prev.next; //保存需要被删除的元素
        prev.next = delNode.next; //删除逻辑
        delNode.next = null; //手动回收内存
        size --;

        return delNode.e;
    }

    //删除链表中第一个元素 并返回
    public E removeFirst() {
        return remove(0);
    }

    //删除链表中最后一个元素 并返回
    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;

        while(cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("null");

        return res.toString();
    }
}

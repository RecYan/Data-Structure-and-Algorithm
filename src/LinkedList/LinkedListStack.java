package LinkedList;

/**
 * Created by Yan_Jiang on 2018/9/1.
 * 使用链表底层实现栈结构
 */
public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> list;

    public LinkedListStack() {
        list = new LinkedList<E>();
    }


    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpity() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addFirst(e); //链表头压栈
    }

    @Override
    public E pop() {
        return list.removeFirst(); //链表头出栈
    }

    @Override
    public E peek() {
        return list.getFirst(); //查看栈顶的元素
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("LinkedListStack: top");
        res.append(list);
        return res.toString();
    }
}

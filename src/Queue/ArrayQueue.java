package Queue;

/**
 * Created by Yan_Jiang on 2018/8/20.
 * 基于动态数组实现自己的队列
 */
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    //带初始容量构造
    public ArrayQueue(int capacity) {
        array = new Array<E>(capacity);
    }

    //无参构造
    public ArrayQueue() {
        array = new Array<E>();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpity() {
        return array.isEmpity();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirstElement();
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append("Queue front:[ ");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.getElement(i));
            if (i != array.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] tail");

        return res.toString();
    }
}

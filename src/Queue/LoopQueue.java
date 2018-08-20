package Queue;

/**
 * Created by Yan_Jiang on 2018/8/20.
 * 循环队列实现
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;

    private int front; //对首

    private int tail; //对尾，指向最后一个元素的下一个位置

    private int size; // 队列中元素数量

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1]; //capacity + 1 保证了 tail+1 = front 标志队列已满
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1; //tail+1 = front 标志队列已满 --> 留有一个空格方便看
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpity() {
        return tail == front;
    }

    @Override
    public void enqueue(E e) {
        //如果队列已满 则扩容2倍
        if((tail+1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        //入队
        data[tail] = e;
        tail = (tail+1) % data.length;
        size ++;
    }

    @Override
    public E dequeue() {

        if(isEmpity()) {
            throw new IllegalArgumentException("empity queue!!!");
        }

        E removeElement = data[front];
        data[front] = null; //手动优化

        front = (front+1) % data.length;
        size --;
        //动态缩容 getCapacity()/2 != 0 保证缩容后的容量不为零
        if(size == getCapacity()/4 && getCapacity()/2 != 0) {
            resize(getCapacity() / 2); //缩一半
        }

        return removeElement;
    }

    @Override
    public E getFront() {

        if(isEmpity()) {
            throw new IllegalArgumentException("empity queue!!!");
        }
        return data[front];
    }

    //扩容
    private void resize(int newCapacity) {

        E[] newData = (E[]) new Object[newCapacity + 1]; //原因同上

        //**循环方式1 遍历原数组，将元素添加到新数组中
        for(int i=0; i<size; i++) {
            newData[i] = data[(i+front) % data.length]; //取余保证循环，且不会发生越界，i+front:解决偏移
        }
        data = newData; //改变指向
        front = 0;
        tail = size;
    }

    //**循环方式2  i = (i+1)%data.length:循环加1
    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("LoopQueue: size = %d, capacity = %d\n", size, getCapacity()));
        res.append("LoopQueue front:[ ");
        for (int i = front; i != tail; i = (i+1)%data.length) {
            res.append(data[i]);
            if ((i+1)%data.length != tail) {
                res.append(", ");
            }
        }
        res.append("] tail");

        return res.toString();
    }

}

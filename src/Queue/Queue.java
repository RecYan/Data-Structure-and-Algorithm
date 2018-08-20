package Queue;

/**
 * Created by Yan_Jiang on 2018/8/20.
 * 队列接口实现
 */
public interface Queue<E> {

    /**
     * 获取队列大小
     * @return 队列大小
     */
    int getSize();

    /**
     * 判断队列是否为空
     * @return ture为空 false为非空
     */
    boolean isEmpity();

    /**
     * 向队列中添加元素
     * @param e 添加的元素
     */
    void enqueue(E e);

    /**
     * 取出队列中的元素
     * @return 取出的元素
     */
    E dequeue();

    /**
     * 取出队首的元素
     * @return 队首的元素
     */
    E getFront();


}

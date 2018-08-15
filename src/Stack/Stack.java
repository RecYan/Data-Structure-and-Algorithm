package Stack;

/**
 * Created by Yan_Jiang on 2018/8/15.
 * 栈方法定义
 */
public interface Stack<E> {

    /**
     * 获取栈的大小
     * @return 返回栈的大小
     */
    int getSize();

    /**
     * 判断数组是否为空
     * @return true:空， false: 不为空
     */
    boolean isEmpity();

    /**
     * 向栈中添加元素
     * @param e 添加的元素
     */
    void push(E e);

    /**
     * 取出栈顶元素
     * @return 取出的元素
     */
    E pop();

    /**
     * 查看栈顶的元素
     * @return 栈顶的元素
     */
    E peek();

}

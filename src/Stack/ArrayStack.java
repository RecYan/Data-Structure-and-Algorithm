package Stack;

/**
 * Created by Yan_Jiang on 2018/8/15.
 * 动态栈的具体实现
 */
public class ArrayStack<E> implements Stack<E> {

    Stack.Array<E> array; //引入自己的动态数组

    // 栈容量初始化
    public ArrayStack(int capacity) {
        array = new Stack.Array<>(capacity);
    }

    public ArrayStack() {
        array = new Stack.Array<>();
    }

    //查看栈的容量
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
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLastElement();
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append("Stack.Stack: [");
        for(int i=0; i<array.getSize(); i++) {
            res.append(array.getElement(i));
            if(i != array.getSize()-1) {
                res.append(", ");
            }
        }
        res.append("] top");// 提示栈顶位置

        return res.toString();

    }
}

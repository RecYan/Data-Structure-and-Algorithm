package Queue;

/**
 * 自定义数组设计
 * Created by Yan_Jiang on 2018/8/7.
 */
public class Array<E> {

    private E[] data;
    private int size; //数组实际使用的容量 且指向下一个空位置

    /**
     * 根据用户传入的容量 创建数组
     * @param capacity 数组的容量
     */
    public Array(int capacity) {

        data = (E[]) new Object[capacity]; //不能直接 new E[capacity]
        size = 0;
    }

    /**
     * 无参构造函数 初始容量为10
     */
    public Array() {
        this(10);
    }

    /**
     * 获取数组实际使用容量
     * @return 数组使用容量
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组创建时容量
     * @return 数组创建时容量
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     *判断数组是否为空
     * @return ture:数组为空  false:数组不为空
     */
    public boolean isEmpity() {
        return size == 0;
    }

    /**
     * 在index处插入元素
     * @param index 指定索引
     * @param element 需要插入的元素
     */
    public void add(int index, E element) {

        if(index<0 || index>size) {
            throw new IllegalArgumentException("Require index>=0 and index<szie");
        }

        //容量不够时 扩容两倍
        if(size == data.length){
            resize(2 * data.length);
        }
        //从最后开始遍历到index处，并整体向后移动一个单位
        for(int i=size-1; i>=index; i--) {
            data[i+1] = data[i];
        }
        data[index] = element;
        size ++;
    }

    /**
     * 向数组末尾添加元素
     * @param element 添加的元素
     */
    public void addLast(E element){
        add(size, element);
    }

    /**
     * 向数组开头添加元素
     * @param element 添加的元素
     */
    public void addFirst(E element){
        add(0, element);
    }

    /**
     * 获取指定index的元素
     * @param index 角标
     * @return 指定index的元素
     */
    public E getElement(int index) {

        if(index<0 || index>size) {
            throw new IllegalArgumentException("Require index>=0 and index<szie");
        }
        return data[index];
    }

    /**
     * 获取数组最后一个元素
     * @return 数组最后一个元素
     */
    public E getFirstElement() {
        return getElement(size - 1);
    }

    /**
     * 获取数组第一个元素
     * @return 数组第一个元素
     */
    public E getLastElement() {
        return getElement(0);
    }



    /**
     * 替换指定角标位置的元素
     * @param index 角标
     * @param element 替换的元素
     */
    public void setElement(int index, E element) {

        if(index<0 || index>size) {
            throw new IllegalArgumentException("Require index>=0 and index<szie");
        }
        data[index] = element;
    }

    /**
     * 查看数组是否包含指定元素
     * @param element 需要判断的元素
     * @return ture:包含 flase:不包含
     */
    public boolean containElement(E element) {

        for(int i=0; i<size; i++) {
            // 这里是两个类对象的比较
            if(data[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取指定元素的角标
     * @param element 指定元素
     * @return 存在该元素则返回对应的角标，不存在则返回-1
     */
    public int getElementIndex(E element) {

        for(int i=0; i<size; i++) {
            if(data[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除指定角标的元素并返回被删除的元素
     * @param index 需要删除元素的角标
     * @return 返回被删除的元素
     */
    public E removeElementByIndex(int index) {

        if(index<0 || index>size) {
            throw new IllegalArgumentException("Require index>=0 and index<szie");
        }

        E removedElement = data[index];
        for(int i=index+1; i<size; i++) {
            data[i-1] = data[i];
        }
        size --;
        data[size] = null; //手动释放内存
        //动态缩容 -- Lazy机制 减少复杂度震荡
        if(size == data.length / 4 && data.length/2 != 0) {
            resize(data.length / 2);
        }
        return removedElement;
    }

    /**
     * 删除第一个元素并返回被删除的元素
     * @return 返回被删除的元素
     */
    public E removeFirst() {
        return  removeElementByIndex(0);
    }

    /**
     * 删除最后一个元素并返回被删除的元素
     * @return 返回被删除的元素
     */
    public E removeLast() {
        return  removeElementByIndex(size-1);
    }

    /**
     * 删除指定的元素
     * @param element 需要删除的元素
     */
    public void removeElement(E element) {
        int index = getElementIndex(element);
        if(index != -1) {
            removeElementByIndex(index);
        }
        System.out.println("this element is not exit");
    }

    /**
     * 数组动态扩容
     * @param newCapacity 扩容的容量
     */
    private void resize(int newCapacity) {

        E[] newData = (E[]) new Object[newCapacity];
        for(int i=0; i<size; i++) {
            newData[i] = data[i];
        }
        data = newData; //改变指向
    }


    @Override
    public String toString() {

        StringBuffer sb = new StringBuffer();
        sb.append(String.format("Stack.Stack.Array: size = %d, capacity = %d\n", size, data.length));
        sb.append("[");

        for(int i=0; i<size; i++) {
            sb.append(data[i]);
            //拼接逗号
            if(i != size-1) {
                sb.append(", ");
            }
        }
        sb.append("]");

        return sb.toString();
    }
}

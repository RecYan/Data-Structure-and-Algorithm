package BST;

/**
 * Created by Yan_Jiang on 2018/9/12.
 * 二分搜索树
 *   其中存放的元素必须具备 可比性--> E extends Comparable<E>
 */
public class BST<E extends Comparable<E>> {

    //树节点
    private class Node {

        public E e;

        public Node right;
        public Node left;

        public Node(E e) {
            this.e = e;
            right = null;
            left = null;
        }
    }
    //------------------------------------  二分搜索树 成员变量和方法 ----------------------------
    private Node root; //根节点
    private int size;

    //初始构造函数
    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpity() {
        return size == 0;
    }

    //向二分搜索树中插入元素
    public void add(E e) {

        /*if(root == null) {
            root = new Node(e);
            size ++;

        } else {
            add(root ,e);
        }*/
        root = add(root, e);
    }

    //递归向以node为根的树中添加元素 并返回插入新节点后的根节点
    private Node add(Node node, E e) {

        //代码改进
       /* if(e.equals(node.e)) {
            return; //遇到重复元素直接返回
        } else if(e.compareTo(node.e) < 0 && node.left == null) { //左子树符合条件 且左子树节点的左孩子为空  -- 直接插入即可
            node.left = new Node(e);
            size ++;
            return;
        } else if(e.compareTo(node.e) > 0 && node.right == null) {
            node.right = new Node(e);
            size ++;
            return;
        }*/

        if(node == null) {
            size ++;
            return new Node(e);
        }

        //重复元素问题已被过滤 且孩子节点为空情况也被解决 -- 可以递归调用
        if(e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if(e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }

        return node;
    }

    //查看二分搜索树中是否包含元素e
    public boolean contains(E e) {

        return contains(root, e);
    }

    //递归实现 查看以node为根节点的书中 是否包含元素e
    private boolean contains(Node node, E e) {

        //树为空
        if(node == null) {
            return false;
        }

        if(e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else if(e.compareTo(node.e) > 0) {
            return contains(node.right, e);
        } else { //e.compareTo(node.e) == 0
            return true;
        }

    }


}

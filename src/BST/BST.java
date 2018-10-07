package BST;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

    //前序遍历
    public void preOrder() {

        preOrder(root);
    }
    //以node为根节点的前序递归遍历
    private void preOrder(Node node) {

        //1. 递归终止条件
        if(node == null) {
            return;
        }

        //2. 递归具体逻辑
        System.out.println(node.e); //节点
        preOrder(node.left);
        preOrder(node.right);

    }

    //*********** 非递归实现BST的前序遍历 *******************
    public void preOrderNR() {

        Stack<Node> stack = new Stack<Node>(); //使用栈来保存要访问的元素
        stack.push(root);

        while(!stack.isEmpty()) {

            Node cur = stack.pop(); //当前访问节点
            System.out.println(cur.e);

            if(cur.right != null) { //栈先进后出 所以前序先压入右子树  ---- 判断当前节点的孩子节点
                stack.push(cur.right);
            }
            if(cur.left != null) {
                stack.push(cur.left);
            }
        }

    }

    //中序遍历
    public void inOrder() {
        inOrder(root);
    }
    //以Node为根节点 中序遍历
    private void inOrder(Node node) {

        if(node == null) {
            return;
        }

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    //中序遍历
    public void postOrder() {
        postOrder(root);
    }
    //以Node为根节点 中序遍历
    private void postOrder(Node node) {

        if(node == null) {
            return;
        }

        inOrder(node.left);
        inOrder(node.right);
        System.out.println(node.e);

    }


    //**************************** 层序遍历 *****************
    public void leverOrder() {

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        while(queue != null) {

            Node cur = queue.remove(); //当前访问节点
            System.out.println(cur.e);

            if(cur.left != null) {
                queue.add(cur.left);
            }
            if(cur.right != null) {
                queue.add(cur.right);
            }

        }

    }

    //寻找BST中最小的元素
    public E minimun() {

        if(size == 0) {
            throw new IllegalArgumentException("BST is Empty...");
        }

        return minimun(root).e;
    }

    //递归寻找 以node为根的BST中最小的元素所在的节点 并返回
    private Node minimun(Node node) {

        if(node.left == null) {
           return node;
        }

        return minimun(node.left);
    }

    //寻找BST中最大的元素
    public E maximun() {

        if(size == 0) {
            throw new IllegalArgumentException("BST is Empty...");
        }

        return maximun(root).e;
    }

    //递归寻找 以node为根的BST中最大的元素所在的节点 并返回
    private Node maximun(Node node) {

        if(node.right == null) {
            return node;
        }

        return maximun(node.right);
    }

     //删除BST中最小的元素 并返回相应的元素
     public E removeMin() {

         E retsult = minimun(); //找到待删除的元素并保存
         root = removeMin(root);
         return retsult;

     }

     //递归删除 以node为节点的BST中最小值所在的节点
     // 并返回删除节点后的新的根节点
     private Node removeMin(Node node) {

         if(node.left == null) {

             Node rightNode = node.right; //保存待删节点的右子树
             node.right = null; //node节点删除
             size --;
             return rightNode; //删除node节点后的新根节点
         }

         //节点仍有左子树
         node.left = removeMin(node.left); // 若节点存在右子树时 将终止条件里保存的右子树 重新作为删除后节点的根
         return node;
     }


     // 从二分搜索树中删除最大值所在节点
     public E removeMax(){
        E ret = maximun();
        root = removeMax(root);
        return ret;
     }

     // 删除掉以node为根的二分搜索树中的最大节点
     // 返回删除节点后新的二分搜索树的根
     private Node removeMax(Node node){

        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
     }

     //删除BST中任意的元素
     public void remove(E e) {
         root = remove(root, e);
     }
    // 删除掉以node为根的二分搜索树中的最大节点
    // 返回删除节点后新的二分搜索树的根
    private Node remove(Node node, E e) {

        if(node == null) {
            return null;
        }

        if(e.compareTo(node.e) > 0) { //e比当前节点的值大
            node.right = remove(node.right, e);
            return node;
        } else if(e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else { //e与当前节点相等
            if(node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            } else if(node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }  else { //node的左右子树都存在
                // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
                // 用这个节点顶替待删除节点的位置
                Node successor = minimun(node.right);
                successor.right = removeMin(node.right);
                successor.left = node.left;

                node.left = node.right = null; //node节点脱离树

                return successor;
            }
        }

    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    // 生成以node为根节点，深度为depth的二叉树的字符串
    private void generateBSTString(Node node, int depth, StringBuilder res) {

        if(node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < depth ; i ++) {

            res.append("--");
        }
        return res.toString();
    }



}

package Algorithm.Tree;

/**
 * Created by Yan_Jiang on 2019/5/25.
 *  给定一个节点 找出中序遍历的下一个节点
 *   该节点有右子树，下一个节点为右子树的左孩子
 *   该节点无右子树，则向上寻找节点[该节点为其父节点的左孩子，则该父节点为下一个节点]
 */
public class GetNext {

    static class Node{
        int val = 0;
        Node left = null;
        Node right = null;
        Node parent = null;

        public Node(int val){
            this.val = val;
        }
    }

    public static Node getNext(Node node) {

        if(node == null) {
            return null;
        }
        Node next = null;
        //节点存在右子树 -- 找右子树的左孩子
        if(node.right != null) {
            Node right = node.right; //右子树根节点
            while(right.left != null) {
                right = right.left;
            }
            next = right;
        } /*else if(node.parent != null) {
            Node cur = node;
            Node parent = node.parent;
            //该节点无右子树，则向上寻找节点[该节点为其父节点的左孩子，则该父节点为下一个节点]
            while(parent != null && cur == parent.right) {
                //向上寻找
                cur = parent;
                parent = parent.parent;
            }
            next = parent;
        }*/
        while(node.parent != null) {
            Node parent = node.parent;
            if(parent.left == node) {
                next = parent;
            }
            node = node.parent;//向上寻找
        }
        return next;
    }



    public static void main(String[] args) {
        Node root = new Node(5);
        Node a = new Node(3);
        Node b = new Node(6);
        Node c = new Node(2);
        Node d = new Node(4);
        Node e = new Node(8);

        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.right = e;

        a.parent = root;
        b.parent = root;
        c.parent = a;
        d.parent = a;
        e.parent = b;

        System.out.println(getNext(root).val);


    }

}

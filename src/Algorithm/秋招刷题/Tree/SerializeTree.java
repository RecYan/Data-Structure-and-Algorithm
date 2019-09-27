package Algorithm.Tree;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Yan_Jiang on 2019/5/29.
 *  根据前序遍历的顺序来序列化二叉树，因为前序遍历是从根结点开始的
 */
public class SerializeTree {

    static class Node{
        int val = 0;
        Node left = null;
        Node right = null;

        public Node(int val){
            this.val = val;
        }
    }

    private static int index = -1;

    public static String Serialize(Node root) {

        StringBuffer sb = new StringBuffer();
        //前序序列化
        if(root == null) {
            sb.append("$ ");
            return sb.toString();
        }
        sb.append(root.val+" ");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }

    public static Node Deserialize(String str) {

        index++ ;
        int len = str.length();
        if(index >= len) {
            return null;
        }
        String[] strs = str.split(" ");
        //System.out.println(strs.length);
        Node node = null;
        if(!strs[index].equals("$")) {
            node = new Node(Integer.valueOf(strs[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
    }

    public static void printByLine(Node root) {

        if(root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int nextLevel = 0; //下一层节点数
        int curLevel = 1; //当前层节点数

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            curLevel --;
            System.out.print(node.val + " ");
            if(node.left != null) {
                queue.add(node.left);
                nextLevel ++;
            }
            if(node.right != null) {
                queue.add(node.right);
                nextLevel ++;
            }
            //换行打印
            if(curLevel == 0) {
                System.out.println();
                curLevel = nextLevel;
                nextLevel = 0;
            }
        }
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

        String str = Serialize(root);
        System.out.println(str);
        Node node = Deserialize(str);
        printByLine(node);


    }
}

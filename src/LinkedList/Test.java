package LinkedList;

/**
 * Created by Yan_Jiang on 2018/9/1.
 * 测试类
 */
public class Test {

    public static void main(String[] args) {

       LinkedList<Integer> linkedList = new LinkedList<Integer>();
        for(int i = 0 ; i < 5 ; i ++){
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(2, 666);
        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);

        System.out.println(linkedList.contains(666));
    }
}

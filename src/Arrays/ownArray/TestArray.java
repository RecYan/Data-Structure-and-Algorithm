package Arrays.ownArray;

/**
 * Created by Yan_Jiang on 2018/8/8.
 */
public class TestArray {

    public static void main(String[] args) {

        Array<Integer> arr = new Array<Integer>(10);

        for(int i = 0 ; i < 10 ; i ++) {
            arr.addLast(i);
        }
        System.out.println(arr);

        arr.add(1, 100);
        System.out.println(arr);
        arr.addFirst(-1);
        System.out.println(arr);

        arr.removeElementByIndex(2);
        System.out.println(arr);

        arr.removeElement(4);
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);

    }

}

package Arrays.basicArray;

/**
 * Created by Yan_Jiang on 2018/8/7.
 */
public class Basic_Array {

    public static  void main(String[] args){

        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        int[] scores = {100, 99, 98};
        for (int score : scores) {
            System.out.println(score);
        }

        scores[0] = 97;
        for (int score : scores) {
            System.out.println(score);
        }
    }
}

package Stack;



/**
 * Created by Yan_Jiang on 2018/8/15.
 * 测试
 */
public class TestArrayStack {

    public static void main(String[] args) {

       ArrayStack<Integer> stack = new ArrayStack<Integer>();

        for(int i=0; i<5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}

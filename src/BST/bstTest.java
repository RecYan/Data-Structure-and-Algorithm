package BST;

/**
 * Created by Yan_Jiang on 2018/9/13.
 */
public class bstTest {

    public static void main(String[] args) {

        BST<Integer> bst = new BST<Integer>();
        int[] nums = {5, 3, 6, 8, 4, 2};

        for(int num : nums) {
            bst.add(num);
        }

        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////

        bst.preOrder();
        System.out.println(bst);

        bst.inOrder();
        System.out.println(bst);

        bst.postOrder();
        System.out.println(bst);

        bst.preOrderNR();

        System.out.println("++++++++++++++++++++++++++++++++");
        bst.leverOrder();


    }
}

package Algorithm.Array;

import java.util.ArrayList;

/**
 * 顺时针打印举证
 *  1 2 3
 *  4 5 6   ==> 1 2 3 6 9 8 7 4 5
 *  7 8 9
 *   采用旋转魔方的方式 一次取一行，然后 逆时针旋转
 *   例如
     *   1 2 3
     *   4 5 6
     *   7 8 9
     *  输出并删除第一行后，变为
     *  4 5 6
     *  7 8 9
     *  再进行一次逆时针旋转，就变成：
     *  6 9
     *  5 8
     *  4 7
     * 继续重复上述操作即可。
 */
public class PrintMatrix {

    public static ArrayList<Integer> printMatrix(int[][] matrix) {

        ArrayList<Integer> result = new ArrayList<>();
        int row = matrix.length;
        while (row != 0) {
            //matrix 第一行元素 存入result
            for (int i = 0; i < matrix[0].length; i++) {
                result.add(matrix[0][i]);
            }
            //只剩一行时候 停止
            if (row == 1) {
                break;
            }
            //删除第一行元素 并逆时针旋转
            matrix = revert(matrix);
            //更新row
            row = matrix.length;
        }
        return result;
    }

    private static int[][] revert(int[][] matrix) {

        int row = matrix.length; //行数
        int col = matrix[0].length; //列数

        //初始化新数组  删除第一行且逆时针旋转
        int[][] newMatrix = new int[col][row - 1];

        //对这个新数组进行赋值 3*3
        for (int j = col - 1; j >= 0; j--) {
            for (int i = 1; i < row; i++) {
                newMatrix[col - 1 - j][i - 1] = matrix[i][j];
            }
        }
        return newMatrix;
    }

    public static void main(String[] args) {
        int[][] num = {{1, 2, 3},{4, 5, 6},{7, 8, 9}};
        ArrayList<Integer> result = printMatrix(num);
        System.out.println(result);
    }

}

package Algorithm.Array;

/**矩阵 顺时针旋转90
 *   矩阵转换90度，则原矩阵的纵下标转变为新矩阵的横下标；
 *   原矩阵的横下标转变为新矩阵的纵下标，
 */
public class Rotation {

    public static int[][] rotation(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;
        int[][] temp = new int[col][row];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                temp[j][row - 1 - i] = matrix[i][j];
            }
        }
        return temp;
    }

    //旋转90度
    public static int[][] rotate(int[][] matrix) {
        int len = matrix.length;
        int[][] temp = new int[len][len];
        //（n-行号）变为列号
        //列号变为行号
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                temp[j][len - 1 - i] = matrix[i][j];
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        int[][] num = {{1, 2, 3},{4, 5, 6}, {7, 8, 9}};
        //int[][] result = rotate(num);
        int[][] result = rotation(num);
        for(int i=0; i<result.length; i++) {
            for(int j=0; j<result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
        }
    }

}

package Algorithm.other;

/**
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句
 */
public class Sum {

    /**
     * 利用利用短路 && 来实现if的功能
     * 利用递归来实现循环while的功能
     * 1.需利用逻辑与的[短路特性]实现递归终止。
     * 2.当n==0时，(n>0)&&((sum+=sum(n-1))>0)只执行前面的判断，为false，然后直接返回0；
     * 3.当n>0时，执行sum+=sum(n-1)，实现递归计算sum(n)。
     */
    //短路求值
    public static int sum(int n) {
        int sum = n;
        boolean flag = (sum > 0) && ((sum += sum(n-1)) > 0);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sum(3));
    }
}

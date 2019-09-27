package Algorithm.Array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *      例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 *  * 解题思路：
 *  * 先将整型数组转换成String数组，然后将String数组排序，最后将排好序的字符串数组拼接出来。
 *  * 若ab > ba 则 a > b，
 *  * 若ab < ba 则 a < b，
 *  * 若ab = ba 则 a = b；
 *  * 解释说明：
 *  * 比如 "3" < "31"但是 "331" > "313"，所以要将二者拼接起来进行比较
 */

public class PrintMinNumber {


    public static String printMinNumber(int[] num) {
        if(num == null || num.length == 0) {
            return null;
        }

        String[] str = new String[num.length];
        StringBuilder sb = new StringBuilder();

        //将int[] ==> String[]
        for(int i=0; i<num.length; i++) {
            str[i] = num[i] + "";
        }
        //拼接排序比较
        // s1.compareTo(s2) 升序 看博客
        // s2.compareTo(s1) 降序
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                String s1 = str1 + str2;
                String s2 = str2 + str1;
                return s1.compareTo(s2);
            }
        });

        //输出
        for(int i=0; i<str.length; i++) {
            sb.append(str[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        int[] num = {3, 32, 321};
        System.out.println(printMinNumber(num));
    }

}

package Algorithm.Str;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 *  例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 * * *对于无重复值的情况 abc
 *      * 固定第一个字符，递归取得首位后面的各种字符串组合；
 *      * 再把第一个字符与后面每一个字符交换，并同样递归获得首位后面的字符串组合；
 *      *递归的出口，就是只剩一个字符的时候，
 *      *递归的循环过程，就是从每个子串的第二个字符开始依次与第一个字符交换，然后继续处理子串。
 * * * 假如有重复值呢 abb
 *      * 对abb，第一个数a与第二个数b交换得到bab，然后考虑第一个数与第三个数交换bba，此时由于第三个数等于第二个数，
 *      * 所以第一个数就不再用与第三个数交换了。再考虑bab，它的第二个数与第三个数交换可以解决bba。此时全排列生成完毕！
 *
 *   ==> 从第一个数字起，每个数分别与它后面非重复出现的数字交换
 */

public class Permutation {

    /**
     * 以abc 为例：
     * (1)a    b    c        a和自己进行交换,此时固定a,然后求后面b和c的排列
     * (2)a    b    c        b和自己进行交换， 此时固定b，求c的排列
     * (3)a    b    c        c和自己进行交换，固定c，但后面已没有排列，输出并回溯
     * (4)a    c    b        返回(2)[回溯]b和c进行交换，固定c求后面b的排列，和(3)类似，输出
     * (5)b    a    c        返回(1)a和b进行交换，固定b求后面的排列
     * 后面的基本操作都类似，最后输出abc    acb    bac    bca    cab    cba
     */

    public static ArrayList<String> Permutation(String str) {

        ArrayList<String> list = new ArrayList<>();
        if(str != null && str.length() >0) {
            PermutationHelper(str.toCharArray(), 0, list);
            Collections.sort(list); //字典序
            return list;
        }
        return null;

    }

    private static void PermutationHelper(char[] chars, int pos, ArrayList<String> list) {
        //递归的终止条件：pos已经移到char数组的末尾的时候，添加这一组字符串进入结果集中
        if (pos == chars.length - 1) {
            if (!list.contains(String.valueOf(chars))) {
                list.add(String.valueOf(chars));
            }
        } else {
            for (int i = pos; i < chars.length; i++) {
                //从当前元素开始，对每个元素，分别与它后面不相同的数交换
                //交换第一个字符与其它每个字符的位置
                swap(chars, pos, i);
                PermutationHelper(chars, pos + 1, list); //后面元素全排列
                //回溯
                swap(chars, pos, i);
                /**回溯
                 *  [1 2] 3 4 5
                 *     p处理2元素
                 *  第一次  [2 1] 3 4 5  全排列
                 *
                 *  处理完毕swap 1 2 3 4 5
                 *                  p处理3元素
                 */
            }
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(Permutation("abc"));
    }



    //1.第一次进到这里是ch=['a','b','c'],list=[],i=0，我称为 状态A ，即初始状态
    //那么j=0，swap(ch,0,0)，就是['a','b','c']，进入递归，自己调自己，只是i为1，交换(0,0)位置之后的状态我称为 状态B
    //i不等于2，来到这里，j=1，执行第一个swap(ch,1,1)，这个状态我称为 状态C1 ,再进入fun函数，此时标记为T1，i为2，那么这时就进入上一个if，将"abc"放进list中
    /////////////-------》此时结果集为["abc"]

    //2.执行完list.add之后，遇到return，回退到T1处，接下来执行第二个swap(ch,1,1)，状态C1又恢复为状态B
    //恢复完之后，继续执行for循环，此时j=2,那么swap(ch,1,2),得到"acb"，这个状态我称为C2,然后执行fun，此时标记为T2,发现i+1=2,所以也被添加进结果集，此时return回退到T2处往下执行
    /////////////-------》此时结果集为["abc","acb"]
    //然后执行第二个swap(ch,1,2)，状态C2回归状态B,然后状态B的for循环退出回到状态A

    //             a|b|c(状态A)
    //               |
    //               |swap(0,0)
    //               |
    //             a|b|c(状态B)
    //             /  \
    //   swap(1,1)/    \swap(1,2)  (状态C1和状态C2)
    //           /      \
    //         a|b|c   a|c|b

    //3.回到状态A之后，继续for循环，j=1,即swap(ch,0,1)，即"bac",这个状态可以再次叫做状态A,下面的步骤同上
    /////////////-------》此时结果集为["abc","acb","bac","bca"]

    //             a|b|c(状态A)
    //               |
    //               |swap(0,1)
    //               |
    //             b|a|c(状态B)
    //             /  \
    //   swap(1,1)/    \swap(1,2)  (状态C1和状态C2)
    //           /      \
    //         b|a|c   b|c|a

    //4.再继续for循环，j=2,即swap(ch,0,2)，即"cab",这个状态可以再次叫做状态A，下面的步骤同上
    /////////////-------》此时结果集为["abc","acb","bac","bca","cab","cba"]

    //             a|b|c(状态A)
    //               |
    //               |swap(0,2)
    //               |
    //             c|b|a(状态B)
    //             /  \
    //   swap(1,1)/    \swap(1,2)  (状态C1和状态C2)
    //           /      \
    //         c|b|a   c|a|b

    //5.最后退出for循环，结束。


}

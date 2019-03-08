package Algorithm.AlgorithmSloution;

import java.util.Scanner;

/**
 * Created by Yan_Jiang on 2019/3/3.
 * 判断一个数 是否是 回文数
 * 判断一个字符串 是否是 回文串
 */
public class HuiWenPanDuan {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(); //回文数字判断 --> 将数字转字符串
        String s1 = String.valueOf(num);

       // String s1 = sc.nextLine(); //回文字符串

        char[] c1 = s1.toCharArray();
       // char[] c2 = new char[s1.length()];

        int left = 0;
        int right = s1.length() -1;

        while(left < right) {
            if(c1[left] == c1[right]) {
                left++;
                right--;
                continue;
            } else {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");

    }



       /* for (int i = 0; i <s1.length() ; i++) {
            c2[s1.length()-1-i] = c1[i];
        }

        for (int i = 0; i <s1.length(); i++) {
            if(c1[i] != c2[i]) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("yes");
    }*/


}

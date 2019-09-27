package Algorithm.Str;

/**
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，
 * 但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0。
 *  "-123" --> -123
 *  "123" --> 123
 */
public class StrToInt {

    public static int strToInt(String str) {

        if(str == null ||str.length() == 0 || str.trim().equals("")) {
            return 0;
        }

        char[] ch = str.toCharArray();
        int sum = 0;
        boolean flag = true; //正负号判断 默认为正

        for(int i=0; i<ch.length; i++) {
            if(ch[i] == '-') {
                flag = false;
                continue;
            }
            if(ch[i]<'0' || ch[i]>'9') {
                return 0;
            }
            sum = sum*10 + (ch[i]-'0'); // ch[i]-'0' 转int  不然字符型转int为ASCLL码
        }

        return flag == true ? sum : -sum;
    }

    public static void main(String[] args) {
        System.out.println(strToInt("123"));
    }
}


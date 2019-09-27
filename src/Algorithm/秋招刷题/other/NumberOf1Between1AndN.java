package Algorithm.other;

/**
 * 给定一个非负整数n，统计1~n中所有数中1出现的次数
 * 遍历1~n的所有数，把每个数都转为char数组，然后看1在数组中出现的次数，统计返回即可。
 */
public class NumberOf1Between1AndN {


    public static void numberOf1Between1AndNII(int n) {

        if(n < 0) {
            return;
        }

        for(int i=0; i<=n; i++) {
            if(helper(i)) {
                System.out.print(i + " ");
            }
        }

    }

    private static boolean helper(int n) {

        while(n != 0) {
            int temp = n%10;
            if(temp == 1) {
                return true;
            }
            n = n / 10;
        }
        return false;
    }


    public static void numberOf1Between1AndN(int n) {

        int count = 0;
        for(int i=0; i<=n; i++) {
            char[] ch = String.valueOf(i).toCharArray();
            for(char c : ch) {
                if(String.valueOf(c).equals("1")) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        numberOf1Between1AndN(10);
        numberOf1Between1AndNII(10);
    }

}

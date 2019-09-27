package Algorithm.other;

//青蛙跳台阶 ==> fabonacci 一次1个或2个
public class JumpFloor {

    public static int jumpFloor(int n) {

        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }

        int fn1= 1;
        int fn2 = 2;
        int currentNum = 0;
        for(int i=3; i<=n; i++) {
            currentNum = fn1 + fn2;
            fn1 = fn2;
            fn2 = currentNum;
        }
        return currentNum;
    }
}

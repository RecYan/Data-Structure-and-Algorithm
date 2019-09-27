package Algorithm.Str;

/**
 * 统计一个字符串在另一个字符串中出现的次数
 */
public class PinrtCount {

    //查找指定字符或字符串在字符串中第一次出现地方的索引，未找到的情况返回 -1.
    public static int printCount(String subStr, String str) {

        int count = 0;
        int index = 0;

        while(true) {
            ////找不到，跳出来
            if(str.indexOf(subStr, index) == -1) {
                break;
            } else {
                count++;
                //更新查找索引值，继续找
                index = str.indexOf(subStr, index) + 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String subStr = "heima";
        String str = "woaiheima,heimabutongyubaima,wulunheimahaishibaima,zhaodaogongzuojiushihaoma";
        System.out.println(printCount(subStr, str));
    }

}

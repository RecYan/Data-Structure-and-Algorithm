package Algorithm.AlgorithmSloution;

/**
 * Created by Yan_Jiang on 2019/3/9.
 * 实现一个函数，把字符串中的每个空格替换成"%20"，
 * 例如“We are happy.“，则输出”We%20are%20happy.“。
 */
public class ReplaceBlank {

    //usedLength 字符数组中实际使用的长度
    public static String replaceBlank(char[] ch, int usedLength) {


        // 判断输入是否合法
        if (ch == null || ch.length < usedLength) {
            return null;
        }

        //统计字符数组中空白格个数
        int writeBlank = 0;
        for (int i = 0; i < usedLength; i++) {
            if(ch[i] == ' ') {
                writeBlank ++;
            }
        }

        int targetLength = usedLength + writeBlank *2; //替换后字符数组的长度
        if (targetLength > ch.length) { // 如果转换后的长度大于数组的最大长度，直接返回失败
            return null;
        }
        // 如果没有空白字符就不用处理
        if (writeBlank == 0) {
            return null;
        }

        int p2 = targetLength -1; //指向扩容后的尾部
        int p1 = usedLength -1; //指向原字符数组的尾部

        while(p1>=0 && p2>p1) {
            if(ch[p1] == ' ') {
                ch[p2 --] = '0';
                ch[p2 --] = '2';
                ch[p2 --] = '%';
                p1 --;
            } else { //移动p1的元素到p2-1的位置
                ch[p2] = ch[p1];
                p2 --;
                p1 --;
            }
        }

        return new String(ch, 0, targetLength);
    }

    public static String Solution2(StringBuilder str) {
        if(str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< str.length(); i++) {
            if(str.charAt(i) == ' ') {
                sb.append("%");
                sb.append("2");
                sb.append("0");
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        char[] string = new char[50];
        string[0] = 'w';
        string[1] = 'e';
        string[2] = ' ';
        string[3] = 'a';
        string[4] = 'r';
        string[5] = 'e';
        string[6] = ' ';
        string[7] = 'h';
        string[8] = 'a';
        string[9] = 'p';
        string[10] = 'p';
        string[11] = 'y';
        System.out.println(new String(string, 0 ,12));
        System.out.println(replaceBlank(string, 12));
    }
}

package Algorithm.Str;

public class ReverseSentence {


    public static String ReverseSentence(String str) {
        if(str.trim().equals("")){
            return str;
        }
        String[] a = str.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = a.length-1; i>=0; i--){
            sb.append(a[i]); //不越界
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(ReverseSentence("student. a am I"));
    }



}

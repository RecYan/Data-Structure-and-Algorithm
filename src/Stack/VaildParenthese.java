package Stack;



/**
 * Created by Yan_Jiang on 2018/8/15.
 * leetcode -- 20题括号匹配问题
 */


public class VaildParenthese {

    public boolean isVaild(String s) {

        ArrayStack<Character> stack = new ArrayStack<Character>();

        for(int i=0; i<s.length(); i++) {
            //遍历字符串 判断每个字符
            char c = s.charAt(i);
            if(c == '{' || c == '[' || c == '(') {
                //满足条件则压栈
                stack.push(c);
            } else { //处理右括号
                if(stack.isEmpity()) {
                    return false;
                }
                //取栈顶元素进行对比
                char topChar = stack.pop();
                if(c==')' && topChar!='(') {
                    return false;
                }
                if(c==']' && topChar!='[') {
                    return false;
                }
                if(c=='}' && topChar!='{') {
                    return false;
                }
            }
        }
        return stack.isEmpity(); //只有完全匹配了 才能成功
    }
}

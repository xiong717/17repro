import java.util.Stack;

/*
* https://leetcode-cn.com/problems/valid-parentheses/submissions/
* 题目：给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-parentheses
*
* 思路：用栈判断、注意还有括号顺序问题。
思路：左括号入栈，遇到右括号 拿到栈顶元素，判断是否匹配，
匹配那就弹出，（不匹配 那就return false）最后栈为空则是匹配的。
左括号多的情况，栈不为空，然后字符串已经遍历完了。
右括号多的情况，栈为空，但字符串还有。

* */
public class hk1 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(ch == '('||ch == '{'||ch=='[') {
                //说明当前遍历到的字符是左括号
                stack.push(ch);
            }else{
                //判断当前栈 是否为空
                if(stack.empty()){
                    System.out.println("右括号多");
                    return false;
                }
                //2.拿到栈顶元素，看栈顶元素是否和当前字符匹配，匹配出栈
                char t = stack.peek();
                if(t == '['&& ch ==']' ||t == '{'&& ch =='}'||t == '('&& ch ==')') {
                    stack.pop();
                }else{
                    System.out.println("左右括号不匹配");
                    return false;
                }
            }
        }
        //再次判断 循环出来后 栈是否为空 不为空 则左括号多
        if(!stack.empty()) {
            System.out.println("左括号多");
            return false;
        }
        return true;
    }
}

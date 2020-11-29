import java.util.Stack;

public class HomeWork05RemoveOuterParentheses {
    public String removeOuterParentheses(String S) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int start = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                stack.push('(');
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    sb.append(S, start + 1, i);
                    start = i + 1;
                }
            }
        }
        return sb.toString();
    }
}

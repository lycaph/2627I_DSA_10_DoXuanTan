import java.util.Map;
import java.util.Stack;

public class CODE2 {
    public static String isBalanced(String s) {
        Map<Character, Character> open_set = Map.of(
                '(', ')',
                '[', ']',
                '{', '}'
        );
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (open_set.containsKey(ch)) {
                st.push(ch);
            } else {
                if (st.isEmpty()) {
                    return "NO";
                }
                char pop = st.pop();
                if (open_set.get(pop) != ch) {
                    return "NO";
                }
            }
        }
        return st.isEmpty() ? "YES" : "NO";
    }
}
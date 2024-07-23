import java.util.*;

class Solution {
    public int calculate(String s) {
        // Tc: O(n) Sc: O(n)
        char lastSign = '+';
        int currNum = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                currNum = currNum * 10 + ch - '0';
            }
            if ((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1) {
                if (lastSign == '+')
                    st.push(currNum);
                else if (lastSign == '-')
                    st.push(-currNum);
                else if (lastSign == '*')
                    st.push(st.pop() * currNum);
                else if (lastSign == '/')
                    st.push(st.pop() / currNum);
                currNum = 0;
                lastSign = ch;
            }
        }

        int res = 0;
        while (!st.isEmpty()) {
            res += st.pop();
        }

        return res;

    }
}
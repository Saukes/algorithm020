package daily;

public class HomeWork04LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int maxLength = 0;
        for (int i = 1; i < dp.length; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = 2 + (i - 2 >= 0 ? dp[i - 2] : 0);
                } else if (s.charAt(i - 1) == ')') {
                    if (dp[i - 1] > 0) {
                        if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                            dp[i] = 2 + dp[i - 1] + (i - dp[i - 1] - 1 - 1 >= 0 ? dp[i - dp[i - 1] - 1 - 1] : 0);

                        }
                    }
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }
}

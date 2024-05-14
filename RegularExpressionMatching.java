public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;

        // Initialize dp for patterns like a*, a*b*, a*b*c* etc.
        for (int j = 2; j <= p.length(); j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2] || (dp[i - 1][j] && (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)));
                }
            }
        }

        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        RegularExpressionMatching solution = new RegularExpressionMatching();
        System.out.println(solution.isMatch("aa", "a"));   // Output: false
        System.out.println(solution.isMatch("aa", "a*"));  // Output: true
        System.out.println(solution.isMatch("ab", ".*"));  // Output: true
    }
}

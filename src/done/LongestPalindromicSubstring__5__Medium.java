package done;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 */
public class LongestPalindromicSubstring__5__Medium {

    /**
     * DP quadratic time and space
     */
    private static String longestPalindrome(String s) {

        String res = "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        char[] a = s.toCharArray();

        /* Solution */
        for (int i = 0; i < s.length(); i++) {   // prefix ends at i
            for (int j = i; j >= 0; j--) {   // suffix of prefix starts from j
                /* debug logging * /
                System.out.println(s.substring(j, i + 1));
                /* debug logging */
                dp[i][j] = a[i] == a[j] && (i - j <= 2 || dp[i - 1][j + 1]);    // a*a is palindrome iff * is palindrome
                res = ((dp[i][j] && res.length() < i - j + 1)) ? s.substring(j, i + 1) : res;
            }
        }
        /* Solution */

        /* Solution in a reversed way * /
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (a[i] == a[j] && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                }
                if (dp[i][j] && res.length() < j - i + 1) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        /* Solution */

        return res;
    }

    public static void main(String[] args) {

        String s1 = "playspirittiripscoding";
        System.out.println("Solution to string " + s1 + " is: "
                + longestPalindrome(s1) + "\n["
                + (longestPalindrome(s1).equalsIgnoreCase("spirittirips")
                ? "Passed"
                : "Failed") + "]");
        String s2 = "1kdkek3k4hk5khakhsh";
        System.out.println("Solution to string " + s2 + " is: " + longestPalindrome(s2) + "\n["
                + (longestPalindrome(s2).equalsIgnoreCase("khakh") ? "Passed" : "Failed") + "]");
        String s3 = "banana";
        System.out.println("Solution to string " + s3 + " is: " + longestPalindrome(s3) + "\n["
                + (longestPalindrome(s3).equalsIgnoreCase("anana") ? "Passed" : "Failed") + "]");
        String s4 = "a";
        System.out.println("Solution to string " + s4 + " is: " + longestPalindrome(s4) + "\n["
                + (longestPalindrome(s4).equalsIgnoreCase("a") ? "Passed" : "Failed") + "]");
        String s5 = "ab";
        System.out.println("Solution to string " + s5 + " is: " + longestPalindrome(s5) + "\n["
                + (longestPalindrome(s5).equalsIgnoreCase("a") ? "Passed" : "Failed") + "]");
        String s6 = "";
        System.out.println("Solution to string " + s6 + " is: " + longestPalindrome(s6) + "\n["
                + (longestPalindrome(s6).equalsIgnoreCase("") ? "Passed" : "Failed") + "]");
        String s7 = "aaaaa";
        System.out.println("Solution to string " + s7 + " is: " + longestPalindrome(s7) + "\n["
                + (longestPalindrome(s7).equalsIgnoreCase("aaaaa") ? "Passed" : "Failed") + "]");
        String s8 = "abccccdd";
        System.out.println("Solution to string " + s8 + " is: " + longestPalindrome(s8) + "\n["
                + (longestPalindrome(s8).equalsIgnoreCase("cccc") ? "Passed" : "Failed") + "]");

    }

}

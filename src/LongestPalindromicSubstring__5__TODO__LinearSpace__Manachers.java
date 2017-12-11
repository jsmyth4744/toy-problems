
/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 */
public class LongestPalindromicSubstring__5__TODO__LinearSpace__Manachers {

    /**
     * Center search quadratic time constant space
     */
    private static String longestPalindromeCenterSearch(String s) {
        return s;
    }

    /**
     * Manacher's linear time solution
     */
    private static String longestPalindromeManachers(String s) {
        return s;
    }

    public static void main(String[] args) {

        String s1 = "playspirittiripscoding";
        System.out.println("Solution to string " + s1 + " is: "
                + longestPalindromeCenterSearch(s1) + "\n["
                + (longestPalindromeCenterSearch(s1).equalsIgnoreCase("spirittirips")
                ? "Passed"
                : "Failed") + "]");
        String s2 = "1kdkek3k4hk5khakhsh";
        System.out.println("Solution to string " + s2 + " is: " + longestPalindromeCenterSearch(s2) + "\n["
                + (longestPalindromeCenterSearch(s2).equalsIgnoreCase("khakh") ? "Passed" : "Failed") + "]");
        String s3 = "banana";
        System.out.println("Solution to string " + s3 + " is: " + longestPalindromeCenterSearch(s3) + "\n["
                + (longestPalindromeCenterSearch(s3).equalsIgnoreCase("anana") ? "Passed" : "Failed") + "]");
        String s4 = "a";
        System.out.println("Solution to string " + s4 + " is: " + longestPalindromeCenterSearch(s4) + "\n["
                + (longestPalindromeCenterSearch(s4).equalsIgnoreCase("a") ? "Passed" : "Failed") + "]");
        String s5 = "ab";
        System.out.println("Solution to string " + s5 + " is: " + longestPalindromeCenterSearch(s5) + "\n["
                + (longestPalindromeCenterSearch(s5).equalsIgnoreCase("a") ? "Passed" : "Failed") + "]");
        String s6 = "";
        System.out.println("Solution to string " + s6 + " is: " + longestPalindromeCenterSearch(s6) + "\n["
                + (longestPalindromeCenterSearch(s6).equalsIgnoreCase("") ? "Passed" : "Failed") + "]");
        String s7 = "aaaaa";
        System.out.println("Solution to string " + s7 + " is: " + longestPalindromeCenterSearch(s7) + "\n["
                + (longestPalindromeCenterSearch(s7).equalsIgnoreCase("aaaaa") ? "Passed" : "Failed") + "]");
        String s8 = "abccccdd";
        System.out.println("Solution to string " + s8 + " is: " + longestPalindromeCenterSearch(s8) + "\n["
                + (longestPalindromeCenterSearch(s8).equalsIgnoreCase("cccc") ? "Passed" : "Failed") + "]");

    }

}

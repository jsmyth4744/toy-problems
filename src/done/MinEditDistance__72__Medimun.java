package done;

/**
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2.
 * (each operation is counted as 1 step.)
 * You have the following 3 operations permitted on a word:
 * Insert a character
 * Delete a character
 * Replace a character
 * <p>
 * Update: Liner space solution added.
 */
public class MinEditDistance__72__Medimun {

    private static int utilMin3Int(int a, int b, int c) {
        return (a < b) ? Math.min(a, c) : Math.min(b, c);
    }

    /**
     * O(mn) space solution
     */
    private static int minEdits(String strL, String strR) {
        int r = strL.length();
        int c = strR.length();
        int dp[][] = new int[r + 1][c + 1];

        // search goes here
        for (int i = 0; i <= r; i++) {
            for (int j = 0; j <= c; j++) {
                if (0 == i) {
                    dp[i][j] = j;
                } else if (0 == j) {
                    dp[i][j] = i;
                } else if (strL.charAt(i - 1) == strR.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = utilMin3Int(dp[i - 1][j], dp[i - 1][j - 1], dp[i][j - 1]) + 1;
                }
            }
        }

        return dp[r][c];
    }

    /**
     * O(n) space solution
     */
    private static int minEditsLinearSpace(String strL, String strR) {
        int ll = strL.length();
        int lr = strR.length();
        int dpPrevious[] = new int[lr + 1];
        int dpCurrent[] = new int[lr + 1];
        int minSteps = 0;

        // search goes here
        for (int i = 0; i <= ll; i++) {
            for (int j = 0; j <= lr; j++) {
                if (0 == i) {
                    dpCurrent[j] = j;
                } else if (0 == j) {
                    dpCurrent[j] = i;
                } else if (strL.charAt(i - 1) == strR.charAt(j - 1)) {
                    dpCurrent[j] = dpPrevious[j - 1];
                } else {
                    dpCurrent[j] = utilMin3Int(dpPrevious[j], dpPrevious[j - 1], dpCurrent[j - 1]) + 1;
                }
            }
            minSteps = dpCurrent[lr];
            dpPrevious = dpCurrent.clone();
            dpCurrent = new int[lr + 1];
        }

        return minSteps;
    }

    public static void main(String[] args) {

        String test1L = "hi world";
        String test1R = "hello world";
        int ans1 = 4;
        String test2L = "variable";
        String test2R = "var";
        int ans2 = 5;
        String test3L = "increase";
        String test3R = "decrease";
        int ans3 = 2;
        String test4L = "foo";
        String test4R = "bar";
        int ans4 = 3;
        String test5L = "cap";
        String test5R = "cat";
        int ans5 = 1;

        System.out.format("Test case 1 output \t%d\t which should be \t%d\n", minEdits(test1L, test1R), ans1);
        System.out.format("Test case 1 output \t%d\t which should be \t%d\n", minEditsLinearSpace(test1L, test1R), ans1);
        System.out.format("Test case 2 output \t%d\t which should be \t%d\n", minEdits(test2L, test2R), ans2);
        System.out.format("Test case 2 output \t%d\t which should be \t%d\n", minEditsLinearSpace(test2L, test2R), ans2);
        System.out.format("Test case 3 output \t%d\t which should be \t%d\n", minEdits(test3L, test3R), ans3);
        System.out.format("Test case 3 output \t%d\t which should be \t%d\n", minEditsLinearSpace(test3L, test3R), ans3);
        System.out.format("Test case 4 output \t%d\t which should be \t%d\n", minEdits(test4L, test4R), ans4);
        System.out.format("Test case 4 output \t%d\t which should be \t%d\n", minEditsLinearSpace(test4L, test4R), ans4);
        System.out.format("Test case 5 output \t%d\t which should be \t%d\n", minEdits(test5L, test5R), ans5);
        System.out.format("Test case 5 output \t%d\t which should be \t%d\n", minEditsLinearSpace(test5L, test5R), ans5);
    }

}

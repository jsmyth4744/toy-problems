import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by TAB on 9/6/17.
 * Find the longest path in a matrix with given constraints
 * Given a n*n matrix where all numbers are distinct, find the maximum length path (starting from any cell)
 * such that all cells along the path are in increasing order with a difference of 1.
 * <p>
 * We can move in 4 directions from a given cell (i, j), i.e., we can move to (i+1, j) or (i, j+1) or (i-1, j)
 * or (i, j-1) with the condition that the adjacent cells have a difference of 1.
 * <p>
 * Example:
 * <p>
 * Input:  mat[][] = {{1, 2, 9},
 * {5, 3, 8},
 * {4, 6, 7}}
 * Output: 4
 * The longest path is 6-7-8-9.
 */
public class LongestLengthPathInMatrix__329__TODO {


    static int utils3Max(int a, int b, int c) {
        return (a > b) ? Math.max(a, c) : Math.max(b, c);
    }

    static int maxLength(int score[][]) {

        int max = Integer.MIN_VALUE;
        int r = score.length;
        int c = score[0].length;
        int dp[][] = new int[r][c];

        for (int row[] : dp) {
            Arrays.fill(row, 1);
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {

            }
        }

        for (int row[] : dp) {
            for (int col : row) {
                System.out.print(col + "\t");
            }
            System.out.print("\n");
        }

        return max;

    }

    public static void main(String[] args) {
        int case1[][] = {
                {1, 2, 9},
                {5, 3, 8},
                {4, 6, 7}
        };
        System.out.println("[ Test case 1 ]");
        System.out.println("Length of the longest increase by 1 path is: " + maxLength(case1));
        System.out.println("Length of the longest increase by 1 path should be: 4");
    }
}


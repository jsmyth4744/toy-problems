import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by TAB on 9/9/17.
 * Given a list of unique words, find all pairs of distinct indices (i, j) in the given list,
 * so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
 * <p>
 * Example 1:
 * Given words = ["bat", "tab", "cat"]
 * Return [[0, 1], [1, 0]]
 * The palindromes are ["battab", "tabbat"]
 * Example 2:
 * Given words = ["abcd", "dcba", "lls", "s", "sssll"]
 * Return [[0, 1], [1, 0], [3, 2], [2, 4]]
 * The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]
 */
public class PalindromePairs__336__TODO {

    class TrieNode {

        // assume alphabet of English letters plus termination symbol
        // use array to mimic hashtable for simplicity
        int[] alphabet = new int[27];

    }

    static List<List<Integer>> allPalindromPairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();


        return res;
    }

    public static void main(String[] args) {

        String[] words = {"bat", "tab", "cat"};

        System.out.println("Solution list: [");
        allPalindromPairs(words).forEach(solution -> {
            System.out.print("\t");
            solution.forEach(index -> {
                System.out.print(index + "\t");
            });
            System.out.println(",");
        });
        System.out.println("]");

    }
}

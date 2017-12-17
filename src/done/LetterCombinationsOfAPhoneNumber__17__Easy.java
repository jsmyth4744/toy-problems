package done;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Given a digit string, return all possible letter combinations that the number
 * could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below.
 *
 * 1       2       3   --------------------------------------------------------
 * ------- abc     def --------------------------------------------------------
 * 4       5       6   --------------------------------------------------------
 * ghi     jkl     mno --------------------------------------------------------
 * 7       8       9   --------------------------------------------------------
 * pqrs    tuv     wxyz--------------------------------------------------------
 * *       0       #   --------------------------------------------------------
 *
 * Input:Digit string "23" Output: ["ad", "ae", "af", "bd", "be", "bf", "cd",
 * "ce", "cf"]. Note: Although the above answer is in lexicographical order,
 * your answer could be in any order you want.
 */
public class LetterCombinationsOfAPhoneNumber__17__Easy {

    private static Map<Integer, char[]> keyboard = new HashMap<>() {{
        this.put(2, "abc".toCharArray());
        this.put(3, "def".toCharArray());
        this.put(4, "ghi".toCharArray());
        this.put(5, "jkl".toCharArray());
        this.put(6, "mno".toCharArray());
        this.put(7, "pqrs".toCharArray());
        this.put(8, "tuv".toCharArray());
        this.put(9, "wxyz".toCharArray());
    }};

    public static void main(String[] args) {

        typeInThem("23");
        typeInThem("32843");
        typeInThem("774748");

    }

    private static void typeInThem(String digits) {

        System.out.format("Possible letter combinations for input [ %s ]:\n", digits);

        char[] digitArray = digits.toCharArray();
        List<String> result = new ArrayList<>();
        List<Integer> digitList = IntStream
                .rangeClosed(1, digitArray.length)
                .map(i -> Integer.parseInt(digitArray[digitArray.length - i] + ""))
                .boxed()
                .collect(Collectors.toList());
        Collections.reverse(digitList);

        print(digitList, 0, "", result);

        result.forEach(System.out::println);
    }

    private static void print(List<Integer> digits, int pos, String prefix, List<String> res) {
        if (pos >= digits.size()) {
            res.add(prefix);
            return;
        }
        char[] letters = keyboard.get(digits.get(pos++));
        for (char letter : letters) {
            print(digits, pos, prefix + letter, res);
        }
    }

}

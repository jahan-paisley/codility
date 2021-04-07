package digital.paisley.test.leetcode;

import java.util.List;

/**
 * https://leetcode.com/problems/determine-color-of-a-chessboard-square/
 */
public class SquareIsWhite {
    public boolean squareIsWhite(String coordinates) {
        char[] chars = coordinates.toCharArray();
        char chr = chars[0];
        int num = Character.getNumericValue(chars[1]);
        return (num % 2 == 0 && List.of('a', 'c', 'e', 'g').contains(chr)) ||
                (num % 2 == 1 && List.of('b', 'd', 'f', 'h').contains(chr));
    }
}

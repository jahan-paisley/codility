package digital.paisley.test.codility;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

/**
 * https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/flags/
 */
public class Solution12Flags {
    public int solution(int[] A) {
        int[] picks = find_picks(A);
        IntStream.range(0, picks.length/2);
        return 0;
    }

    private int[] find_picks(int[] A) {
        return new int[0];
    }

    @Test
    public void test_solution() throws Exception {
        int[] input = {1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2};
        Assertions.assertEquals(3, solution(input));
    }
}
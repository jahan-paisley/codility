package digital.paisley.test.codility;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * https://app.codility.com/programmers/lessons/3-time_complexity/tape_equilibrium/
 */
public class Solution2Equilibrium {
    public int solution(int[] A) {
        if (A.length == 0) return 0;
        int min_diff_index = -1;
        long sum = 0;
        for (int el : A)
            sum += el;
        long right_sum = sum;
        long left_sum = 0L;
        long min_diff = Integer.MAX_VALUE;
        for (int i = 1; i < A.length; i++) {
            int el = A[i - 1];
            right_sum = right_sum - el;
            left_sum = left_sum + el;
            long curr_diff = Math.abs(right_sum - left_sum);
            if (min_diff > curr_diff) {
                min_diff = curr_diff;
                min_diff_index = i;
            }
        }
        System.out.printf("min_diff is: %d\n", min_diff);
        System.out.printf("min_diff_index is: %d\n", min_diff_index);
        return (int) min_diff;
    }

    @Test
    public void test_solution2() {
        int[] B = {1, 4, 3, 5, 2, 6, 7, 8, 9, 10, 11, 12};
        Assertions.assertEquals(6, solution(B));
    }
}

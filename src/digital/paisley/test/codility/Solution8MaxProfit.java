/*
package digital.paisley.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
//
//     Solved With Hint Video
//
public class Solution8MaxProfitWithHint {
    public int solution(int[] A) {
        if (A.length == 1)
            return A[0];
        else {
            int a = calcSum(A, 0, A.length / 2);
            int b = calcSum(A, A.length / 2, A.length);
            int c = calcMergeSum(A, A.length / 2);
            return Math.max(a, b);
        }
    }

    private int calcMergeSum(int[] a, int start, int end, int middle) {
        return 0;
    }

    public int calcSum(int[] A, int start, int end) {
        if (start == end)
            return A[start];
        else {
            int a = calcSum(A, start, (end - start) / 2);
            int b = calcSum(A, (end - start) / 2, end);
            calcMergeSum(A, start, end, middle)
            return Math.max(a, b)
        }
    }

    @Test
    public void test_solution() {
        Assertions.assertEquals(0, solution(new int[]{1, 2, 3, 4, 1, 1, 1}));
        Assertions.assertEquals(0, solution(new int[]{10}));
        Assertions.assertEquals(-1, solution(new int[]{}));
        Assertions.assertEquals(-1, solution(new int[]{1, 2, 3, 4, 1, 1, 2}));
        Assertions.assertEquals(0, solution(new int[]{3, 4, 3, 2, 3, -1, 3, 3}));
    }
}*/

package digital.paisley.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1 {
    public int solution(int[] A) {
        if (A.length == 0) return 1;
        int n = A.length + 1;
        long sum1 = 0;
        for (int el : A) sum1 += el;
        long sum2 = n * (n + 1L) / 2;
        int diff = (int) (sum2 - sum1);
        int missEl = diff == 0 ? A[A.length - 1] + 1 : diff;
        System.out.println(missEl);
        return missEl;
    }

    @Test
    public void test_solution() {
        int[] A = new int[99_999];
        for (int i = 0; i < 99_999; i++) {
            if (i >= 89999)
                A[i] = i + 2;
            else
                A[i] = i + 1;
        }
        int[] B = {1, 4, 3, 5, 2, 6, 7, 8, 9, 10, 12};
        Assertions.assertEquals(90000, solution(A));
        Assertions.assertEquals(11, solution(B));
        Assertions.assertEquals(1, solution(new int[]{}));
        Assertions.assertEquals(2, solution(new int[]{1}));
    }
}

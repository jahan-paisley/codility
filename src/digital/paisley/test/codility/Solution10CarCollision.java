package digital.paisley.test.codility;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution10CarCollision {
    public int solution(int[] A) {
        int factor = 0;
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0)
                factor += 1;
            if (A[i] == 1 && factor != 0)
                sum += factor;
            if (sum > 1_000_000_000)
                return -1;
        }
        return sum;
    }

    @Test
    public void test_solution() throws Exception {
        Assertions.assertEquals(5, solution(new int[]{0, 1, 0, 1, 1}));
        Assertions.assertEquals(6, solution(new int[]{0, 1, 0, 1, 0, 1}));
    }
}
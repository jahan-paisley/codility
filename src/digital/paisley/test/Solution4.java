package digital.paisley.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Solution4 {
    public int[] solution(int[] A, int k) {
        if (A.length == 0) return A;
        if (k == 0 || k % A.length == 0) return A;
        k = k % A.length;
        int[] ints = Arrays.copyOfRange(A, A.length - k, A.length);
        System.arraycopy(A, 0, A, k, A.length - k);
        System.arraycopy(ints, 0, A, 0, ints.length);
        return A;
    }

    @Test
    public void test_solution() {
        Assertions.assertArrayEquals(new int[]{1, 0}, solution(new int[]{0, 1}, 1));
        Assertions.assertArrayEquals(new int[]{5, 6, 0, 1, 2, 3, 4}, solution(new int[]{0, 1, 2, 3, 4, 5, 6}, 2));
        Assertions.assertArrayEquals(new int[]{4, 5, 6, 0, 1, 2, 3}, solution(new int[]{0, 1, 2, 3, 4, 5, 6}, 3));
        Assertions.assertArrayEquals(new int[]{3, 4, 5, 6, 0, 1, 2}, solution(new int[]{0, 1, 2, 3, 4, 5, 6}, 4));
    }
}

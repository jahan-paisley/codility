package digital.paisley.test.codility;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * https://app.codility.com/programmers/lessons/5-prefix_sums/count_div/
 */
public class Solution11CountDivisors {
    public int solution(int A, int B, int K) {
        System.out.printf("%d %d %d\n", A, B, K);
        int result;

        if (A == B)
            return A % K == 0 ? 1 : 0;
        if (K > B)
            return 0;
        if (K == B)
            return A==0 ? 2 : 1;
        int firstDivisor = 0;
        //I can do better here by calculating next multiple of K greater than A
        for (int i = A; i <= B; i++) {
            if (i != 0 && i % K == 0) {
                firstDivisor = i;
                break;
            }
        }
        result = firstDivisor != 0 ? ((B - firstDivisor) / K) + 1 : 0;
        return A == 0 ? result + 1 : result;
    }

    @Test
    public void test_solution() throws Exception {
        Assertions.assertEquals(3, solution(6, 11, 2));
        Assertions.assertEquals(2, solution(6, 13, 4));
        Assertions.assertEquals(1, solution(6, 6, 3));
        Assertions.assertEquals(0, solution(0, 1, 11));
    }
}
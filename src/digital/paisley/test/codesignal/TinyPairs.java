package digital.paisley.test.codeSignal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TinyPairs {
    int countTinyPairs(int[] a, int[] b, int k) {
        int res = 0;
        for (int i = 0; i < a.length; i++) {
            int i1 = Integer.parseInt(a[i] + "" + b[b.length - i - 1]);
            if (i1 < k)
                res++;
        }
        return res;
    }

    @Test
    public void test() {
        int[] a = {1, 2, 3};
        int[] b = {1, 2, 3};
        int k = 31;
        Assertions.assertEquals(2, countTinyPairs(a, b, 31), 31);
    }

}

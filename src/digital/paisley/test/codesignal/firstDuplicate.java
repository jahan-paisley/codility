package digital.paisley.test.codeSignal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class FirstDuplicate {
    public int firstDuplicate(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (map.containsKey(a[i])) {
                map.put(a[i], Math.min(map.get(a[i]), i));
            } else
                map.put(a[i], a.length);
        }
        Integer firstDupIndex = map.values().stream().filter(k -> k != a.length).min(Integer::compareTo).orElse(-1);
        return firstDupIndex == -1 ? -1 : a[firstDupIndex];
    }

    @Test
    public void test_solution() {
        int[] A = {2, 1, 3, 5, 3, 2};
        Assertions.assertEquals(3, firstDuplicate(A));

        A = new int[]{1, 1, 2, 2, 1};
        Assertions.assertEquals(1, firstDuplicate(A));
    }
}

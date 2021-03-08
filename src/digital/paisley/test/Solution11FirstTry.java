package digital.paisley.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution11FirstTry {
    public int solution(int[] A) {
        List<Map.Entry<Integer, Integer>> discs = IntStream.range(0, A.length)
                .boxed()
                .map(i -> Map.entry(i - A[i], A[i] + i))
                .sorted(Map.Entry.comparingByKey()).collect(Collectors.toList());
        int coll = 0;
        for (int i = 0; i < discs.size(); i++) {
            for (int j = i; j < discs.size(); j++) {
                if (collision(discs.get(i), discs.get(j)))
                    coll++;
            }
        }
        return coll;
    }

    private boolean collision(Map.Entry<Integer, Integer> disc1, Map.Entry<Integer, Integer> disc2) {
        return disc1.getKey() > disc2.getKey() && disc2.getKey() < disc1.getValue();
    }

    @Test
    public void test_solution() throws Exception {
        Assertions.assertEquals(11, solution(new int[]{1, 5, 2, 1, 4, 0}));
    }
}
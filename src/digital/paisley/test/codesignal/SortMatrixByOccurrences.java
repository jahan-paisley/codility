package digital.paisley.test.codeSignal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.stream.Stream;

public class SortMatrixByOccurrences {
    int[][] sortMatrixByOccurrences(int[][] m) {
/*
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                map[m[i][j]] += 1;
            }
        }
        map.entrySet().stream().
*/
        return null;
    }

    @Test
    public void test() {
        int[][] m = new int[][]{
                {1, 4, -2},
                {-2, 3, 4},
                {3, 1, 3}
        };
        int[][] expected = new int[][]{
                {3, 3, 4},
                {3, 4, 1},
                {1, -2, -2}
        };
        Assertions.assertEquals(expected, sortMatrixByOccurrences(m));
    }
}

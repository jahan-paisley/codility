package digital.paisley.test.brilliant;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FrogJump {
    public int[][] calcSteps(int n) {
        if (n == 1)
            return new int[][]{{1}};
        else if (n == 2)
            return new int[][]{{1, 1}, {2}};
        else {
            int[][] ints = calcSteps(n - 1);
            return Stream.concat(addElems(ints, 1), incLastElems(ints))
                    .sorted((a, b) -> Integer.compare(b.length, a.length))
                    .toArray(int[][]::new);
        }
    }

    private Stream<int[]> addElems(int[][] ints, int... elems) {
        return Stream
                .of(ints)
                .map(o -> Stream
                        .concat(IntStream.of(o).boxed(), IntStream.of(elems).boxed())
                        .mapToInt(Integer::intValue)
                        .toArray()
                );
    }

    private Stream<int[]> incLastElems(int[][] ints) {
        return Stream
                .of(ints)
                .filter(o -> o[o.length - 1] == 1)
                .map(o -> {
                    o[o.length - 1] = 2;
                    return o;
                });
    }

    @Test
    public void test_solution() {
        int[][] actual = calcSteps(1);
        Assertions.assertArrayEquals(new int[][]{{1}}, actual);

        actual = calcSteps(2);
        Assertions.assertArrayEquals(new int[][]{{1, 1}, {2}}, actual);

        actual = calcSteps(3);
        int[][] expected = {{1, 1, 1}, {2, 1}, {1, 2}};
        Assertions.assertArrayEquals(expected, actual);

        actual = calcSteps(4);
        Assertions.assertArrayEquals(new int[][]{
                {1, 1, 1, 1},
                {2, 1, 1},
                {1, 2, 1},
                {1, 1, 2},
                {2, 2},
        }, actual);

        actual = calcSteps(5);
        expected = new int[][]{
                {1, 1, 1, 1, 1},
                {2, 1, 1, 1},
                {1, 2, 1, 1},
                {1, 1, 2, 1},
                {1, 1, 1, 2},
                {2, 2, 1},
                {2, 1, 2},
                {1, 2, 2}
        };
        Assertions.assertArrayEquals(expected, actual);
        actual = calcSteps(6);
    }
}

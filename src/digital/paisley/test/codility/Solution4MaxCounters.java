package digital.paisley.test.codility;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import java.util.Arrays;
import java.util.Random;

/**
 * https://app.codility.com/programmers/lessons/4-counting_elements/max_counters/
 */
public class Solution4MaxCounters {
    public int[] solution(int N, int[] A) {
        int[] counters = new int[N];
        Arrays.fill(counters, 0);
        int max = 0, next_max = 0;

        for (int i : A) {
            if (i > N) max = next_max;
            else {
                int index = i - 1;
                counters[index] = Math.max(max, counters[index]) + 1;
                next_max = Math.max(counters[index], next_max);
            }
        }
        for (int i = 0; i < counters.length; i++)
            counters[i] = Math.max(counters[i], max);
        return counters;
    }

    @Test
    public void test_solution() {
        Assertions.assertArrayEquals(new int[]{3, 2, 2, 4, 2}, solution(5, new int[]{3, 4, 4, 6, 1, 4, 4}));
        Assertions.assertArrayEquals(new int[]{2, 3, 3}, solution(3, new int[]{1, 2, 3, 4, 2, 3, 4, 3, 2}));
        Assertions.assertArrayEquals(new int[]{1, 1, 1}, solution(3, new int[]{1, 2, 3, 4, 4, 4, 4}));
        Assertions.assertArrayEquals(new int[]{1, 1, 2}, solution(3, new int[]{1, 2, 3, 4, 4, 4, 4, 3}));
        Assertions.assertArrayEquals(new int[]{0, 0, 1}, solution(3, new int[]{4, 4, 4, 3}));
        Assertions.assertArrayEquals(new int[]{0, 0, 0}, solution(3, new int[]{4, 4, 4, 4}));
        Assertions.assertArrayEquals(new int[]{3, 3, 4}, solution(3, new int[]{1, 1, 1, 4, 3}));
        Assertions.assertArrayEquals(new int[]{4, 4, 4}, solution(3, new int[]{1, 1, 1, 4, 3, 4}));

        Assertions.assertArrayEquals(new int[]{3, 2, 2, 4, 2}, solution(5, new int[]{3, 4, 4, 6, 1, 4, 4}));
        Assertions.assertArrayEquals(new int[]{2, 4, 0}, solution(3, new int[]{2, 1, 2, 2, 1, 2}));
        Assertions.assertArrayEquals(new int[]{3, 3}, solution(2, new int[]{2, 1, 3, 2, 3, 1, 2}));
        Assertions.assertArrayEquals(new int[]{9, 9, 9, 9, 9, 9, 9}, solution(7, new int[]{1, 1, 1, 1, 1, 1, 9, 4, 4, 4, 9}));

        for (int i = 0; i < 100; i++) {
            int[] randArr = generateRandomArray();
            int max = Arrays.stream(randArr).max().getAsInt();
            int N = max - 2;
            int[] expected = solution2(N, randArr);
            int[] solution = solution(N, randArr);
            if (!Arrays.equals(expected, solution))
                solution(N, randArr);
            try {
                Assertions.assertArrayEquals(expected, solution);
            } catch (AssertionFailedError e) {
                System.out.println("Input: " + Arrays.toString(randArr));
                System.out.println("N: " + N);
                System.out.println("Solution: " + Arrays.toString(solution));
                System.out.println("Expected: " + Arrays.toString(expected));
                System.out.println("");
            }
        }
    }

    public static int[] generateRandomArray() {
        Random random = new Random();
        int[] array = random.ints(10, 5, 10).toArray();
        return array;
    }

    public static int[] solution2(int N, int[] A) {
        int[] counters = new int[N];
        Arrays.fill(counters, 0);
        int start_line = 0;
        int current_max = 0;
        for (int i : A) {
            int x = i - 1;
            if (i > N) start_line = current_max;
            else if (counters[x] < start_line) counters[x] = start_line + 1;
            else counters[x] += 1;
            if (i <= N && counters[x] > current_max) current_max = counters[x];
        }
        for (int i = 0; i < counters.length; i++)
            if (counters[i] < start_line) counters[i] = start_line;
        return counters;
    }
}
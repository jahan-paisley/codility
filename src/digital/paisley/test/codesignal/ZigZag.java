package digital.paisley.test.codeSignal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ZigZag {
    int[] isZigzag(int[] numbers) {
        ArrayList<Integer> zigzag = new ArrayList<>();
        for (int i = 0; i < numbers.length - 2; i++) {
            if (numbers[i] < numbers[i + 1] && numbers[i + 1] > numbers[i + 2])
                zigzag.add(1);
            else if (numbers[i] > numbers[i + 1] && numbers[i + 1] < numbers[i + 2])
                zigzag.add(1);
            else
                zigzag.add(0);
        }
        return zigzag.stream().mapToInt(Integer::intValue).toArray();
    }

    @Test
    public void test() {
        int[] zigzag = isZigzag(new int[]{1, 2, 1, 3, 4});
        int[] expected = {1, 1, 0};
        Assertions.assertArrayEquals(expected, zigzag);

        zigzag = isZigzag(new int[]{1000000000, 1000000000, 1000000000});
        expected = new int[]{0};
        Assertions.assertArrayEquals(expected, zigzag);

        zigzag = isZigzag(new int[]{1, 3, 4, 5, 6, 14, 14});
        expected = new int[]{0, 0, 0, 0, 0};
        Assertions.assertArrayEquals(expected, zigzag);
    }

}

package digital.paisley.test.evotec;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

/*
The divisors of a number are the numbers that divide
this number without rest. Example: The divisors of 6
are 1, 2, 3 and 6. Write a program that calculates and
prints all divisors of the numbers 101 to 150.

The output shall look like this:

101 -> 1, 101
102 -> 1, 2, 3, 6, 17, 34, 51, 102
103 -> ...
 */
public class Solution12 {
    public void solution() {
        for (int number = 101; number <= 150; number++) {
            int[] divisors = calc_divisors(number);
            System.out.printf("%d -> ", number);
            for (int i = 0; i < divisors.length; i++) {
                if (i == divisors.length - 1)
                    System.out.printf("%d\n", divisors[i]);
                else System.out.printf("%d, ", divisors[i]);
            }
        }
    }

    private int[] calc_divisors(int input) {
        return IntStream.range(1, input + 1).filter(i -> input % i == 0).toArray();
    }

    @Test
    public void test_solution() {
        solution();
    }

    @Test
    public void test_calc_divisors() {
        int[] actual = calc_divisors(101);
        Assertions.assertArrayEquals(new int[]{1, 101}, actual);
        actual = calc_divisors(102);
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 6, 17, 34, 51, 102}, actual);
    }
}

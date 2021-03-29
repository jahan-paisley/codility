package digital.paisley.test.evotec;

import org.junit.jupiter.api.Test;

/*
Paper of size A0 has dimensions 1188 mm * 841 mm.
Folded (or cut) in half parallel to the shorter side will give us a sheet of paper with the dimensions 841 mm * 594 mm,
 called A1. Cut again parallel to the (now) shorter side will give A2, and so on.
In more general terms:
 The long side of A(n+1) is the short side of A(n) and the short side of A(n+1)
   is half of the long side of A(n).

Write a program to calculate and print paper sizes A0, A1, A2, A3, ....... , A8

The output may look like this:

A0 -> 1188 mm * 841 mm
A1 -> 841 mm * 594 mm
A2 -> ...
 */
public class Solution13SecondTry {

    public void solution() {
        double a = 1188, b = 841;
        for (int i = 0; i <= 8; i++) {
            System.out.printf("A%d -> %f mm * %f mm\n", i, a, b);
            double temp = b;
            b = a / 2;
            a = temp;
        }
    }

    @Test
    public void test_solution() {
        solution();
    }
}

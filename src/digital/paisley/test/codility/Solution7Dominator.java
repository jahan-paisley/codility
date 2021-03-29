package digital.paisley.test.codility;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * https://app.codility.com/programmers/lessons/8-leader/dominator/
 * Solved by watching hint video
 */
public class Solution7Dominator {
    public int solution(int[] A) {
        if (A.length == 0)
            return -1;
        else if (A.length == 1)
            return 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(A[0]);
        for (int i = 1; i < A.length; i++) {
            if (stack.isEmpty())
                stack.push(A[i]);
            else if (A[i] != stack.peek()) {
                stack.pop();
            } else
                stack.push(A[i]);
        }
        if (!stack.isEmpty()) {
            int elem = stack.peek();
            int occ = 0;
            int index = -1;
            for (int i = 0; i < A.length; i++) {
                if (A[i] == elem) {
                    index = i;
                    occ++;
                }
            }
            if (occ > A.length / 2.0)
                return index;
        }
        return -1;
    }

    @Test
    public void test_solution() {
        Assertions.assertEquals(0, solution(new int[]{1, 2, 3, 4, 1, 1, 1}));
        Assertions.assertEquals(0, solution(new int[]{10}));
        Assertions.assertEquals(-1, solution(new int[]{}));
        Assertions.assertEquals(-1, solution(new int[]{1, 2, 3, 4, 1, 1, 2}));
        Assertions.assertEquals(0, solution(new int[]{3, 4, 3, 2, 3, -1, 3, 3}));
    }
}
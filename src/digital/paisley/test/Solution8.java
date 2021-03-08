package digital.paisley.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Stack;

public class Solution8 {
    public enum WhoEatsWho {
        StackEatsArray,
        ArrayEatsStack,
        None
    }

    public int solution(int[] weights, int[] direction) {
        if (direction.length == 1) return 1;
        Stack<Map.Entry<Integer, Integer>> fishDirWeiStack = new Stack<>();
        fishDirWeiStack.push(Map.entry(direction[0], weights[0]));

        for (int i = 1; i < direction.length && i >= 1; i++) {
            int arrHeadDir = direction[i];
            int arrHeadWei = weights[i];
            Map.Entry<Integer, Integer> newEntry = Map.entry(arrHeadDir, arrHeadWei);
            if (fishDirWeiStack.isEmpty()) {
                fishDirWeiStack.push(newEntry);
                continue;
            }
            switch (whoEatsWho(fishDirWeiStack, arrHeadDir, arrHeadWei)) {
                case StackEatsArray:
                    break;
                case ArrayEatsStack:
                    fishDirWeiStack.pop();
                    i--;
                    break;
                case None:
                    fishDirWeiStack.push(newEntry);
                    break;
            }
        }
        return fishDirWeiStack.size();
    }

    WhoEatsWho whoEatsWho(Stack<Map.Entry<Integer, Integer>> fishDirWeiStack, int arrHeadDir, int arrHeadWei) {
        Map.Entry<Integer, Integer> stackHead = fishDirWeiStack.peek();
        Integer sHeadDir = stackHead.getKey();
        Integer sHeadWei = stackHead.getValue();

        WhoEatsWho result = WhoEatsWho.None;
        if (sHeadDir == 1 && arrHeadDir == 0) {
            if (sHeadWei > arrHeadWei)
                result = WhoEatsWho.StackEatsArray;
            else if (sHeadWei < arrHeadWei)
                result = WhoEatsWho.ArrayEatsStack;
        }
        return result;
    }

    @Test
    public void test_solution() throws Exception {
        Assertions.assertEquals(2, solution(new int[]{4, 3, 2, 1, 5}, new int[]{0, 1, 0, 0, 0}));
        Assertions.assertEquals(3, solution(new int[]{4, 6, 2, 1, 5, 3}, new int[]{0, 1, 0, 0, 0, 1}));
        Assertions.assertEquals(2, solution(new int[]{4, 6, 2, 1, 5, 3}, new int[]{0, 1, 0, 0, 0, 0}));
        Assertions.assertEquals(6, solution(new int[]{4, 6, 2, 1, 5, 3}, new int[]{1, 1, 1, 1, 1, 1}));
        Assertions.assertEquals(1, solution(new int[]{4, 3, 2, 1, 5, 6}, new int[]{1, 1, 1, 1, 1, 0}));
        Assertions.assertEquals(1, solution(new int[]{4, 3, 2, 1, 5, 6}, new int[]{1, 0, 1, 0, 1, 0}));
        Assertions.assertEquals(3, solution(new int[]{6, 3, 2, 1, 5, 4}, new int[]{1, 0, 1, 0, 1, 0}));
    }
}
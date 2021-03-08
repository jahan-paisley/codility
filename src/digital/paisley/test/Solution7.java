package digital.paisley.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Stack;

public class Solution7 {
    public int solution(String input) {
        if (input.length() % 2 == 1) return 0;
        if (input.length() == 0) return 1;

        var matchTable = new HashMap<Character, Character>(3);
        matchTable.put(')', '(');
        matchTable.put(']', '[');
        matchTable.put('}', '{');

        char[] chars = input.toCharArray();
        Stack<Character> stack = new Stack<>();
        int i;
        for (i = 0; i < chars.length; i++) {
            Character matchingEnd = matchTable.get(chars[i]);
            Character head = !stack.empty() ? stack.peek() : 0;
            if (matchingEnd != null && matchingEnd.charValue() == head)
                stack.pop();
            else
                stack.push(chars[i]);
        }
        return stack.empty() && i == chars.length ? 1 : 0;
    }

    @Test
    public void test_solution() {
        Assertions.assertEquals(1, solution("[[[]]]"));
        Assertions.assertEquals(1, solution("[[[{}]]]"));
        Assertions.assertEquals(0, solution("{[]}[[{}]]]"));
        Assertions.assertEquals(1, solution("{[]}[[[{}]]][]{}"));
    }
}
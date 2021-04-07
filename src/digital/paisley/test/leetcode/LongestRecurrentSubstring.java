package digital.paisley.test.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 */
public class LongestRecurrentSubstring {
    public int lengthOfLongestSubstring(String s) {
        return s.length() == 0 ? 0 : longestSubstring(s);
    }

    private int longestSubstring(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++)
            for (int j = i; j < s.length(); j++)
                if (s.substring(j).contains(s.substring(i, j)))
                    max = Math.max(j - i, max);
        return max;
    }

    @Test
    void test() {
        String input = "";
        Assertions.assertEquals(0, lengthOfLongestSubstring(input));

        input = "abcabcbb";
        Assertions.assertEquals(3, lengthOfLongestSubstring(input));

        input = "bbbbb";
        Assertions.assertEquals(1, lengthOfLongestSubstring(input));

        input = "pwwkew";
        Assertions.assertEquals(3, lengthOfLongestSubstring(input));
    }
}

package digital.paisley.test.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                for (int k = j; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> set = new ArrayList();
                        set.add(i);
                        set.add(j);
                        set.add(k);
                        result.add(set);
                    }
                }
            }
        }
        return result;
    }

    @Test
    void test() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
/*
         expected = ;
        Assertions.assertEquals(expected, threeSum(nums));
*/
    }
}

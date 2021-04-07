package digital.paisley.test.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 */
public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        var lastTwoNumbers = new int[2];
        int k = -1;
        boolean isOdd = (nums1.length + nums2.length) % 2 != 0;
        int k1 = 0;

        while (i + j < (nums1.length + nums2.length) / 2 + 1) {
            if (i < nums1.length && j < nums2.length)
                switch (Integer.compare(nums1[i], nums2[j])) {
                    case 0, -1 -> {
                        k1 = ++k % 2;
                        lastTwoNumbers[k1] = (nums1[i]);
                        i++;
                    }
                    case 1 -> {
                        k1 = ++k % 2;
                        lastTwoNumbers[k1] = (nums2[j]);
                        j++;
                    }
                }
            else if (i < nums1.length) {
                k1 = ++k % 2;
                lastTwoNumbers[k1] = nums1[i];
                i++;
            } else if (j < nums2.length) {
                k1 = ++k % 2;
                lastTwoNumbers[k1] = (nums2[j]);
                j++;
            }
        }
        return isOdd ? lastTwoNumbers[k1] : (lastTwoNumbers[k1] + lastTwoNumbers[++k1 % 2]) / 2.0;
    }

    @Test
    void test() {
        int[] nums1 = new int[]{1, 3}, nums2 = new int[]{2};
        double actual = findMedianSortedArrays(nums1, nums2);
        Assertions.assertEquals(2.00000, actual);

        nums1 = new int[]{1, 2};
        nums2 = new int[]{3, 4};
        actual = findMedianSortedArrays(nums1, nums2);
        Assertions.assertEquals(2.50000, actual);

        nums1 = new int[]{3, 4, 5};
        nums2 = new int[]{1, 2};
        actual = findMedianSortedArrays(nums1, nums2);
        Assertions.assertEquals(3.00000, actual);

        nums1 = new int[]{3, 7, 10};
        nums2 = new int[]{5, 8};
        actual = findMedianSortedArrays(nums1, nums2);
        Assertions.assertEquals(7.00000, actual);

        nums1 = new int[]{3, 7, 10};
        nums2 = new int[]{5, 6};
        actual = findMedianSortedArrays(nums1, nums2);
        Assertions.assertEquals(6.00000, actual);

        nums1 = new int[]{0, 0};
        nums2 = new int[]{0, 0};
        actual = findMedianSortedArrays(nums1, nums2);
        Assertions.assertEquals(0.00000, actual);

        nums1 = new int[]{};
        nums2 = new int[]{1};
        actual = findMedianSortedArrays(nums1, nums2);
        Assertions.assertEquals(1.00000, actual);

        nums1 = new int[]{2};
        nums2 = new int[]{};
        actual = findMedianSortedArrays(nums1, nums2);
        Assertions.assertEquals(2.00000, actual);

        nums1 = new int[]{2, 2, 4, 4};
        nums2 = new int[]{2, 2, 4, 4};
        actual = findMedianSortedArrays(nums1, nums2);
        Assertions.assertEquals(3.00000, actual);
    }
}

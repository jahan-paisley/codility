package digital.paisley.test.codility;

import digital.paisley.test.codility.cutajar.NumberOfDiscIntersectionsAlt;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://app.codility.com/programmers/lessons/6-sorting/number_of_disc_intersections/
 */
public class Solution9DiscIntersection {
    public int solution(int[] A) {
        System.out.println(Arrays.toString(A));

        List<Map.Entry<Integer, Integer>> discs = IntStream.range(0, A.length)
                .boxed()
                .map(i -> Map.entry(i - A[i], A[i] + i))
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toList());
        int totalIntersects = 0;

        for (int i = 0; i < discs.size(); i++) {
            int nextIndex = findIndexGreaterThan(discs.get(i).getValue(), discs, i, discs.size() - 1);
            int discInBetween = nextIndex - i;
            if (nextIndex != -1) {
                totalIntersects += discInBetween;
            }
            if (totalIntersects >= 10_000_000)
                return -1;
        }
        return totalIntersects;
    }

    private int findIndexGreaterThan(int itemEnd, List<Map.Entry<Integer, Integer>> discs, int i, int j) {
        System.out.printf("i=%d, j=%d\n", i, j);
        if (j - i == 1) {
            Integer iStart = discs.get(i).getKey();
            if (itemEnd < iStart)
                return i;
            else {
                Integer jStart = discs.get(j).getKey();
                if (itemEnd < jStart)
                    return j;
                else if (j == discs.size() - 1) {
                    if (itemEnd == jStart)
                        return discs.size() - 1;
                    else return discs.size();
                }
            }
        }

        int middleIndex = (j + i) / 2;
        Integer nextStart = discs.get(middleIndex).getKey();

        if (itemEnd < nextStart) {
            int nextIndex = findIndexGreaterThan(itemEnd, discs, i, middleIndex);
            return Math.min(middleIndex, nextIndex);
        } else {
            if (i == discs.size() - 1)
                if (itemEnd == nextStart)
                    return discs.size() - 1;
                else return discs.size();
            return findIndexGreaterThan(itemEnd, discs, middleIndex + 1, j);
        }
    }

    @Test
    public void test_solution() throws Exception {
        int[] input = {1, 5, 2, 1, 4, 0};
        Assertions.assertEquals(NumberOfDiscIntersectionsAlt.solution(input), solution(input));

        input = new int[]{1, 5, 2, 1, 4, 5};
        Assertions.assertEquals(NumberOfDiscIntersectionsAlt.solution(input), solution(input));

        input = new int[]{1, 1, 1};
        Assertions.assertEquals(NumberOfDiscIntersectionsAlt.solution(input), solution(input));

        input = new int[]{1, 0, 1, 0, 1};
        Assertions.assertEquals(NumberOfDiscIntersectionsAlt.solution(input), solution(input));

        input = new int[]{1, 5, 8, 7, 8, 4, 8, 5, 0, 5};
        Assertions.assertEquals(NumberOfDiscIntersectionsAlt.solution(input), solution(input));

        input = new int[]{3, 3, 3, 5, 1, 2};
        Assertions.assertEquals(NumberOfDiscIntersectionsAlt.solution(input), solution(input));

        input = new int[]{12, 4, 20, 19, 9, 13, 4, 4, 6, 14, 4, 20, 1, 4, 1, 16, 7, 9, 6, 13};
        Assertions.assertEquals(NumberOfDiscIntersectionsAlt.solution(input), solution(input));

        input = new int[]{1, 2147483647, 0};
        Assertions.assertEquals(NumberOfDiscIntersectionsAlt.solution(input), solution(input));

        input = new int[]{2147483647, 2147483647};
        Assertions.assertEquals(NumberOfDiscIntersectionsAlt.solution(input), solution(input));

        input = new int[]{99, 248, 20, 309, 445, 472, 398, 59, 115, 95, 343, 158, 4, 366, 51, 472, 68, 2, 323, 468, 280, 49, 314, 54, 292, 78, 233, 194, 341, 500, 330, 50, 478, 290, 345, 251, 362, 405, 184, 145, 264, 125, 416, 429, 121, 226, 244, 169, 80, 219, 246, 170, 154, 279, 378, 117, 90, 83, 15, 409, 171, 170, 355, 435, 24, 25, 196, 163, 270, 105, 194, 216, 156, 182, 309, 370, 449, 280, 455, 123, 136, 167, 124, 1, 431, 138, 446, 408, 422, 75, 144, 343, 222, 499, 114, 192, 391, 198, 44, 419, 435, 223, 450, 323, 421, 307, 256, 287, 279, 407, 60, 339, 327, 472, 402, 108, 120, 474, 377, 243, 30, 56, 53, 437, 14, 403, 115, 60, 222, 100, 325, 330, 425, 168, 482, 9, 481, 283, 207, 452, 23, 201, 168, 51, 139, 386, 270, 453, 108, 236, 139, 261, 289, 167, 154, 31, 348, 468, 282, 413, 179, 29, 155, 143, 1, 483, 393, 280, 224, 239, 261, 389, 301, 202, 255, 22, 167, 285, 385, 174, 256, 225, 467, 413, 129, 358, 302, 185, 313, 364, 372, 43, 358, 431, 171, 427, 327, 453, 493, 7, 266, 61, 124, 362, 386, 387, 430, 61, 91, 330, 356, 314, 414, 23, 8, 43, 156, 274, 162, 302, 476, 245, 242, 145, 336, 4, 374, 249, 69, 39, 440, 324, 100, 351, 62, 261, 431, 462, 116, 423, 113, 485, 474, 163, 322, 389, 375, 2, 254, 157, 294, 118, 407, 283, 461, 123, 86, 50, 75, 105, 13, 361, 0, 251, 353, 21, 30, 479, 149, 69, 464, 69, 202, 29, 469, 404, 340, 385, 202, 37, 158, 99, 320, 439, 452, 281, 225, 414, 407, 245, 320, 59, 132, 189, 61, 196, 11, 92, 498, 491, 9, 186, 107, 39, 383, 481, 331, 22, 222, 382, 441, 269, 125, 308, 69, 34, 316, 9, 479, 315, 410, 282, 42, 269, 92, 285, 286, 332, 332, 292, 342, 329, 69, 402, 94, 455, 469, 85, 35, 176, 299, 432, 127, 156, 133, 57, 157, 280, 136, 174, 31, 136, 16, 11, 198, 266, 92, 169, 36, 180, 105, 45, 313, 191, 448, 342, 108, 368, 108, 234, 264, 472, 93, 466, 194, 311, 417, 139, 134, 37, 122, 87, 112, 211, 77, 218, 30, 387, 102, 66, 261, 398, 202, 69, 375, 242, 128, 385, 70, 39, 405, 49, 264, 33, 382, 235, 48, 2, 70, 113, 201, 307, 491, 74, 32, 308, 22, 322, 118, 339, 176, 119, 451, 113, 122, 193, 42, 237, 336, 190, 483};
        Assertions.assertEquals(NumberOfDiscIntersectionsAlt.solution(input), solution(input));

        Random random = new Random();
        for (int i = 1; i < 100; i++) {
            int[] array = random.ints(i, i, i + 1).toArray();
            Assertions.assertEquals(NumberOfDiscIntersectionsAlt.solution(array), solution(array));
        }
    }
}
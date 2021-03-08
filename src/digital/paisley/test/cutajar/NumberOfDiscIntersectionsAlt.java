package digital.paisley.test.cutajar;

import java.util.Arrays;

public class NumberOfDiscIntersectionsAlt {
    private static int indexLessThan(Disc[] sortedDiskList, double i, int start, int last) {
        int mid = start + (last - start) / 2;
        if (last <= start && sortedDiskList[mid].start > i)
            return mid - 1;
        if (last <= start)
            return mid;
        if (sortedDiskList[mid].start > i)
            return indexLessThan(sortedDiskList, i, start, mid - 1);
        else
            return indexLessThan(sortedDiskList, i, mid + 1, last);
    }

    public static int solution(int A[]) {
        int len = A.length;
        Disc[] discs = new Disc[len];
        for (int i = 0; i < len; i++) {
            discs[i] = new Disc(i - (long) A[i], i + (long) A[i]);
        }
        Arrays.sort(discs);
        int total = 0;
        for (int i = 0; i < len; i++) {
            total += indexLessThan(discs, discs[i].end + 0.5, 0, len - 1) - i;
            if (total > 10000000) return -1;
        }
        return total;
    }

    static class Disc implements Comparable {
        final long start;
        final long end;

        Disc(long start, long end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Object o) {
            return Long.compare(start, ((Disc) o).start);
        }
    }
}

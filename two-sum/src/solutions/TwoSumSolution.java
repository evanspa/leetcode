package solutions;

import java.util.Map;
import java.util.HashMap;
import org.junit.Assert;

public final class TwoSumSolution {

    // O(n) solution
    public static int[] twoSum(final int values[], final int target) {
        final Map<Integer,Integer> prevIndexes = new HashMap<>();
        final int count = values.length - 1;
        for (int i = 0; i < count; i++) {
            final int diff = target - values[i];
            final Integer prevIndex = prevIndexes.get(diff);
            if (prevIndex != null) {
                return new int[] { prevIndex, i };
            }
            prevIndexes.put(values[i], i);
        }
        return null;
    }

    public static void main(final String args[]) {
        Assert.assertArrayEquals(new int[] { 2, 3 }, twoSum(new int[] { 4, 8, 12, 2, 16 }, 14));
    }
}

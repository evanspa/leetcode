import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;

public final class TwoSumSolution {

    // O(n) solution
    public static int[] twoSum(final int values[], final int target) {
        final Map<Integer,Integer> prevIndexes = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            final int diff = target - values[i];
            final Integer prevIndex = prevIndexes.get(diff);
            if (prevIndex != null) {
                return new int[] { prevIndex, i };
            }
            prevIndexes.put(values[i], i);
        }
        return null;
    }

    // O(n) solution using recursion.
    public static int[] twoSumRec(final int values[], final int target) {
        return twoSumRecSupport(values, 0, target, new HashMap<Integer,Integer>());
    }

    private static int[] twoSumRecSupport(final int values[], final int index, final int target, final Map<Integer,Integer> prevIndexes) {
        if (index < values.length) {
            final int diff = target - values[index];
            final Integer prevIndex = prevIndexes.get(diff);
            if (prevIndex != null) {
                return new int[] { prevIndex, index };
            } else {
                prevIndexes.put(values[index], index);
                return twoSumRecSupport(values, index + 1, target, prevIndexes);
            }
        }
        return null;
    }

    public static void main(final String args[]) {
        Assert.assertArrayEquals(new int[] { 2, 3 }, twoSum(new int[] { 4, 8, 12, 2, 16 }, 14));
        Assert.assertArrayEquals(new int[] { 2, 3 }, twoSumRec(new int[] { 4, 8, 12, 2, 16 }, 14));
        Assert.assertArrayEquals(new int[] { 3, 4 }, twoSum(new int[] { 4, 8, 12, 2, 16 }, 18));
        Assert.assertArrayEquals(new int[] { 3, 4 }, twoSumRec(new int[] { 4, 8, 12, 2, 16 }, 18));
        Assert.assertNull(twoSum(new int[] { 4, 8, 12, 2, 16 }, 83));
        Assert.assertNull(twoSumRec(new int[] { 4, 8, 12, 2, 16 }, 83));
        Assert.assertArrayEquals(new int[] { 0, 1 }, twoSum(new int[] { 4, 8, 12, 2, 16 }, 12));
        Assert.assertArrayEquals(new int[] { 0, 1 }, twoSumRec(new int[] { 4, 8, 12, 2, 16 }, 12));
        Assert.assertArrayEquals(new int[] { 0, 5 }, twoSumRec(new int[] { 4, 8, 12, 2, 16, 17 }, 21));
    }
}

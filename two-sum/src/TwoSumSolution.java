// Given an array of integers, return indices of the two numbers such that they add up to a specific target.
//
//     You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//     Example:
//
//     Given nums = [2, 7, 11, 15], target = 9,
//
//     Because nums[0] + nums[1] = 2 + 7 = 9,
//     return [0, 1].

import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;

public final class TwoSumSolution {

    // O(n) solution
    public static int[] twoSum(final int values[], final int target) {
        final Map<Integer,Integer> complements = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            final int complement = target - values[i];
            final Integer foundComplement = complements.get(complement);
            if (foundComplement != null) {
                return new int[] { foundComplement, i };
            }
            complements.put(values[i], i);
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

    // O(n^2) solution (but uses less memory).
    public static final int[] twoSumSlow(final int[] nums, final int target) {
        final int outerCount = nums.length - 1;
        for (int i = 0; i < outerCount; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return null;
    }

    public static void main(final String args[]) {
        Assert.assertArrayEquals(new int[] { 2, 3 }, twoSum(new int[] { 4, 8, 12, 2, 16 }, 14));
        Assert.assertArrayEquals(new int[] { 3, 4 }, twoSum(new int[] { 4, 8, 12, 2, 16 }, 18));
        Assert.assertNull(twoSum(new int[] { 4, 8, 12, 2, 16 }, 83));
        Assert.assertArrayEquals(new int[] { 0, 1 }, twoSum(new int[] { 4, 8, 12, 2, 16 }, 12));
        Assert.assertArrayEquals(new int[] { 0, 5 }, twoSum(new int[] { 4, 8, 12, 2, 16, 17 }, 21));

        Assert.assertArrayEquals(new int[] { 2, 3 }, twoSumRec(new int[] { 4, 8, 12, 2, 16 }, 14));
        Assert.assertArrayEquals(new int[] { 3, 4 }, twoSumRec(new int[] { 4, 8, 12, 2, 16 }, 18));
        Assert.assertNull(twoSumRec(new int[] { 4, 8, 12, 2, 16 }, 83));
        Assert.assertArrayEquals(new int[] { 0, 1 }, twoSumRec(new int[] { 4, 8, 12, 2, 16 }, 12));
        Assert.assertArrayEquals(new int[] { 0, 5 }, twoSumRec(new int[] { 4, 8, 12, 2, 16, 17 }, 21));

        Assert.assertArrayEquals(new int[] { 2, 3 }, twoSumSlow(new int[] { 4, 8, 12, 2, 16 }, 14));
        Assert.assertArrayEquals(new int[] { 3, 4 }, twoSumSlow(new int[] { 4, 8, 12, 2, 16 }, 18));
        Assert.assertNull(twoSumRec(new int[] { 4, 8, 12, 2, 16 }, 83));
        Assert.assertArrayEquals(new int[] { 0, 1 }, twoSumSlow(new int[] { 4, 8, 12, 2, 16 }, 12));
        Assert.assertArrayEquals(new int[] { 0, 5 }, twoSumSlow(new int[] { 4, 8, 12, 2, 16, 17 }, 21));
    }
}

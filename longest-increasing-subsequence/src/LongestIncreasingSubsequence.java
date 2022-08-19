import org.junit.Assert;

public final class LongestIncreasingSubsequence {

    public static final int lengthOfLis(final int nums[]) {
        final int lengths[] = new int[nums.length];
        for (int i = 0; i < lengths.length; i++) {
            lengths[i] = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (lengths[i] <= lengths[j]) {
                        lengths[i] = lengths[j] + 1;
                    }
                }
            }
        }
        int max = lengths[0];
        for (int i = 1; i < lengths.length; i++) {
            if (lengths[i] > max) {
                max = lengths[i];
            }
        }
        return max;
    }

    public static void main(final String args[]) {
        Assert.assertEquals(4, lengthOfLis(new int[] { 10,9,2,5,3,7,101,18 }));
        Assert.assertEquals(4, lengthOfLis(new int[] { 0,1,0,3,2,3 }));
        Assert.assertEquals(1, lengthOfLis(new int[] { 7,7,7,7,7,7,7 }));
    }
}

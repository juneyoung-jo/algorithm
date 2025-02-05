package leetcode;

public class E_1800 {
    public int maxAscendingSum(int[] nums) {
        int result = nums[0];
        int current = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                current += nums[i];
            } else {
                current = nums[i];
            }

            if (result < current) {
                result = current;
            }
        }
        return result;
    }
}

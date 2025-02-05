package leetcode;

import java.util.HashMap;
import java.util.Map;

public class E_1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }

        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i]) &&
                    map.get(target - nums[i]) != i) {
                result[0] = i;
                result[1] = map.get(target - nums[i]);
                break;
            }
        }

        return result;
    }
}

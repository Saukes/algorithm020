package daily;

import java.util.Arrays;

public class HomeWork03MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];

    }
}

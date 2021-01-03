package daily;

public class HomeWork01Rob {
    public int rob(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        return Math.max(robRange(nums, 0, length - 2),
                robRange(nums, 1, length - 1));
    }

    private int robRange(int[] nums, int begin, int end){
        int pre1 = 0;
        int pre2 = 0;
        int curMax = 0;
        for (int i = begin; i <= end; i++) {
            curMax = Math.max(pre1, pre2 + nums[i]);
            pre2 = pre1;
            pre1 = curMax;
        }
        return curMax;
    }
}

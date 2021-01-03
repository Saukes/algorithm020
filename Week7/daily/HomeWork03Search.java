package daily;

public class HomeWork03Search {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo)/2;
            if (nums[mid] == target) {
                return mid;
            }
            if (target >= nums[0]) {
                if (nums[mid] < nums[0]) {
                    nums[mid] = Integer.MAX_VALUE;
                }
            } else {
                if (nums[mid] >= nums[0]) {
                    nums[mid] = Integer.MIN_VALUE;
                }
            }
            if (nums[mid] < target) {
                lo = mid + 1;
            }else {
                hi = mid -1;
            }
        }
        return -1;
    }
}

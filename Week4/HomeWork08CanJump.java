public class HomeWork08CanJump {
    public boolean canJump(int[] nums) {
        int length = nums.length;
        int rightmost = 0;
        for (int i = 0; i < length; i++) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= length - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}

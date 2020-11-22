public class HomeWork06MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <=1) {
            return;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=0) {
                if (i >index) {
                    nums[index] = nums[i];
                    nums[i] =0;
                }
                index++;
            }
        }
    }
}

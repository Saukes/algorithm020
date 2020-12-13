public class HomeWork11Jump {
    public int jump(int[] nums) {
        int end = 0;
        int maxPosittion = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosittion = Math.max(maxPosittion, nums[i] + i);
            if (i == end) {
                end = maxPosittion;
                steps++;
            }
        }
        return steps;
    }
}

public class HomeWork02Rotate {
    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        //
        int count = 0;
        for (int i = 0; count < len; i++) {
            int current = i;
            int prev = nums[i];
            do {
                int next = (current + k) % len;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;

                current = next;
                count++;
            } while (i != current);
        }
    }
}

import java.util.Deque;
import java.util.LinkedList;

public class HomeWork06MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k < 1 || nums.length < k) {
            return new int[0];
        }
        int index = 0;
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
            if (deque.peekFirst() == (i-k)) {
                deque.pollFirst();
            }
            if (i>=(k-1)) {
                res[index++] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}

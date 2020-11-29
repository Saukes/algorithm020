import java.util.PriorityQueue;
import java.util.Queue;

public class HomeWork14NthUglyNumber {
    public int nthUglyNumber(int n) {
        int[] uglyNumber = {2, 3, 5};
        Queue<Long> queue = new PriorityQueue<>();
        queue.add(1L);
        int count = 0;
        while (!queue.isEmpty()) {
            long cur = queue.poll();
            if (++count >= n) {
                return (int) cur;
            }
            for (int num : uglyNumber) {
                if (!queue.contains(num * cur)) {
                    queue.add(num * cur);
                }
            }
        }
        return -1;
    }
}

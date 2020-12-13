package daily;

import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HomeWork05Permute {
    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int[] visited = new int[nums.length];
        backTrack(res, nums, new ArrayList<>(), visited);
        return res;
    }

    private void backTrack(List<List<Integer>> res, int[] nums,
                           List<Integer> tmp, int[] visited) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) {
                continue;
            }
            visited[i] = 1;
            tmp.add(nums[i]);
            backTrack(res, nums, tmp, visited);
            visited[i] = 0;
            tmp.remove(tmp.size() - 1);
        }
    }

    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int num : nums) {
            queue.offer(num);
        }

        return res;
    }

    private void dfs(List<List<Integer>> res, Queue<Integer> queue, LinkedList<Integer> arr) {
        if (queue.isEmpty()) {
            res.add(new LinkedList<>(arr));
            return;
        }
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            arr.add(queue.poll());
            dfs(res, queue, arr);
            queue.offer(arr.removeLast());
        }

    }

    public List<List<Integer>> permute3(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int[] visited = new int[nums.length];
        dfs(res, nums, new ArrayList<>(), visited);
        return res;
    }

    public void dfs(List<List<Integer>> res, int[] nums,
                    List<Integer> tmp, int[] visited) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) {
                continue;
            }
            visited[i] = 1;
            tmp.add(nums[i]);
            dfs(res, nums, tmp, visited);
            visited[i] = 0;
            tmp.remove(tmp.size() - 1);
        }

    }

}

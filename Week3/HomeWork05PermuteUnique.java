import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeWork05PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int[] visited = new int[nums.length];
        Arrays.sort(nums);
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
            if (visited[i] == 1 || (i > 0 && nums[i] == nums[i - 1] && visited[i-1]!=1)) {
                continue;
            }
            visited[i] = 1;
            tmp.add(nums[i]);
            backTrack(res, nums, tmp, visited);
            visited[i] = 0;
            tmp.remove(tmp.size() - 1);
        }
    }
}

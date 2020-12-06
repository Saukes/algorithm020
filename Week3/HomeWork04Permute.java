import java.util.ArrayList;
import java.util.List;

public class HomeWork04Permute {
    public List<List<Integer>> permute(int[] nums) {
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
            System.out.println("  递归之前 => " + tmp);
            backTrack(res, nums, tmp, visited);
            visited[i]=0;
            tmp.remove(tmp.size() - 1);
            System.out.println("递归之后 => " + tmp);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        HomeWork04Permute permute = new HomeWork04Permute();
        List<List<Integer>> reuslt = permute.permute(nums);
        System.out.println(reuslt);
    }
}

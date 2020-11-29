import data.Node;

import java.util.*;

public class HomeWork13LevelOrder {
    public List<List<Integer>> levelOrder1(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> list = new ArrayList<>();
            while (count-- > 0) {
                Node cur = queue.poll();
                if (cur == null) {
                    continue;
                }
                list.add(cur.val);
                for (Node node : cur.children) {
                    if (node != null) {
                        queue.add(node);
                    }
                }

            }
            res.add(list);
        }
        return res;
    }

    public List<List<Integer>> levelOrder2(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        helper(root, 0, res);
        return res;
    }

    private void helper(Node root, int depth, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        if (depth + 1 > res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(depth).add(root.val);
        for (Node node : root.children) {
            if (node != null) {
                helper(node, depth + 1, res);
            }
        }
    }

}

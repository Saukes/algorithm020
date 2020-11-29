import data.Node;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class HomeWork09Preorder {

    public List<Integer> preorder2(Node root) {
        List<Integer> res = new ArrayList<>();
        Deque<Node> stack = new LinkedList<>();
        if (root!=null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.add(node.val);
            for (int i = node.children.size() - 1; i >= 0; --i) {
                stack.push(node.children.get(i));
            }

        }
        return res;
    }

    public List<Integer> preorder1(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        helper(root, res);
        return res;
    }

    private void helper(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        List<Node> children = root.children;
        for (Node child : children) {
            helper(child, res);
        }
    }
}

package daily;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class TrieNode {
    public String val;
    public TrieNode[] child = new TrieNode[26];
    public boolean isLeaf = false;

    TrieNode() {
    }
}

class WordTrie {
    public TrieNode root = new TrieNode();

    public void insert(String s) {
        TrieNode cur = root;
        for (char c : s.toCharArray()) {
            if (cur.child[c - 'a'] == null) {
                cur.child[c - 'a'] = new TrieNode();
                cur = cur.child[c - 'a'];
            } else {
                cur = cur.child[c - 'a'];
            }
        }
        cur.isLeaf = true;
        cur.val = s;
    }
}

public class HomeWork04FindWords {
    public List<String> findWords(char[][] board, String[] words) {
        WordTrie myTrie = new WordTrie();
        TrieNode root = myTrie.root;
        for (String s : words) {
            myTrie.insert(s);
        }
        Set<String> result = new HashSet<>();
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                find(board, visited, i, j, m, n, result, root);
            }
        }
        return new LinkedList<>(result);
    }

    private void find(char[][] board, boolean[][] visited,
                      int i, int j, int m,
                      int n, Set<String> result, TrieNode cur) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) {
            return;
        }
        cur = cur.child[board[i][j] - 'a'];
        visited[i][j] = true;
        if (cur == null) {
            visited[i][j] = false;
            return;
        }
        if (cur.isLeaf) {
            result.add(cur.val);
        }
        find(board, visited, i + 1, j, m, n, result, cur);
        find(board, visited, i, j + 1, m, n, result, cur);
        find(board, visited, i, j - 1, m, n, result, cur);
        find(board, visited, i - 1, j, m, n, result, cur);
        visited[i][j] = false;
    }
}

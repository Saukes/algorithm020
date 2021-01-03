package model;

public class Trie3 {
    private boolean isEnd;
    private final Trie3[] next;
    public Trie3() {
        isEnd = false;
        next = new Trie3[26];
    }

    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        Trie3 curr = this;
        char[] words = word.toCharArray();
        for (int i = 0; i < words.length; i++) {
            int n = words[i] - 'a';
            if (curr.next[n] == null) {
                curr.next[n] = new Trie3();
            }
            curr = curr.next[n];
        }
        curr.isEnd = true;
    }

    public boolean search(String word){
        Trie3 node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie3 node = searchPrefix(prefix);
        return node != null;
    }

    private Trie3 searchPrefix(String word) {
        Trie3 node = this;
        char[] words = word.toCharArray();
        for (int i = 0; i < words.length; i++) {
            node = node.next[words[i] - 'a'];
            if (node == null) {
                return null;
            }
        }
        return node;
    }
}

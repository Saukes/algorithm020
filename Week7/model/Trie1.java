package model;

public class Trie1 {
    private boolean is_string = false;
    private final Trie1[] next = new Trie1[26];

    public Trie1() {
    }

    public void insert(String word) {
        Trie1 root = this;
        char[] w = word.toCharArray();
        for (int i = 0; i < w.length; ++i) {
            if (root.next[w[i]-'a'] == null) {
                root.next[w[i] - 'a'] = new Trie1();
            }
            root = root.next[w[i] - 'a'];
        }
        root.is_string = true;
    }

    public boolean search(String word){
        Trie1 root = this;
        char[] w = word.toCharArray();
        for (int i = 0; i < w.length; i++) {
            if (root.next[w[i]-'a'] == null) {
                return false;
            }
            root = root.next[w[i] - 'a'];
        }
        return root.is_string;
    }

    public boolean startsWith(String prefix){
        Trie1 root = this;
        char[] p = prefix.toCharArray();
        for (int i = 0; i < p.length; i++) {
            if (root.next[p[i]-'a']  == null) {
                return false;
            }
            root = root.next[p[i] - 'a'];
        }
        return true;
    }

}

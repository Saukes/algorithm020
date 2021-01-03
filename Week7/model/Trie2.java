package model;


import java.util.TreeMap;

public class Trie2 {

    private final Node root;

    private class Node {
        private final TreeMap<Character, Node> next;
        private boolean isWord;
        public Node(boolean isWord){
            this.next = new TreeMap<>();
            this.isWord = isWord;
        }
        public Node() {
            this(false);
        }
    }
    public Trie2() {
        root = new Node();
    }

    public void insert(String word){
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            cur.next.putIfAbsent(c, new Node());
            cur = cur.next.get(c);
        }
        if (!cur.isWord) {
            cur.isWord = true;
        }
    }

    public boolean search(String word){
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.next.containsKey(c)) {
                return false;
            } else {
                cur = cur.next.get(c);
            }
        }
        return cur.isWord;
    }

    public boolean startsWith(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (!cur.next.containsKey(prefix.charAt(i))) {
                return false;
            } else {
                cur = cur.next.get(prefix.charAt(i));
            }
        }
        return true;
    }
}

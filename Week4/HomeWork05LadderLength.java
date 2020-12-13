import java.util.*;

public class HomeWork05LadderLength {
    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        Set<String> dictSet = new HashSet<>(wordList);
        Set<String> visit = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int minLen = 1;
        while (!queue.isEmpty()) {
            int levelCount = queue.size();
            for (int i = 0; i < levelCount; i++) {
                String word = queue.poll();
                for (int j = 0; j < word.length(); j++) {
                    char[] ch = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == word.charAt(j)) {
                            continue;
                        }
                        ch[j] = c;
                        String newWord = String.valueOf(ch);
                        if (dictSet.contains(newWord) && visit.add(newWord)) {
                            if (newWord.equals(endWord)) {
                                return minLen + 1;
                            }
                            queue.add(newWord);
                        }
                    }
                }
            }
            minLen++;
        }
        return 0;
    }

    public int ladderLength12(String beginWord, String endWord, List<String> wordList) {
        int end = wordList.indexOf(endWord);
        if (end == -1) {
            return 0;
        }
        wordList.add(beginWord);

        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();

        Set<String> visited1 = new HashSet<>();
        Set<String> visited2 = new HashSet<>();

        queue1.offer(beginWord);
        queue2.offer(endWord);
        visited1.add(beginWord);
        visited2.add(endWord);

        int count = 0;
        Set<String> allWordSet = new HashSet<>(wordList);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            count++;
            if (queue1.size() > queue2.size()) {
                Queue<String> tmp = queue1;
                queue1 = queue2;
                queue2 = tmp;
                Set<String> t = visited1;
                visited1 = visited2;
                visited2 = t;
            }
            int size1 = queue1.size();
            while (size1-- > 0) {
                String s = queue1.poll();
                char[] chars = s.toCharArray();
                for (int i = 0; i < s.length(); ++i) {
                    char c0 = chars[i];
                    for (char c = 'a'; c <= 'z'; ++c) {
                        chars[i] = c;
                        String newString = String.valueOf(chars);
                        if (visited1.contains(newString)) {
                            continue;
                        }
                        if (visited2.contains(newString)) {
                            return count + 1;
                        }
                        if (allWordSet.contains(newString)) {
                            queue1.offer(newString);
                            visited1.add(newString);
                        }
                    }
                    chars[i] = c0;
                }
            }
        }
        return 0;
    }
}

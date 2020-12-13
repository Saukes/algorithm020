import java.util.*;

public class HomeWork10FindLadders {
    public List<List<String>> findLadders1(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> distSet = new HashSet<>(wordList);
        if (!distSet.contains(endWord)) {
            return res;
        }
        Set<String> visited = new HashSet<>();
        Queue<List<String>> queue = new LinkedList<>();
        List<String> list = new ArrayList<>(Arrays.asList(beginWord));
        queue.add(list);
        visited.add(beginWord);
        boolean flag = false;
        while (!queue.isEmpty() && !flag) {
            int size = queue.size();
            Set<String> subVisited = new HashSet<>();
            for (int i = 0; i < size; i++) {
                List<String> path = queue.poll();
                String word = path.get(path.size() - 1);
                char[] chars = word.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char temp = chars[j];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[j] = ch;
                        if (temp == ch) {
                            continue;
                        }
                        String str = String.valueOf(chars);
                        if (distSet.contains(str) && !visited.contains(str)) {
                            List<String> pathList = new ArrayList<>(path);
                            pathList.add(str);
                            if (str.equals(endWord)) {
                                flag = true;
                                res.add(pathList);
                            }
                            queue.add(pathList);
                            subVisited.add(str);
                        }
                    }
                    chars[j] = temp;
                }
            }
            visited.addAll(subVisited);
        }
        return res;
    }

    public List<List<String>> findLadders2(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) {
            return res;
        }
        Map<String, List<String>> mapTree = new HashMap<>();
        Set<String> begin = new HashSet<>();
        Set<String> end = new HashSet<>();
        begin.add(beginWord);
        end.add(endWord);
        if (buildTree(words, begin, end, mapTree, true)) {
            dfs(res, mapTree, beginWord, endWord, new LinkedList<>());
        }
        return res;
    }

    private boolean buildTree(Set<String> words, Set<String> begin,
                              Set<String> end, Map<String, List<String>> mapTree, boolean isFront) {
        if (begin.size() == 0) {
            return false;
        }
        if (begin.size() > end.size()) {
            return buildTree(words, end, begin, mapTree, !isFront);
        }
        words.removeAll(begin);
        boolean isMeet = false;
        Set<String> nextLevel = new HashSet<>();
        for (String word : begin) {
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char temp = chars[i];
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    chars[i] = ch;
                    String str = String.valueOf(chars);
                    if (words.contains(str)) {
                        nextLevel.add(str);
                        String key = isFront ? word : str;
                        String nextWord = isFront ? str : word;
                        if (end.contains(str)) {
                            isMeet = true;
                        }
                        if (!mapTree.containsKey(key)) {
                            mapTree.put(key, new ArrayList<>());
                        }
                        mapTree.get(key).add(nextWord);
                    }
                }
                chars[i] = temp;
            }
        }
        if (isMeet) {
            return true;
        }
        return buildTree(words, nextLevel, end, mapTree, isFront);
    }

    private void dfs(List<List<String>> res, Map<String, List<String>> mapTree,
                     String beginWord, String endWord, LinkedList<String> list) {
        list.add(beginWord);
        if (beginWord.equals(endWord)) {
            res.add(new ArrayList<>(list));
            list.removeLast();
            return;
        }
        if (mapTree.containsKey(beginWord)) {
            for (String word : mapTree.get(beginWord)) {
                dfs(res, mapTree, word, endWord, list);
            }
        }
        list.removeLast();
    }
}

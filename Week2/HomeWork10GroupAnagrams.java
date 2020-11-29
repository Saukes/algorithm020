
import java.util.*;


public class HomeWork10GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String value : strs) {
            char[] str = value.toCharArray();
            Arrays.sort(str);
            String s = String.valueOf(str);
            if (!map.containsKey(s)) {
                map.put(s, new ArrayList<>());
            }
            map.get(s).add(value);
        }
        return new ArrayList<>(map.values());
    }

}

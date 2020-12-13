package daily;

import java.util.HashMap;
import java.util.Map;

public class HomeWork06Fib {
    private final Map<Integer, Integer> map = new HashMap<>();
    public int fib(int N) {
        int res = 0;
        if (N <= 1) {
            return N;
        }
        if (map.get(N) != null) {
            return map.get(N);
        }
        res = fib(N - 1) + fib(N - 2);
        map.put(N, res);
        return res;
    }
}

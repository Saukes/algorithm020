package daily;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class HomeWork01FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String str;
            if (i % 3 == 0 && i % 5 == 0) {
                str = "FizzBuzz";

            } else if (i % 3 == 0) {
                str = "Fizz";
            } else if (i % 5 == 0) {
                str = "Buzz";
            } else {
                str = String.valueOf(i);
            }
            res.add(str);
        }
        return res;
    }

    public List<String> fizzBuzz2(int n) {
        return new AbstractList<String>() {
            @Override
            public String get(int i) {
                ++i;
                switch ((i%3==0?1:0)+(i%5==0?2:0)){
                    case 0:return Integer.toString(i);
                    case 1:return "Fizz";
                    case 2:return "Buzz";
                    case 3:return "FizzBuzz";
                }
                return "";
            }

            @Override
            public int size() {
                return n;
            }
        };
    }
}

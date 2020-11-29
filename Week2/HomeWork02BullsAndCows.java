public class HomeWork02BullsAndCows {
    public String getHint(String secret, String guess) {
        int len = secret.length();
        int[] cache = new int[10];
        int x = 0, y = 0;
        for (int i = 0; i < len; i++) {
            char cs = secret.charAt(i);
            char gs = guess.charAt(i);
            if (cs == gs) {
                x++;
            } else {
                if (cache[cs - '0']++ < 0) {
                    y++;
                }
                if (cache[gs - '0']-- > 0) {
                    y++;
                }
            }

        }
        return x + "A" + y + "B";
    }
}

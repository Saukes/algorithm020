package daily;

public class HomeWork04IsPerfectSquare {
    public boolean isPerfectSquare1(int num) {
        if (num < 2) {
            return true;
        }
        long left = 2, right = num / 2, x, guessSquared;
        while (left <= right) {
            x = left + (right - left) / 2;
            guessSquared = x * x;
            if (guessSquared == num) {
                return true;
            }
            if (guessSquared > num) {
                right = x - 1;
            } else {
                left = x + 1;
            }
        }
        return false;
    }

    public boolean isPerfectSquare2(int num) {
        if (num == 1) {
            return true;
        }
        int i = num / 2;
        while ((double) i * i > num) {
            i = (i + num / i) / 2;
        }
        return i * i == num;

    }
}

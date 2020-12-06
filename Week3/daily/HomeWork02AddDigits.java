package daily;

public class HomeWork02AddDigits {
    public int addDigits1(int num) {
        return (num - 1) % 9 + 1;
    }

    public int addDigits2(int num) {
        if (num >= 0 && num <= 9) {
            return num;
        }
        int sum = 0;
        String[] numStrs = String.valueOf(num).split("");
        for (int i = 0; i < numStrs.length; i++) {
            sum += Integer.parseInt(numStrs[i]);
        }
        num = sum;
        return addDigits2(num);
    }
}

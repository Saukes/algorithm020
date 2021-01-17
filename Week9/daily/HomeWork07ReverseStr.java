package daily;

public class HomeWork07ReverseStr {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i += (k * 2)) {
            revser(chars, i, Math.min(i + k - 1, chars.length - 1));
        }
        return String.valueOf(chars);
    }

    private void revser(char[] chars, int i, int j) {
        for (int k = i; k < j; k++) {
            char temp = chars[k];
            chars[k] = chars[j];
            chars[j] = temp;
            j--;
        }
    }
}

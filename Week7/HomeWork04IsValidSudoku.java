import java.util.HashSet;

public class HomeWork04IsValidSudoku {
    private final int N = 9;

    public boolean isValidSudoku(char[][] board) {
        HashSet<Integer>[] rows = new HashSet[N];
        HashSet<Integer>[] cols = new HashSet[N];
        HashSet<Integer>[] boxes = new HashSet[N];
        for (int i = 0; i < N; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int tmp = board[i][j] - '0';
                if (rows[i].contains(tmp) || cols[j].contains(tmp) ||
                        boxes[(i / 3) * 3 + j / 3].contains(tmp)) {
                    return false;
                }
                rows[i].add(tmp);
                cols[j].add(tmp);
                boxes[(i / 3) * 3 + j / 3].add(tmp);
            }
        }
        return true;
    }
}

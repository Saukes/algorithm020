import java.util.LinkedList;
import java.util.Queue;

public class HomeWork07UpdateBoard {
    int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
    int[] dy = {0, 0, -1, 1, -1, 1, 1, -1};

    public char[][] updateBoard1(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
        } else {
            dfs(board, x, y);
        }
        return board;
    }

    private void dfs(char[][] board, int i, int j) {
        int cnt = 0;
        for (int k = 0; k < 8; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
                continue;
            }
            if (board[x][y] == 'M') {
                cnt++;
            }
        }
        if (cnt > 0) {
            board[i][j] = (char) (cnt + '0');
            return;
        }
        board[i][j] = 'B';
        for (int k = 0; k < 8; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'E') {
                continue;
            }
            dfs(board, x, y);
        }
    }

    public char[][] updateBoard2(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        visited[x][y] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int i = point[0], j = point[1];
            int cnt = 0;
            for (int k = 0; k < 8; k++) {
                int newX = i + dx[k];
                int newY = j + dy[k];
                if (newX < 0 || newX >= board.length ||
                        newY < 0 || newY >= board[0].length) {
                    continue;
                }
                if (board[newX][newY] == 'M') {
                    cnt++;
                }
            }
            if (cnt > 0) {
                board[i][j] = (char) (cnt + '0');
            } else {
                board[i][j] = 'B';
                for (int k = 0; k < 8; k++) {
                    int newX = i + dx[k];
                    int newY = j + dy[k];
                    if (newX < 0 || newX >= board.length ||
                            newY < 0 || newY >= board[0].length ||
                            board[newX][newY] != 'E' || visited[newX][newY]) {
                        continue;
                    }
                    visited[newX][newY] = true;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
        return board;
    }
}

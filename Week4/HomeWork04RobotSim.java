import java.util.HashSet;
import java.util.Set;

public class HomeWork04RobotSim {
    public int robotSim(int[] commands, int[][] obstacles) {
        int result = 0;
        int x = 0, y = 0, direction = 0;

        int[] directx = new int[]{0, 1, 0, -1};
        int[] directy = new int[]{1, 0, -1, 0};

        Set<String> obstaclesSet = new HashSet<>();
        for (int i = 0; i < obstacles.length; i++) {
            obstaclesSet.add(obstacles[i][0] + "," + obstacles[i][1]);
        }
        for (int command : commands) {
            if (command == -2) {
                direction = (direction + 3) % 4;
            } else if (command == -1) {
                direction = (direction + 1) % 4;
            } else {
                for (int i = 1; i <= command; i++) {
                    int newX = x + directx[direction];
                    int newY = y + directy[direction];
                    if (obstaclesSet.contains(newX +","+ newY)) {
                        break;
                    }
                    x = newX;
                    y = newY;
                    result = Math.max(result, x * x + y * y);
                }
            }
        }
        return result;

    }
}

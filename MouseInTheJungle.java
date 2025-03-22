public class MouseInTheJungle {
    static int[][] jungle = {
            {0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 1, 0, 0, 0, 0},
            {1, 1, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 1, 0, 1, 0, 0, 1},
            {0, 0, 0, 0, 1, 0, 0, 0}
    };
    static int[][] sol = new int[jungle.length][jungle[0].length];
    public static void main(String[] args) {
        int targetX = 7, targetY = 7; 
        if (findFood(jungle, 0, 0, targetX, targetY)) {
            for (int i = 0; i < sol.length; i++) {
                for (int j = 0; j < sol[0].length; j++) {
                    System.out.print(sol[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("No path found.");
        }
    }
    public static boolean findFood(int[][] jungle, int x, int y, int targetX, int targetY) {
        if (x == targetX && y == targetY) {
            sol[x][y] = 1;
            return true;
        }
        if (x >= 0 && y >= 0 && x < jungle.length && y < jungle[0].length && jungle[x][y] != 1 && sol[x][y] != 1) {
            sol[x][y] = 1;
            if (findFood(jungle, x + 1, y, targetX, targetY) ||
            findFood(jungle, x, y + 1, targetX, targetY) ||
            findFood(jungle, x - 1, y, targetX, targetY) ||
            findFood(jungle, x, y - 1, targetX, targetY)) {
                return true;
            }
            sol[x][y] = 0; 
        }
        return false;
    }
}

import java.awt.Point;
import java.util.Set;
import java.util.HashSet;

public class BlobPerimeter {
    public static void main(String[] args) {
        int[][] grid = new int[3][3];
        grid[1][1] = 5;
        int sum = findSumOfPerimeters(grid);
        System.out.println(sum);
        System.out.println(sum == 8);
    }
    
    public static int findSumOfPerimeters(int[][] grid) {
        HashSet<Point> visited = new HashSet<>();
        int perimeter = findPerimeter(grid, 0, 0, visited);
        for (int x = 0; x < grid.length; x++){
            for (int y = 0; y < grid[0].length; y++){
                if (!visited.contains(new Point(x, y))) {
                    perimeter += findPerimeter(grid, x, y, visited);
                }
            }
        }
        return perimeter;
    }
    
    private static int[] dr = {1, 0, -1, 0};
    private static int[] dc = {0, 1, 0, -1};

    public static boolean isValid(int[][] grid, int row, int col) {
        return  !(grid == null || row < 0 || col < 0 || row >= grid.length || col >= grid[0].length);
    }
    
    public static int findPerimeter(int[][] grid, int row, int col, HashSet<Point> visited) {
        if (!isValid(grid, row, col)) {
            return 0;
        }
        visited.add(new Point(row, col));
        int currentSum = 0;
        for (int i = 0; i < 4; i++) {
            int curRow = row + dr[i];
            int curCol = col + dc[i];
            if (isValid(grid, curRow, curCol)  ) {
                if (grid[curRow][curCol] != grid[row][col]) {
                    currentSum++;
                } else if (!visited.contains(new Point(curRow, curCol))) {
                    currentSum += findPerimeter(grid, curRow, curCol, visited);
                }
            }
        }
        return currentSum;
    }
}
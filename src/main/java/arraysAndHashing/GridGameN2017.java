package arraysAndHashing;

import java.util.Arrays;

public class GridGameN2017 {

    public long gridGame(int[][] grid) {
        long robot2Points = Long.MAX_VALUE;
        long[][] prefixSumGrid = new long[2][grid[0].length];
        prefixSumGrid[0][grid[0].length-1] = grid[0][grid[0].length-1];
        prefixSumGrid[1][0] = grid[1][0];

        for(int i = grid[0].length-2; i>=0; i--){
            prefixSumGrid[0][i] = prefixSumGrid[0][i+1]+grid[0][i];
        }
        for(int i = 1; i < grid[0].length; i++){
            prefixSumGrid[1][i] = prefixSumGrid[1][i-1]+grid[1][i];
        }
        long currentMaxPoint;
        for(int i = 0; i < grid[0].length; i++){
            currentMaxPoint = Math.max(
                    (i-1 < 0 ? 0: prefixSumGrid[1][i-1]),
                    (i+1 == grid[0].length ? 0 : prefixSumGrid[0][i+1]));
        robot2Points = Math.min(currentMaxPoint,robot2Points);
        }
        return robot2Points;

    }
    public long gridGame2(int[][] g) {
        long top = Arrays.stream(g[0]).asLongStream().sum(), bottom = 0, res = Long.MAX_VALUE;
        for(int i = 0; i < g[0].length; ++i) {
            top -= g[0][i];
            res = Math.min(res, Math.max(top, bottom));
            bottom += g[1][i];
        }
        return res;
    }

}

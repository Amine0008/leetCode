package arraysAndHashing;

public class RangeSumQuery2DImmutableN304 {

    class NumMatrix {
        int[][] dp;
        public NumMatrix(int[][] matrix) {
            dp = new int[matrix.length+1][matrix[0].length+1];
            for(int i = 1; i < dp.length; i++) {
                for(int j = 1; j < dp[0].length; j++){
                    dp[i][j] = matrix[i-1][j-1] + dp[i-1][j] +dp[i][j-1]- dp[i-1][j-1];
                }
            }
        }
        public int sumRegion(int row1, int col1, int row2, int col2) {
            row1++;col1++;row2++;col2++;
            return dp[row2][col2] - dp[row1-1][col2] - dp[row2][col1-1]+ dp[row1 -1][col1 -1];

        }
    }
}

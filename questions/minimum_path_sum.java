package questions;

import java.util.Arrays;

public class minimum_path_sum {
    public int minPathSum(int[][] grid){
        if(grid == null || grid.length == 0){
            return 0;
        }
        int r_len = grid.length, c_len = grid[0].length;
        int[] dp = new int[c_len];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0; i < r_len; i++){
            for(int j = 0; j < c_len; j++){
                if(j == 0) dp[j] += grid[i][j];
                else dp[j] = grid[i][j] + Math.min(dp[j], dp[j-1]);
            }
        }
        return dp[c_len-1];
    }
}
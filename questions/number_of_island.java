package questions;

import java.util.LinkedList;
import java.util.Queue;

public class number_of_island {
    // bfs
    int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    int r_len, c_len;
    public int numIslands(char [][] grid){
        if(grid == null || grid.length == 0) return 0;
        r_len = grid.length;
        c_len = grid[0].length;
        int res = 0;

        Queue<Integer> q = new LinkedList<>();
        boolean[][] seen = new boolean[r_len][c_len];
        for(int i = 0; i < r_len; i++){
            for(int j = 0; j < c_len; j++){
                if(grid[i][j] == '1' && !seen[i][j]){
                    res++;
                    seen[i][j] = true;
                    q.offer(i*c_len + j);
                    while(!q.isEmpty()){
                        int node = q.poll();
                        int r = node / c_len, c = node % c_len;       
                        for(int k = 0; k < 4; k++){
                            int rr = r + dirs[k][0], cc = c + dirs[k][1];
                            if(rr >= 0 && rr < r_len && cc >= 0 && cc < c_len  && grid[rr][cc] == '1' && !seen[rr][cc]){
                                q.offer(rr*c_len + cc);
                                seen[rr][cc] = true;
                            }
                        }                        
                    }
                }
            }
        }
        return res;
    }
    // dfs
    public int numIslandsDfs(char [][] grid){
        if(grid == null || grid.length == 0) return 0;
        r_len = grid.length; c_len = grid[0].length;
        int res = 0;
        for(int  i = 0; i < r_len; i++){
            for(int j = 0; j < c_len; j++){
                if(grid[i][j] == '1'){
                    res++;
                    dfs(grid, i, j);
                }  
            }
        }
        return res;
    }

    public void dfs(char[][] grid, int i, int j){
        if(i > r_len - 1 || i < 0 || j > c_len - 1 || j < 0 || grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        for(int[] dir : dirs){
            dfs(grid, i+dir[0], j+dir[1]);
        } 
        return;
    }
}
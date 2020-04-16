package questions;

import java.util.*;

public class zero_one_matrix {
    // bfs solution
    public int[][] updateMatrix(int[][] matrix) {
        int[][] vector = {{0,1},{1,0},{-1,0},{0,-1}};
        int r_len = matrix.length, c_len = matrix[0].length;
        //ez case
        if (r_len < 1) return matrix;
        //use array to save coordinate 
        Queue<int[]> q = new LinkedList<>();
        
        int[][] tmp = new int[r_len][c_len];
        for(int i = 0; i < r_len; i++){
            for(int j = 0; j < c_len; j++){
                if(matrix[i][j] == 1) tmp[i][j] = Integer.MAX_VALUE;
                else q.offer(new int[]{i,j});
            }
        }
        while(!q.isEmpty()){
            int[] node = q.poll();
            // bfs
            for(int i = 0; i < 4; i++){
                int rr = vector[i][0] + vector[i][0];
                int cc = vector[i][1] + vector[i][1];
                if(rr < 0 || rr > r_len - 1 || cc < 0 || cc > c_len-1) continue;
                // compare the value around node
                // if new_node[i][j] > node[i][j] which means node[i][j] is closer to 0, then update new_node
                if(tmp[node[0]][node[1]] + 1 < tmp[rr][cc]){
                    tmp[rr][cc] = tmp[node[0]][node[1]] + 1;
                    q.offer(new int[]{rr, cc});
                }
            }
        }
        return tmp;
    }

    // dp solution
    public int[][] updateMatrixDp(int[][] matrix){
        int r_len = matrix.length, c_len = matrix[0].length;
        //ez case
        if (r_len < 1) return matrix;
        int[][] tmp = new int[r_len][c_len];
        for(int i = 0; i < r_len; i++){
            for(int j = 0; j < c_len; j++){
                tmp[i][j] = Integer.MAX_VALUE - 1;
            }
        }
        // traverse from left and above
        for(int i = 0; i< r_len; i++){
            for(int j = 0; j < c_len; j++){
                if(matrix[i][j] == 0) tmp[i][j] = 0;
                else {
                    if(i > 0) tmp[i][j] = Math.min(tmp[i][j], tmp[i-1][j]+1);
                    if(j > 0) tmp[i][j] = Math.min(tmp[i][j], tmp[i][j-1]+1);
                }
            }
        }
        // traverse from right and bottom
        for(int i = r_len - 1; i >= 0; i--){
            for(int j = c_len - 1; j >= 0; j--){
                if(matrix[i][j] == 0) tmp[i][j] = 0;
                else {
                    if(i < r_len - 1) tmp[i][j] = Math.min(tmp[i][j], tmp[i+1][j] + 1);
                    if(j < c_len - 1) tmp[i][j] = Math.min(tmp[i][j], tmp[i][j+1] + 1);
                }
            }
        }
        return tmp;
    }
}
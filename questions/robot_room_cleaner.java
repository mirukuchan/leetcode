package questions;

import java.util.HashSet;
import java.util.Set;

// interface Robot{
//  boolean move();
//  void turnLeft();
//  void turnRight();
//  void clean();
// }

// Input:
// room = [
//   [1,1,1,1,1,0,1,1],
//   [1,1,1,1,1,0,1,1],
//   [1,0,1,1,1,1,1,1],
//   [0,0,0,1,0,0,0,0],
//   [1,1,1,1,1,1,1,1]
// ],
// row = 1,
// col = 3

interface Robot_op {
    boolean move();
    void turnLeft();
    void turnRight();
    void clean();
}

class Robot implements Robot_op{
    public boolean move(){
        return false;
    }
    public void turnLeft(){};
    public void turnRight(){};
    public void clean(){};
} 

public class robot_room_cleaner {
    
    int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    Set<String> visited = new HashSet<>();
    public void cleanRoom(Robot robot){
        dfs(robot, 0, 0, 0);
        return;
    }

    public void dfs(Robot robot, int r, int c,int dir){
        //4 directions
        visited.add(r+"-"+c);
        robot.clean();        
        for(int i = 0; i < 4; i++){
            int cur_dir = (i + dir) % 4;
            int rr = r + dirs[cur_dir][0], cc = c+dirs[cur_dir][1];
            if(!visited.contains(rr+"-"+cc) && robot.move()){
                dfs(robot, rr, cc, cur_dir);
                // go back and turn around
                robot.turnRight();
                robot.turnRight();   
                robot.move();
                robot.turnLeft();
                robot.turnLeft();
            }
            robot.turnRight();
        }
    }
}
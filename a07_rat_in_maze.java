import java.util.ArrayList;
import java.util.List;

public class a07_rat_in_maze {

    public static void ratmaze(int[][] maze,int n,int x,int y,boolean[][] visted,String path,List<String> list){
        if(x==n-1&&y==n-1){
            list.add(path);
            return;
        }
        visted[x][y]=true;
        int[] dx={1,0,0,-1};
        int[] dy={0,1,-1,0};
        char[] dir={'D','L','R','U'};
        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(nx>=0&&ny>=0&&nx<n&&ny<n&&maze[nx][ny]==1&&!visted[nx][ny]){
                ratmaze(maze, n, nx, ny, visted, path+dir[i], list);
            }
        }
        visted[x][y]=false;
    }
    public static void main(String[] args) {
        int[][] maze = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 1}
        };
        int n=maze.length;
        List<String> list=new ArrayList<>();
        boolean[][] visted=new boolean[n][n];
        if(maze[0][0]==1){
            ratmaze(maze, n, 0, 0, visted, "",list);
        }
        System.out.println(list);
        
    }
}

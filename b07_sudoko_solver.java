import java.util.Arrays;

public class b07_sudoko_solver {

    public static boolean solve(int r,int c,char[][] board){
        if(r==9){
            return  true;
        }
        if(c==9){
            return solve(r+1,0,board);
        }
        if(board[r][c]!='.'){
            return solve(r,c+1,board);
        }
        for(char num='1';num<='9';num++){
            if(valid(num,r,c,board)){
                board[r][c]=num;
               if( solve(r, c+1, board)){
                return true;
               }
                board[r][c]='.';
            }
        }
        return false;
    }
    public static boolean valid(char ch,int r,int c,char[][] board){
        for(int i=0;i<9;i++){
            if(board[i][c]==ch){
                return false;
            }
        }
        for(int i=0;i<9;i++){
            if(board[r][i]==ch){
                return false;
            }
        }
        int ir=(r/3)*3;
        int ic=(c/3)*3;
        for(int i=ir;i<ir+3;i++){
            for(int j=ic;j<ic+3;j++){
                if(board[i][j]==ch){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
         char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };

        solve(0, 0, board);
        for(char[] num:board){
            System.out.println(num);
        }
        System.out.println(Arrays.deepToString(board));
    }
}

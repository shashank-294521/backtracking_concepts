import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class b06_nqueen2 {
    public static void main(String[] args) {
        int n=4;
        List<List<String>> list=new ArrayList<>();
        char[] template=new char[n];
        Arrays.fill(template,'.');
        List<char[]> board=new ArrayList<>();
        for(int i=0;i<n;i++){
            board.add(template.clone());
        }

        boolean[] cols=new boolean[n];
        boolean[] maindiagnol=new boolean[2*n-1];
        boolean[] antidiagnol=new boolean[2*n-1];

        make_combination(0, n, board, cols, maindiagnol, antidiagnol, list);

        System.out.println(list.size());

        
    }
    public static void make_combination(int r,int n,List<char[]> board,boolean[] cols,boolean[] maindiagnol,boolean[] antidiagnol,List<List<String>> list){
            if(r==n){
                List<String> snapsot=new ArrayList<>();
                for(char[] row:board){
                    snapsot.add(new String(row));
                }
                list.add(snapsot);
                return;
            }
            for(int c=0;c<n;c++){
                int d1=r-c+n-1;
                int d2=r+c;
                if(cols[c]||maindiagnol[d1]||antidiagnol[d2]){
                    continue;
                }

                board.get(r)[c]='Q';
                cols[c]=maindiagnol[d1]=antidiagnol[d2]=true;

                make_combination(r+1, n, board, cols, maindiagnol, antidiagnol, list);

                board.get(r)[c]='.';
                cols[c]=maindiagnol[d1]=antidiagnol[d2]=false;
                
            }
        }
}

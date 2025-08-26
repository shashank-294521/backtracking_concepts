import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class a08_possible_palindromic_string {

    public static void possibleString(String s,int index,List<String> path,List<List<String>> res){
        if(index==s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=index;i<s.length();i++){
            if(ispalindrome(s,index,i)){
                path.add(s.substring(index, i+1));
                possibleString(s, i+1, path, res);
                path.remove(path.size()-1);
            }
        }
    }
    public static boolean ispalindrome(String s,int l,int r){
        while(l<r){
            if(s.charAt(l++)!=s.charAt(r--)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s="aaba";
        List<List<String>> res=new ArrayList<>();
        List<String> path=new ArrayList<>();
        possibleString(s,0,path,res);
        System.out.println(Arrays.deepToString(res.toArray()));


        }
}

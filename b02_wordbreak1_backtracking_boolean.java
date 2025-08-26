import java.util.ArrayList;
import java.util.List;

public class b02_wordbreak1_backtracking_boolean {
    public static boolean wordbreak1(String str,int index,List<String> list){
        if(index==str.length()){
            return true;
        }
        for(int i=index;i<str.length();i++){
            String st=str.substring(index, i+1);
            if(list.contains(st)&&wordbreak1(str, i+1, list)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String str="leetcode";
        List<String> worddict=new ArrayList<>();
        worddict.add("leet");
        worddict.add("code");

        boolean ans=wordbreak1(str, 0, worddict);
        System.out.println(ans);
    }
}

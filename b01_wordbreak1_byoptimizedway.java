import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class b01_wordbreak1_byoptimizedway {

    public static boolean wordbreak(String str,List<String> dict){
        Set<String> set=new HashSet<>(dict);
        boolean[] dp=new boolean[str.length()+1];
        dp[0]=true;
        for(int i=0;i<=str.length();i++){
            for(int j=0;j<i;j++){
                if(dp[j]&&set.contains(str.substring(j,i)))
                {
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[str.length()];
    }
    public static void main(String[] args) {
        String str="leetcodes";
        List<String> worddict=new ArrayList<>();
        worddict.add("leet");
        worddict.add("codes");
       boolean ans= wordbreak(str, worddict);
       System.out.println(ans);



    }
}

import java.util.ArrayList;
import java.util.List;

public class a09_wordbreak1 {

    public static void is_possible_to_break(String str,int index,int[] count,List<String> dict,List<String> res){
        if(index==str.length()){
            count[0]++;
            System.out.println(res);
            return ;
        }
        for(int i=index;i<str.length();i++){
            String st=str.substring(index,i+1);
            if(dict.contains(st)){
                res.add(st);
                is_possible_to_break(str, i+1, count, dict, res);
                res.remove(res.size()-1);
            }
        }
    }
    public static void main(String[] args) {
        String s="leetcode";
        List<String> list=new ArrayList<>();
        list.add("leet");
        list.add("code");
        // System.out.println(list);
        List<String> res=new ArrayList<>();
        int[] count={0};
        is_possible_to_break(s, 0,count, list, res);
        if(count[0]>0){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        } 
    }
}

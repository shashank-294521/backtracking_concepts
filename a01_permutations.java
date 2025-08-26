import java.util.ArrayList;
import java.util.List;

public class a01_permutations {

    public static void permute(String input, String output,List<String> list){
        if(input.length()==0){
            list.add(output);
            return;
        }
        
        for(int i=0;i<input.length();i++){
            char ch=input.charAt(i);
            permute(input.substring(0, i)+input.substring(i+1), output+ch, list);
        }
    }
    public static void main(String[] args) {
        String s="abc";
        
        List<String> list=new ArrayList<>();
        permute(s,"",list);
        System.out.println(list);
    }
}

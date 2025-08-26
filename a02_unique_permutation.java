import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class a02_unique_permutation {

    public static void permute(String input,String output,List<String> list){
        if(input.length()==0){
            list.add(output);
            return;
        }
        for(int i=0;i<input.length();i++){
            if(i>0&&input.charAt(i)==input.charAt(i-1)){
                continue;
            }
            char ch=input.charAt(i);
            String left=input.substring(0, i)+input.substring(i+1);
            permute(left, output+ch, list);
        }
    }
    public static void main(String[] args) {
        String s="aba";
        char[] arr=s.toCharArray();
        Arrays.sort(arr);
        String str=new String(arr);


        List<String> list=new ArrayList<>();
        permute(str,"",list);
        System.out.println(list);
    }
}

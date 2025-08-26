import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class a03_unique_permutation_StringBuilder {

    public static void permute(StringBuilder input,StringBuilder output,List<String> list){
        if(input.length()==0){
            list.add(output.toString());
            return ;
        }
        for(int i=0;i<input.length();i++){
            if(i>0&&input.charAt(i)==input.charAt(i-1)){
                continue;
            }
            char ch=input.charAt(i);
           
            StringBuilder left=new StringBuilder(input.substring(0,i)+input.substring(i+1));
            permute(left,output.append(ch), list);
            output.deleteCharAt(output.length()-1);
        }
    }
    public static void main(String[] args) {
        String str="aba";
        char[] arr=str.toCharArray();
        Arrays.sort(arr);
        String s=new String(arr);
        List<String> list=new ArrayList<>();
        StringBuilder output=new StringBuilder();
        StringBuilder input=new StringBuilder(s);
        permute(input, output, list);
        System.out.println(list);

    }
}

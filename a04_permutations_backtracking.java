import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class a04_permutations_backtracking {

    public static void permute(StringBuilder str,int index,List<String> list){
        if(index==str.length()){
            list.add(str.toString());
            return;
        }
        for(int i=index;i<str.length();i++){

            boolean skip=false;
            for(int k=index;k<i;k++){
                if(str.charAt(k)==str.charAt(i)){
                    skip=true;
                    break;
                }
            }
            if(skip){
                continue;
            }

            swap(str,i,index);
            permute(str, index+1, list);
            swap(str,i,index);   //backtracking

        }
    }
    public static void swap(StringBuilder str,int i,int j){
        char temp=str.charAt(i);
        str.setCharAt(i, str.charAt(j));
        str.setCharAt(j, temp);
    }
    public static void main(String[] args) {
        String s="BRB";
        char[] arr=s.toCharArray();
        Arrays.sort(arr);    // this uncooment when u have duplicates in ur character 
        String st=new String(arr);
        StringBuilder str=new StringBuilder(st);
        List<String> list=new ArrayList<>();
        permute(str,0,list);
        System.out.println(list);
    }
}

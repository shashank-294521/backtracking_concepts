import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class reverse_the_sentence_list {
    public static void main(String[] args){
        String str="Hey Hyderabad, I am coming home. Be ready";
        List<String> list=new ArrayList<>();
        String[] arr=str.split(" ");
        System.out.println(Arrays.toString(arr));
        StringBuilder s=new StringBuilder();

        for(String st: arr){
            if(Character.isLetterOrDigit(st.charAt(st.length()-1))){
                list.add(st);
            }
            else{
                char ch=st.charAt(st.length()-1);
                list.add(st.substring(0, st.length()-1));
                Collections.reverse(list);
                s.append(String.join(" ",list));
                s.append(ch).append(" ");
                list.clear();
            }
        }
        if(!list.isEmpty()){
            Collections.reverse(list);
            s.append(String.join(" ",list));
        }
        System.out.println(s.toString());
    }
}

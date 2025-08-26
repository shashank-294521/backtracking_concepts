import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class b04_17_lettercombinatiion_ph_no {

    public static void makepossible_combonation(String digit,int index,StringBuilder path,Map<Character,String> map,List<String>list){
        if(index==digit.length()){
            list.add(path.toString());
            return;
        }
        char ch=digit.charAt(index);
        String word=map.get(ch);
        for(char letter:word.toCharArray()){
            path.append(letter);
            makepossible_combonation(digit, index+1, path, map, list);
            path.deleteCharAt(path.length()-1);
            
        }
    }
    public static void main(String[] args) {
        String digit="278";
        Map<Character,String> map=new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        List<String> list=new ArrayList<>();
        StringBuilder path=new StringBuilder();
        makepossible_combonation(digit, 0, path, map, list);
        System.out.println(list);

    }
}

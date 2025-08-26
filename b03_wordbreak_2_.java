import java.util.ArrayList;
import java.util.List;

public class b03_wordbreak_2_ {
    public static void main(String[] args){
        String s="catsanddog";
        List<String> worddict=new ArrayList<>();
        // ["cat","cats","and","sand","dog"]
        worddict.add("cat");
        worddict.add("cats");
        worddict.add("and");
        worddict.add("sand");
        worddict.add("dog");

        List<String> res=new ArrayList<>();
        List<String> path=new ArrayList<>();
        wordbreak2(0, s, worddict, path, res);
        System.out.println(res);


    }
    public static void wordbreak2(int index,String s,List<String> worddict,List<String> path,List<String> res){
        if(index==s.length()){
            res.add(String.join(" ", path));
            return;
        }
        for(int i=index;i<s.length();i++){
            String word=s.substring(index, i+1);
            if(worddict.contains(word)){
                path.add(word);
                wordbreak2(i+1,s,worddict,path,res);
                path.remove(path.size()-1);
            }
        }
    }
}

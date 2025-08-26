import java.util.ArrayList;
import java.util.List;

public class a06_Ndigit_no_withincreaasingdigit {
//     Have exactly N digits
// The digits are in strictly increasing order from left to right
// eg 123 are vallid but 321 is not valid 

public static void generatenum(int n,List<Integer> list,List<Integer> res){
    if(n==0){
        int ans=0;
        for(int i=0;i<list.size();i++){
            ans=ans*10+list.get(i);
        }
        res.add(ans);
        return;
    }

    for(int i=1;i<=9;i++){
        if(list.size()==0||i>list.get(list.size()-1)){
            list.add(i);
            generatenum(n-1,list,res);
            list.remove(list.size()-1);
        }
        
    }
}
public static void main(String[] args) {
    int N=2 ;
    List<Integer> res=new ArrayList<>();
    if(N==1){
        for(int i=1;i<=9;i++){
            res.add(i);
        }
        System.out.println(res);
        return;
    }
    
     List<Integer> list=new ArrayList<>();

    generatenum(N,list,res);
    System.out.println(res);
}
}

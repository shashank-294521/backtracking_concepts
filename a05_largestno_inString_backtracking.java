public class a05_largestno_inString_backtracking {

    public static void findlargest(StringBuilder str,int index,int k,StringBuilder res){
        if(k==0||str.length()==index){
            if(str.toString().compareTo(res.toString())>0){ // at base case the largest no. is found the update the res
                res.replace(0, res.length(), str.toString());
            }
            return;
        }
        for(int i=index+1;i<str.length();i++){
            if(str.charAt(i)>str.charAt(index)){
                swap(str,index,i);
                if(str.toString().compareTo(res.toString())>0){// there might be a chance to get max btween less then kth swap then update
                    // the update the res no need to check until base case 
                    res.replace(0, res.length(),str.toString());
                }
                findlargest(str, index+1, k-1, res);
                swap(str,index,i);  //backtrack
            }
        }
        findlargest(str, index+1, k, res);  //for horizontal  drifting  lest say 751 the no need to swap just increase the index by 1
    }
    public static void swap(StringBuilder s,int i,int j){
        char temp=s.charAt(i);
        s.setCharAt(i, s.charAt(j));
        s.setCharAt(j, temp);
    }
    public static void main(String[] args) {
        String s="4577";
        int k=4;
        StringBuilder str=new StringBuilder(s);
        StringBuilder res=new StringBuilder();
        findlargest(str,0,k,res);
        System.out.println(res);
    }
}

// why i use two if cases and compare two strings
// Because there are two scenarios where we might find a larger number:

// During the search (after each swap)

// You may immediately form a number larger than the current best.

// Example: "1234" → after swapping 1 and 4 you get "4231" which is already larger.

// No need to wait until the recursion goes all the way to the leaf — we should update res immediately.

// At the recursion end (base case)

// When you’ve used up all swaps (k==0) or reached the end of the string, whatever string you have is a valid candidate.

// You must compare it with res again in case this path yields the maximum.
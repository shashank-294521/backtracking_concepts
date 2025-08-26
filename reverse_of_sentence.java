import java.util.Arrays;
import java.util.Stack;

public class reverse_of_sentence {
    // Hey Hyderabad, I am coming home. Be ready 
    // Hyderabad Hey, home coming am I. ready Be

    public static void main(String[] args){
        String str="Hey Hyderabad, I am coming home. Be ready";
        Stack<String> stack=new Stack<>();
        String[] arr=str.split(" ");
        System.out.println(Arrays.toString(arr));
        for(int i=0;i<arr.length;i++){
          
           if(Character.isLetterOrDigit(arr[i].charAt(arr[i].length()-1))){
              stack.push(arr[i]);
            }
            else if(!Character.isLetterOrDigit(arr[i].charAt(arr[i].length()-1))){
             char ch = arr[i].charAt(arr[i].length() - 1);
             String st = arr[i].substring(0, arr[i].length() - 1);
              stack.push(st);
             while (!stack.isEmpty()) {
                      System.out.print(" " + stack.pop());
             }
                System.out.print("" + ch);
            }
        }
        while(!stack.isEmpty()){
            System.out.print(" "+stack.pop());
        }
    }
}

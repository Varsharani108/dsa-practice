package Stack.Basics;
import java.util.*;

public class Duplicate {
    public static boolean isDuplicate(String str){
        Stack<Character> s=new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);

            //closing
            if(ch==')'){
                int count=0;
                while(s.peek()!='('){
                    s.pop();
                    count++;
                }
                if(count <1){
                    return true;
                }else{
                    s.pop();//opening pair
                }
            }else{
                //opening
                s.push(ch);
            }
            
        }
        return false;

    }
    public static void main(String[]args){
        //String str="((a+b))";
        String str2="(9a-b)";
        System.out.println(isDuplicate(str2));
    }
    
}

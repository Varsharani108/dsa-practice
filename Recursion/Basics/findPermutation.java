package Recursion.Basics;

public class findPermutation {
    public static void find(String str,String ans){
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        for(int i=0; i<str.length();i++){
            char curr=str.charAt(i);
            //"abcde"=>"ab" + "de"="abde"
            String newStr= str.substring(0,i) +str.substring(i+1); 
            find(newStr,ans+curr);
        }
        
    }
    public static void main(String[] args){
        String str="abc",ans="";
        find(str,ans);

        }
    
}

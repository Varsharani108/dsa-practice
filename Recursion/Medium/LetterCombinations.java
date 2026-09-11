package Recursion.medium;

public class LetterCombinations {

     static String[] keypad = {
        "", "", "abc", "def", "ghi",
        "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public static String getLetters(int digit) {
    return keypad[digit];
    }

    public static void generate(String digits, int index, String current){
        // base case
        if(index==digits.length()){
            System.out.println(current);
            return;
        }
        int digit=digits.charAt(index) - '0';
        String letters=getLetters(digit);
        for(int i=0;i<letters.length();i++){
            generate(digits,index+1,current+letters.charAt(i));
        }
    }
    public static void main(String args[]){
        String digits="234";
        generate(digits,0,"");
    }
    
}

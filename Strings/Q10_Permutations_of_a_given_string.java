package Strings;

/**
 * Q10_Permutations_of_a_given_string
 */
public class Q10_Permutations_of_a_given_string {

    public static void main(String[] args) {
        printPermutations("abc","");
    }
    public static void printPermutations(String str, String ans) {
        
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            String leftPart = str.substring(0,i);
            String rightPart = str.substring(i+1);
            String totalpart = leftPart+rightPart;
            printPermutations(totalpart, ans+c);
        }
    }

    
}
package Strings;

/**
 * Q39_Transform_OneString_to_Another_using_Minimum_Number_of_Given_Operation
 */
public class Q39_Transform_OneString_to_Another_using_Minimum_Number_of_Given_Operation {

    public static void main(String[] args) {
        
    }

    public static void getMinStepForTransformation(String A,String B) {
        
        for (int i = 0 ; i < A.length() ; i++) {
            int k = 0 ; 
            int j = 0 ;
            
            //   String A = "EACBD"; String B = "EABCD";

            while (k < A.length() && j < B.length()) {
                if(A.charAt(k)==B.charAt(j)){
                    k++;
                    j++;
                }
                else{
                    if(A.charAt(k) !=B.charAt(j)){
                        k++;
                    }
                }
            }
        }
    }

    public static void rearrangeIt(String s , int k) {
        
    }
}
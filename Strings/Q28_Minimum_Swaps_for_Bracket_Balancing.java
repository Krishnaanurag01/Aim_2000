package Strings;

public class Q28_Minimum_Swaps_for_Bracket_Balancing {
    public static void main(String[] args) {
        System.out.println(getMinimumSwapsForBalancedBrackets("[]][]["));
    }
    public static int  getMinimumSwapsForBalancedBrackets(String s) {
    

    int openingBracket = 0 ;
    int closingBracket = 0 ;
    int swaps = 0;
    int imbalance = 0;

    for (int i = 0; i < s.length(); i++) {
        
        if (s.charAt(i) == '[') {
            openingBracket++;
            if( imbalance > 0){

                swaps += imbalance;
                 imbalance--;
            }
        }
        else if(s.charAt(i) == ']'){
            closingBracket++;

            imbalance = closingBracket - openingBracket ; 
        }
    }

    return swaps;
    }
}

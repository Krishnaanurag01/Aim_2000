package Arrays_and_string;

public class Q42_Minimum_rotations_required_to_get_the_same_string {

    public static void main(String[] args) {
        
        System.out.println(getMinRotation("geeks"));
    }

    public static int getMinRotation(String s) {
        
        String ns = s + s ;

        for (int i = 1; i < ns.length(); i++) { // starting from 1 becuase if we start from 0 then it give 0 as ns is made of itself so it'll return index of first occurance.
            

            if(ns.substring(i, i+s.length()).equals(s)){
                return i ;
            }

        }

        return 0 ;
    }
    
}

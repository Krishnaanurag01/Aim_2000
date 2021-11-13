package Problem_Of_The_day;

import java.util.HashSet;

public class Q4_Array_Subset_of_another_array {

    public static void main(String[] args) {
        
    }


    public static String is_subset(long[] a1 , long[] a2 , long n , long m) {
        
        HashSet<Long> set = new HashSet<>() ;

        for (int i = 0; i < a1.length; i++) {
            set.add(a1[i]) ;
        }


        String is_subset_huh = "No" ;

        for (int i = 0; i < a2.length; i++) {
            if(set.contains(a2[i]) == false){
                is_subset_huh = "Yes";
                break ;
            }
        }
        //
        return is_subset_huh ;
    }
    
}

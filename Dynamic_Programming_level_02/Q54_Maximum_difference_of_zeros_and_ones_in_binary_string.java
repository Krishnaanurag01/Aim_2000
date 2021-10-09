package Dynamic_Programming_level_02;

public class Q54_Maximum_difference_of_zeros_and_ones_in_binary_string {

    public static void main(String[] args) {
        
    }

    public static int get_max_difference(String s) {
        
        int csum = 0 ;
        int bsum = 0 ;
        
        for (int i = 0; i < s.length() ; i++) {
            int val = 0 ;

            // when we get char '0' then we consider 1 and if we get char '1' then  we consider -1.
            // and will apply kadanes algo

            if(s.charAt(i) == '0'){
                val = 1 ;
            }
            else{
                val = -1 ;
            }

            // kadanes also

            csum += val ;

            if(csum < val){
                csum = val ;
            }

            if(bsum < csum){
                bsum = csum ;
            }

            
        }

        return bsum == 0 ? -1 : bsum ;
    }
    
}

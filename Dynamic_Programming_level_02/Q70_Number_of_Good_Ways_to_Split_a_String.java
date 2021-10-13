package Dynamic_Programming_level_02;

public class Q70_Number_of_Good_Ways_to_Split_a_String {

    public static void main(String[] args) {
        
    }
    

    public static int get_good_split_count(String s) {
        
        int[] prefix = new int[s.length()] ; /// store count of distinct elements from left to right.
        int[] suffix = new int[s.length()] ; // store count of distinct element from right to left.


        int[] frequency = new int[26] ; // stores the frequency of each elements.
        int count = 0 ;  // store the count of distinct elements.

        for (int i = 0; i < s.length() ; i++) {
            int index = s.charAt(i) - 'a' ; // getting the ascii and subtracting from a gives index 0 to n. eg : a = 64 - a(64) == 0 so a's data will be store at 0th index.

            frequency[index]++ ; // increase freq
 
            if(frequency[index] == 1 ){ // if freq is 1 means it just appered so increase count.
                count++ ;
            }

            prefix[i] = count ;
        }

        frequency = new int[26] ; // again initializing both so that we can store from right to left data.
        count = 0 ;

        for (int i = s.length() - 1; i > 0 ; i--) {
            int index = s.charAt(i) - 'a' ;

            frequency[index]++ ;

            if(frequency[index] == 1 ){
                count++ ;
            }

            suffix[i] = count ;
        }

        int splits = 0 ;
        // now counting the splits

        for (int i = 0; i < s.length() - 1 ; i++) { // running from 0 to n-1
            
            if(prefix[i] == suffix[i+1]){ // when both are same then then its satisfying the conditions so increase the split count. 
                splits++;
            }
        }

        return splits ;
    }
}

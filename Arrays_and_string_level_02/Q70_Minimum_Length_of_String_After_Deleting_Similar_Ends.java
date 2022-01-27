package Arrays_and_string_level_02;

public class Q70_Minimum_Length_of_String_After_Deleting_Similar_Ends {

    public int minimumLength2(String s) {
        
        int i = 0 ;
        int j = s.length() - 1 ;
        
        while( i < j && s.charAt(i) == s.charAt(j) ){  // run till both the starting and ending character is same
            
            char ch = s.charAt(i) ;
            
            while(i < j && ch == s.charAt(i)){ // go to next char
                i++ ;
            }
            
            
            // here j will run till it is greater or equals to i so that it covers the test case when string length is 0
            while(i <= j && ch == s.charAt(j)){ // go to next char
                j-- ;
            }
        }
      
        return j-i+1 ;  
    }
}

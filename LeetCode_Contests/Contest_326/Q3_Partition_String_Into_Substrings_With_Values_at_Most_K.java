package LeetCode_Contests.Contest_326;

public class Q3_Partition_String_Into_Substrings_With_Values_at_Most_K {

    public int minimumPartition(String s, int k) {
        
        int i = 1 ;
        int part = 1 ; // count of total partiton
        long curr = s.charAt(0) - '0' ; // starting the first partition
        
        for( ; i < s.length() ; i++){
            long val = s.charAt(i) - '0' ;
            
            if(val > k) return -1; // if value is greater than k then partition not possible
            
            curr = curr * 10 + val ;
            
            if(curr >= k){ // when becomes greater then break the prev part and make new one
                curr = val ;
                part++ ;
            }
        }
        
        
        if(i == s.length())  return part ;
        
        return -1;
    }
}

package Problem_Of_The_day;

public class Q173_Maximum_Distance_Betweena_Pair_of_Values {

    public int maxDistance(int[] nums1, int[] nums2) {
        
        int i = nums1.length - 1 ;
        int j = nums2.length - 1 ;
        int ans = 0 ;
        
        while( i >= 0 && j >= 0){
            int val1 = nums1[i] ;
            int val2 = nums2[j] ;
            if(j < i){ // i also can't be greater than j
                i =  j ;
            }
            
            if(val1 <= val2){ // if val1 is less than val2 then go more left side 
                ans = Math.max(ans, j-i) ;
                i-- ;
            }
            else{ /// else val2 can't be lesser than val1 so go to letter of index2 until it becomes greater than val1
                j-- ;
            }
        }
        
        return ans ;
    }
}

package Searching_Sorting_level_02;
import java.util.*;

public class Q36_Largest_Number {
    
    public String largestNumber(int[] nums) {
        

        // Step 1 : convert element into string

        String[] arr = new String[nums.length] ;
        
        for(int i = 0 ; i < nums.length ; i++){
            arr[i] = nums[i] + "" ;
        }
        // when we sort the string array then the sorting will be based on lexicographically order.
        // Step 2 : now sort the array 
        Arrays.sort(arr, (a,b) -> {
            
            long n1 = Long.parseLong(a+b) ;
            long n2 = Long.parseLong(b+a) ;
            
            if(n1 > n2){ // when adding b in last gives larger then return 1
                return 1 ;
            }
            else if(n2 > n1){ // when adding a in last gives larger then return -1
                return -1 ;
            }
            else{ // else return 0 if both are equal
                return 0 ;
            }
            
        }) ;
        
        StringBuilder sb = new StringBuilder() ;
        
        for(int i = arr.length - 1 ; i >= 0 ; i--){
            sb.append(arr[i]) ;
        }
        
        if(sb.charAt(0) == '0') // here the first character denotes the last elememt of array as our string answer is made by adding n to 1 element and as it is sorted lexicographyically so it means if last element is 0 so previous element should must had been 0 as negative not possible so return 0 instead if "000000"
        return "0" ;
        
        return sb.toString()  ;
        
    }

    // gfg solution

    String printLargest(String[] arr) {
        // code here
        
        Arrays.sort(arr, (a,b) -> {
            
            String ab = a+b ;
            String ba = b+a ;
            
            return ab.compareTo(ba) ;
        }) ;
        
        
        StringBuilder sb = new StringBuilder() ;
        
        for(int i = arr.length - 1 ; i >= 0 ; i--){
            sb.append(arr[i]) ;
        }
        
        if(sb.charAt(0) == '0')
        return "0" ;
        
        return sb.toString()  ;
    }

}

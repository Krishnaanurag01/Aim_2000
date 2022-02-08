package Arrays_and_string_level_02;
import java.util.*;


public class Q5_Majority_Element_II_ {

    
    // this is brute force which takes extra O(n) space and time is O(n) ;

    public List<Integer> majorityElement(int[] nums) {
        
        HashMap<Integer,Integer> map = new HashMap<>() ;
        
        for(int i : nums){    // making freq map
            map.put(i , map.getOrDefault(i,0)+1) ;
        }
        
        List<Integer> list = new ArrayList<>() ;
        
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            if((int)e.getValue() > nums.length/3){
                list.add((int)e.getKey()) ;
            }
        }
        
        return list ;
    }


    // optimal solution using moore voting algo : 
    // as questions clearly said that return element with only freq greater than n/3 so there can be atmost 2 value for n/3 freq as if we module the n with 3 then it will give 0,1 or 2 . so when 0 then it means each part is of n/3 length , when 1 then it means each part is of n/3 length with 1 remmaining and same for 2 .
    // if three numbers becomes greater than n/3 then total count would be  greater than n so only two values are possible.

    public List<Integer> majorityElement2(int[] nums) {
        
       
        List<Integer> list = new ArrayList<>() ;
        
        int val1 = nums[0] ;  // taking first value with freq 1
        int c1 = 1 ;
        
        
        int val2 = nums[0] ;  // again take first value with 0 freq
        int c2 = 0 ;
        
        int i = 1 ;
        
        while(i < nums.length){
            
            if(nums[i] == val1){ // if same then increment c++ ;
                c1++ ;
            }
            else if(nums[i] == val2){ // if same then increment c2++ ;
                c2++ ;
            }
            else{
                if( c1 == 0 )   // if any val's freq becomes 0 then swap with current number
                {
                    val1 = nums[i] ;
                    c1 = 1 ;
                    
                }
                else if(c2 == 0){
                    
                    val2 = nums[i] ;
                    c2 = 1 ;
                }
                else{  // else decrement both c1 and c2 because it doesn't matched any conditions.
                    c1-- ; c2-- ;
                }
            }
            
            i++ ;
        }
        
        
        int freq1 = 0 ;
        
        int freq2 = 0 ;
        

        // now checking both values if they are possible answer or not.

        for(int j = 0 ; j < nums.length ; j++){
            if(val1== nums[j]){
                freq1++ ;
            }
            else if(val2 == nums[j]){  // using else if becuase when examplees like : 1,1,1,1 comes then it will count same 1 twice which is not correct.
                freq2++ ;
            }
        }
        
        if(freq1 > nums.length/3){
            list.add(val1) ;
        }
        
        if(freq2 > nums.length/3){
            list.add(val2) ;
        }
        
        
        return list ;
    }

}

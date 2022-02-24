package Searching_Sorting_level_02;
import java.util.*;

public class Q39_Ishaan_and_Sticks {

    public static ArrayList<Integer> square (int arr[], int n) {
        
        HashMap<Integer,Integer> map = new HashMap<>() ;
        // storing freq of every element
        for(int val : arr){
            map.put(val,map.getOrDefault(val,0)+1) ;
        }
        
        int maxArea = 0 ;
        int freqOfMax= 0 ;
        
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            int key = (int) e.getKey() ;
            int freq = (int) e.getValue() ;
            
            // for making a square we need 4 sides atleast and if freq of current entry is larger pr equal to 4 then do following
            if( freq >= 4 && key*key > maxArea ){
                maxArea = key*key ;
                freqOfMax = freq/4 ;
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>() ;
        
        if(maxArea == 0){
            ans.add(-1) ;
        }
        else{
        ans.add(maxArea) ;
        ans.add(freqOfMax) ;
        }
        
        return ans ;

    }
    
}

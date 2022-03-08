package HashMaps_and_Heaps_Level_01;
import java.util.*;

public class Q1_most_frequent_words {
    
     // Function for finding maximum and value pair
     public static String maximumFrequency (String S) {
        
        HashMap<String,Integer> map = new HashMap<>() ;
        
        String[] arr = S.split(" ");
        int hf = 1 ;
        String ans = arr[0] ;
        
        for(int i = 0 ; i < arr.length ; i++){
            String word = arr[i] ;
            
            map.put(word,map.getOrDefault(word,0)+1) ;
            
        }
        
        for(int i = 0 ; i < arr.length ; i++){
            String word = arr[i] ;
            
            int fre = map.get(word) ;
            
            if(fre > hf){
                hf = fre ;
                ans = word ;
            }
            
        }
        
        
        return ans +" "+hf;
        
    }

}

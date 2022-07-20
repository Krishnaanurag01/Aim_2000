package Problem_Of_The_day;
import java.util.*;

public class Q101_Number_of_Matching_Subsequences {
 
    public int numMatchingSubseq(String s, String[] words) {
        HashMap<Character,ArrayList<Integer>> map = new HashMap<>() ; // here we will store each char of s with a list where all the occurances(index) of char stores.
        
        for(int i = 0 ; i  < s.length() ;  i++){
            char ch  = s.charAt(i) ;
            ArrayList<Integer> indexes =  map.getOrDefault(ch, new ArrayList<>()) ;
            indexes.add(i) ; // storing ch occurance index.
            map.put(ch,indexes) ;
        }
        
        int count = 0 ;
        
        for(String word : words){
            
            int[] arr = new int[27] ; // stores the last index of every char occurances in map.list
            int prev = -1 ; // previous index.
            boolean founded = true ;
            
            for(int j = 0 ; j < word.length() ; j++){
                char ch = word.charAt(j) ;
                if(map.containsKey(ch) == false){ // if char is not present then return false.
                    founded = false;
                    break ;
                } 
                
                int idx = arr[ch - 'a'] ; // getting next index occurance of ch in map list.
                ArrayList<Integer> indexes = map.get(ch) ;
                boolean found = false ;
                while(idx < indexes.size()){
                    if(indexes.get(idx) > prev){  // if ch occurance index is greater than previous char occurance index then only we can take it.
                        arr[ch-'a'] = idx + 1 ; // updating arr for ch (updating the next index we will use for ch occurance)
                        prev = indexes.get(idx) ; // updating previous index
                        found = true ;
                        break ;
                    }
                    idx++ ;
                }
                
                if(found == false){ // if not found then return false
                    founded = false;
                    break ;
                }
            }
            if(founded) count++; // if it is true then count it.
        }
        
        return count ;
    }
}

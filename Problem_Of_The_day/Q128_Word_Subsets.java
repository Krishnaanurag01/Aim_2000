package Problem_Of_The_day;
import java.util.*;

public class Q128_Word_Subsets {
    
    public List<String> wordSubsets(String[] words1, String[] words2) {
        
        List<String> ans = new ArrayList<>() ;
        
        HashSet<String> set = new HashSet<>(); // converting word2 into set to remove redundency.
        for(String word : words2){
            set.add(word) ;
        }
        
        HashMap<Character,Integer> freqMap = new HashMap<>() ;// this map will cotains the highest freq of every char such that it can make every word in word2 set.
        for(String word : set){
            int[] arr = new int[27] ;
            for(char ch : word.toCharArray()){
                arr[ch-'a']++ ;
            }
            
            for(int i = 0 ; i < 27 ; i++){
                char ch  = (char)(i+'a') ;
                int prev = freqMap.getOrDefault(ch,0);
                int curr = arr[i] ;
                if(curr > prev){
                    freqMap.put((char)(i+'a'),curr) ;
                }
            }
        }
        

        
        // now step 3 : we will compare the freq of every word of words1 with each char of freqMap. 
        for(String word : words1){
            
            HashMap<Character,Integer> map = new HashMap<>() ;
            for(char ch : word.toCharArray()){
                map.put(ch,map.getOrDefault(ch,0)+1);
            }
            
            boolean flag = true ;
            for(Character ch : freqMap.keySet()){
                if(freqMap.get(ch) > map.getOrDefault(ch,0)){ // if map's char has less freq means the current word is not superset of any word in words2.
                    flag = false ;
                    break;
                }
            }
            
            if(flag) ans.add(word) ; // if flag remains true then this word superset for every word of word2.
        }
        
        
        return ans ;
    }
}

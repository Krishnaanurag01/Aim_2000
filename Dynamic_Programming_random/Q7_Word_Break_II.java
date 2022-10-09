package Dynamic_Programming_random;
import java.util.*;

public class Q7_Word_Break_II {

    public List<String> wordBreak(String s, List<String> wordDict) {
        
        // storing dictionary in hash set for easy search.
        HashSet<String> set = new HashSet<>() ;
        for(String word: wordDict){
            set.add(word) ;
        }
        
        
        // making an arraylist of array.
        ArrayList<String>[] arr = new ArrayList[s.length()] ;
        StringBuilder sb = new StringBuilder() ;
        
        for(int i = 0 ; i < s.length() ; i++){
            sb.append(s.charAt(i)) ;
            arr[i] = new ArrayList<>() ; // intiallyzing arraylist for string till ith indices.
            
            if(set.contains(sb.toString())){ // if whole string till noe is present then add curr word in ans.
               ArrayList<String> list =  arr[i] ;
                list.add(sb.toString()) ;
            }
            
            for(int j = 1 ; j <= i ; j++){ // now dividing the string.
                String suffix = s.substring(j,i+1) ;
                String prefix = s.substring(0,j) ;
                
    // if suffix is dict word and left part has string formation (denotes left part must be able to make sentences)
                if(set.contains(suffix) && arr[j-1].size() > 0){
                    ArrayList<String> list = arr[j-1] ; // fectch in list of string of jth index
                    ArrayList<String> list2 = arr[i] ;

                    for(String ss : list){ // now adding current word in jth arraylist.
                        list2.add(ss + " "+ suffix) ;
                    }
                }
            }
            
        }
        
        return arr[s.length() - 1] ;
        
    }
}

package Problem_Of_The_day;
import java.util.*;

public class Q330_Find_the_longest_string {

    public static String longestString(int n, String[] arr) {
        
        HashSet<String> set = new HashSet<>() ;
        for(String s : arr){
            set.add(s) ;
        }
        
        int ans = -1 ;
        
        Arrays.sort(arr);
        
        for(int i = 0 ; i < n ; i++){
            String s = arr[i] ;
            boolean prefixPresent = true ;
            StringBuilder sb = new StringBuilder() ;
            
            // check each prefix is resent or not
            for(int j = 0 ; j < s.length() ; j++){
                sb.append(s.charAt(j)) ;
                
                if(set.contains(sb.toString()) == false){
                    prefixPresent = false;
                    break;
                }
            }
            
            if(prefixPresent){
                if(ans == -1){
                    ans = i ;
                }
                else{
                    
                    if(arr[ans].length() < s.length()){
                        ans = i ;
                    }
                    
                }
            }
        }
        
        return ans != -1 ? arr[ans] : "" ;
    }
}

package Problem_Of_The_day;

public class Q392_Number_of_Ways_to_Form_a_Target_String_Given_a_Dictionary {
    
     
    
    int[][] map  ; // using array instead of hashmap
    int mod = (int)1e9+7 ;
    Long[][] dp ;
    
    public int numWays(String[] words, String target) {
       map = new int[words[0].length()][26]; // for each index of words[0] this array will hold a 26 size character freq array
       dp = new Long[words[0].length()][target.length()] ; 
        
        for(int i = 0 ; i < words[0].length() ; i++){
            for(String word : words){
                map[i][word.charAt(i) - 'a']++ ; 
            }
            // map.put(i, temp) ;
        }
    
        // System.out.println(map) ;
        
        
        return  (int)helper(0, words[0].length() - 1, target , 0);    
    }
    
    long helper(int si, int ei, String target, int tidx){

        if(tidx >= target.length()) return 1L ;
        if(si > ei) return  0L ;
        if(dp[si][tidx] != null) return dp[si][tidx] ;

        long picked = 0 ;
        
        // if current target char is present at si index of mapp then pick 
        if(map[si][target.charAt(tidx) - 'a'] > 0 ){
            picked = (map[si][target.charAt(tidx) - 'a'] * helper(si+1, ei, target, tidx+1)) % mod ;
        }
        
        // and also not pick for other possibilities
        long notPicked = helper(si+1, ei, target, tidx) ;
        
        return dp[si][tidx] = (picked + notPicked) % mod ;
    }
}

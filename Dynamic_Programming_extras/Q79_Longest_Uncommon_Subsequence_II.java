package Dynamic_Programming_extras;

public class Q79_Longest_Uncommon_Subsequence_II {
    public int findLUSlength(String[] strs) {
        
        int ans = -1 ;
        for(int i = 0 ; i < strs.length ; i++){
            boolean flag = false ;
            for(int j = 0 ; j < strs.length ; j++){
                if( i != j && isSubsequence(strs[i],strs[j]) ){
                    flag = true ;
                    break;
                }
            }
            if(!flag) ans = Math.max(ans,strs[i].length()) ;
        }
        
        return ans ;
    }
    
    boolean isSubsequence(String s1, String s2){ // CHECKS WHETHER S1 IS A SUBSEQ OF S2 OR NOT.
        
        if(s1.length() > s2.length()) return false ;
        int j = 0 ;
        
        for(int i = 0 ; i < s1.length() ; i++){
            char ch = s1.charAt(i) ;
            boolean flag = false ;
            while(j < s2.length() && flag == false){
                if(s2.charAt(j) == ch) flag = true ;
                j++ ;
            }
            if(flag == false) return false ;
        }
        
        return true ;
    }
}

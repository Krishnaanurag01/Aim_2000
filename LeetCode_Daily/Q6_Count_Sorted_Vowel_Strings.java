package LeetCode_Daily ;

public class Q6_Count_Sorted_Vowel_Strings {
    static Integer[][] dp ;
    public int countVowelStrings(int n) {
        // char[] arr = {'a','e','i','o','u'} ;
        dp = new Integer[n+1][26] ;
        return helper(n,'#') ;
    }
    
    int helper(int pos, char prev){
        
        if(pos == 0 ) return 1 ;

        if(prev != '#' && dp[pos][prev - 'a'] != null) return dp[pos][prev - 'a'] ;
        
        int total = 0 ;
        if(prev == '#'){
            total += helper(pos-1,'a'); 
            total += helper(pos-1,'e'); 
            total += helper(pos-1,'i'); 
            total += helper(pos-1,'o'); 
            total += helper(pos-1,'u'); 
        }else if(prev == 'a'){
            total += helper(pos-1,'a'); 
            total += helper(pos-1,'e'); 
            total += helper(pos-1,'i'); 
            total += helper(pos-1,'o'); 
            total += helper(pos-1,'u'); 
        }
        else if(prev == 'e'){
            total += helper(pos-1,'e'); 
            total += helper(pos-1,'i'); 
            total += helper(pos-1,'o'); 
            total += helper(pos-1,'u'); 
        }
        else if(prev == 'i'){
            total += helper(pos-1,'i'); 
            total += helper(pos-1,'o'); 
            total += helper(pos-1,'u');             
        }
        else if(prev == 'o'){ 
            total += helper(pos-1,'o'); 
            total += helper(pos-1,'u'); 
        }
        else if(prev == 'u'){
            total += helper(pos-1,'u'); 
        }
        
        if(prev != '#')
        dp[pos][prev - 'a'] = total;
        return  total ;
    }
    
}
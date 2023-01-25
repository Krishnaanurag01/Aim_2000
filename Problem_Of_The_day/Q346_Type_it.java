package Problem_Of_The_day;
public class Q346_Type_it {

    int ans ;
    int minOperation(String s) {
        
        ans = (int)1e9 ;
        helper(0, s, "",0, true); 
        return ans ;
    }
    
    void helper(int idx, String s, String ss, int move, boolean avail){
        if(idx >= s.length()){ // means we have made the ss equals to s.
          ans = Math.min(ans, move) ;// choose min move answer formation
          return ;  
        } 
        
        if(avail == false){ // this denotes that we have already performed the second operation so no we only can 1 char at a time so it will take n - idx moves morre.
            ans = Math.min(ans, move +( s.length() - idx ));
            return  ;
        } 
        
        char ch = s.charAt(idx) ;
        helper(idx+1, s, ss+ch, move + 1, avail) ; // append by 1 char only
        
        if(avail){ // when 2nd operation is available then try with that.
        // check is we can double the ss (if we add at end then size becomes double) and after doubling it matches till now with s
        if(ss.length() * 2 <= s.length() && (ss + ss).equals(s.substring(0,ss.length() * 2))){
            avail = false; // now as have already used it so don't allow again this operation.
            helper(ss.length() * 2, s, ss+ss, move+1, avail) ;
        }
        }
    }
}

package Problem_Of_The_day;

public class Q142_Repeated_Substring_Pattern {

    public boolean repeatedSubstringPattern(String s) {
        
        StringBuilder sb = new StringBuilder() ;
        for(int i = 0 ; i < s.length()/2 ; i++){
            sb.append(s.charAt(i)) ;
            if(s.length() % sb.length() != 0) continue ; // this means sb.length string can not make s as to make s or length let say 12 -> sb length should be 2,3,4,6(means their combii can make 12)
            if(helper(sb.toString(),i+1,s)) return true;
        }
        
        return false;
    }
    
    boolean helper(String ssf, int idx, String s){
        
        // checking is s is multiple of ssf or not.
        while(idx < s.length() ){
            if(idx + ssf.length() - 1 >= s.length()) return false;
            if(ssf.equals(s.substring(idx, idx + ssf.length())) == false) return false;
            idx += ssf.length() ;
        }
        
        return true ;
    }
}

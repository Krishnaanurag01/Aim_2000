package Problem_Of_The_day;

/**
 * Q93_Check_if_One_String_Swap_Can_Make_Strings_Equal
 */
public class Q93_Check_if_One_String_Swap_Can_Make_Strings_Equal {

    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.length() != s2.length()) return false ;
        if(s1.equals(s2)) return true ;
        
        int count = 0 ;
        int[] freqArr = new int[26] ;
        
        for(int i = 0 ; i < s1.length() ; i++){
            if(s1.charAt(i) != s2.charAt(i)) count++ ;
            if(count > 2) return false ;
            char ch1 = s1.charAt(i) ;
            char ch2 = s2.charAt(i) ;
            freqArr[ch1-'a']++ ;
            freqArr[ch2-'a']-- ;
        }
        
        for(int val : freqArr) if(val != 0 ) return false;
        return count == 2 ;
    }
}
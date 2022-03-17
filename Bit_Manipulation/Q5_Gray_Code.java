package Bit_Manipulation;
import java.util.*;

public class Q5_Gray_Code {

    public ArrayList<String> graycode(int n)
    {
        // when n == 1 then return "0" and "1" as they are valid 1 bit gray code
        if( n == 1){
            ArrayList<String> ans = new ArrayList<>() ;
            ans.add("0") ;
            ans.add("1") ;
            return ans ;
        }
        
        ArrayList<String> list = graycode(n-1) ; // else get code n-1
        
        // and make answer
        ArrayList<String> nans = new ArrayList<>() ;
        
        // add prefix 0 in n-1 ans list as 0 make no changes when added in lead so add directly

        for(int i = 0 ; i < list.size() ; i++ ){
            String bs = list.get(i) ;
            nans.add("0"+bs) ;
        }

        // now add 1 in prefix by chosing element from n-1 to 0 . this way our sequence will maintain changes in only one bit
        
        for(int i = list.size() - 1 ; i >= 0 ; i-- ){
            String bs = list.get(i) ;
            nans.add("1"+bs) ;
        }
        
        return nans ;
    }

    // leetcode solution

    public List<Integer> grayCode(int n) {

        if( n == 1){
            List<Integer> ans = new ArrayList<>() ;
            ans.add(0) ;
            ans.add(1) ;
            return ans ;
        }
        
        List<Integer> list = grayCode(n-1) ;
        List<Integer> nans = new ArrayList<>(list) ;
        
       int add = (int)Math.pow(2,n-1) ; // as we will add last number from n-1 list with current number
        
        for(int i = list.size() - 1 ; i >= 0 ; i-- ){
            int bs = list.get(i) ;
            nans.add(bs + add ) ;
        }
        
        return nans ;
    }
    
}

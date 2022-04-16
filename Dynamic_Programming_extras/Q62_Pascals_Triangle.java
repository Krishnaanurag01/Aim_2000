package Dynamic_Programming_extras ;
import java.util.*;

public class Q62_Pascals_Triangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>() ; // ans list
        helper(numRows,ans) ;
        return ans ;
    }
    
    List<Integer> helper(int n, List<List<Integer>> ans){
        
        if(n == 1){
            List<Integer> one = new ArrayList<>() ; // when n is 1 then return a list with 1 and also add this list in ans.
            one.add(1) ;
            ans.add(one) ;
            return one ;
        }
        
        List<Integer> nMinusOne = helper(n-1,ans) ; // getting n-1 list.
        List<Integer> list = new ArrayList<>() ; // forming current list for n.
        
        list.add(1) ; // adding 1 first
        
        // adding middle values
        if(nMinusOne.size() > 1 ){
            for(int i = 0 , j = 1; j < nMinusOne.size() ; i++, j++){
                list.add( nMinusOne.get(i) + nMinusOne.get(j) ) ;
            }
        }
        
        // adding last values.
        list.add(1) ;
        ans.add(list) ;
        return list ;
    }
}

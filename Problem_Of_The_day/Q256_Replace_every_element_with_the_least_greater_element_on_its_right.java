package Problem_Of_The_day ;
import java.util.*;

public class Q256_Replace_every_element_with_the_least_greater_element_on_its_right {
    
    public static ArrayList<Integer> findLeastGreater(int n, int[] arr) {
        TreeSet<Integer> set = new TreeSet<>(); 
        ArrayList<Integer> ans = new ArrayList<>() ;
        Stack<Integer> stack = new Stack<>() ;
        
        for(int i = arr.length - 1; i >= 0 ; i--){
            int val = arr[i] ;
            set.add(val) ;
            
            Integer lg = set.higher(val) ;
            if(lg == null){
                stack.push(-1) ;
            }
            else{
                stack.push(lg) ;
            }
        }
        
        while(stack.size() > 0){
            ans.add(stack.pop()) ;
        }
        
        
        return ans ;
    }
}

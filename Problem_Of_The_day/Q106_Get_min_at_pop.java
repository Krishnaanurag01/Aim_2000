package Problem_Of_The_day;
import java.util.*;

public class Q106_Get_min_at_pop {

    public static Stack<Integer> _push(int arr[],int n)
    {
        Stack<Integer> s =new Stack<>( ) ;
        for(int val : arr){
            s.push(val) ;
        }
        return s ;
    }
    
    //Function to print minimum value in stack each time while popping.
    static void _getMinAtPop(Stack<Integer>s)
    {
        while(s.size() > 0 ){
            int min = s.pop() ;
            System.out.print( Math.min(min,getMin(s)) + " " ) ;
        }
    }
    
    static int getMin(Stack<Integer>s){
        if(s.size() == 0) return (int)1e9 ;
        int val = s.pop() ;
        int min = Math.min(val,getMin(s)) ;
        s.push(val) ;
        return min ;
    }
}

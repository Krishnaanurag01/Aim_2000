package Problem_Of_The_day;
import java.util.*;

public class Q89_Min_sum_formed_by_digits {

    public static long minSum(int arr[], int n)
    {
       Arrays.sort(arr) ;
       StringBuilder sb1 = new StringBuilder() ;
       StringBuilder sb2 = new StringBuilder() ;
       
       for(int i = 0 ; i < n ; i++){
           if(i % 2 == 0) sb1.append(arr[i]) ;
           else sb2.append(arr[i]) ;
       }
       
       long num1 = sb1.length() > 0 ? Long.parseLong(sb1.toString()  ) : 0 ;
       long num2 = sb2.length() > 0 ? Long.parseLong(sb2.toString()  ) : 0 ;
       
       
       return num1 + num2 ;
    }
}

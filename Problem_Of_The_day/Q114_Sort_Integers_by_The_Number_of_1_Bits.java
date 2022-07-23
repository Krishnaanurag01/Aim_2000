package Problem_Of_The_day;
import java.util.*;

public class Q114_Sort_Integers_by_The_Number_of_1_Bits {

    class Comp implements Comparator<Integer>{
        public int compare(Integer o1, Integer o2){
            int sb1 = 0 ;
            int sb2 = 0 ;
            int bkp1 = o1 ;
            int bkp2 = o2 ;
            
            while(o1 > 0){
                int rsb = o1 & -o1 ;
                sb1++;
                o1 = o1 - rsb ;
            }
            
            while(o2 > 0){
                int rsb = o2 & -o2 ;
                sb2++;
                o2 = o2 - rsb ;
            }
            if(sb1 == sb2){
                return bkp1 - bkp2 ;
            }
            return Integer.compare(sb1 ,sb2) ;
        }
    }
    public int[] sortByBits(int[] arr) {
        Integer[] ans = new Integer[arr.length] ;
        for(int i = 0  ; i < arr.length ; i++){
            ans[i] = arr[i] ;
        }
        Arrays.sort(ans, new Comp()) ;
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = ans[i] ;
        }
        return arr ;
    }
}

package Problem_Of_The_day;
import java.util.*;

public class Q185_Counting_elements_in_two_arrays {
    public static ArrayList<Integer> countEleLessThanOrEqual(int arr1[], int arr2[], int m, int n)
    {
        ArrayList<Integer> ans = new ArrayList<>() ;
        Arrays.sort(arr2) ;
        
        int i = 0 ;
        int j = 0 ;
        
        while(i < arr1.length){
            while(j < arr2.length && arr2[j] <= arr1[i]){
                j++ ;
            }
            ans.add(j) ;
            i++;
            j = 0 ;
        }
        
        return ans ;
    }
}
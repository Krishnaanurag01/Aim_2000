package Contests;
import java.util.*;

public class Q1_sum_up_the_beauty {

    public long calcBeauty(int a[], int n){
        HashMap<Integer,TreeSet<Integer>> map = new HashMap<>() ;
        // storing val occurances index in treeset under hashmap
        for(int i = 0 ; i < n ; i++){
            int val = a[i] ;
            map.putIfAbsent(val, new TreeSet<>()) ;
            TreeSet<Integer> set = map.get(val) ;
            set.add(i) ;
        }
        
        long ans = 0 ;
        
        for(int i = 0 ; i < n ; i++){
            // left and right are index's where duplicate of current element present
            Integer left = map.get(a[i]).lower(i) ; 
            Integer right = map.get(a[i]).higher(i) ;
            
            // so the taking the left and right size.
            int left_size = left != null ? i - left : i+1 ;
            int right_size = right != null ? right - i : n - i ;
            
            // leftsize * rightsize => total subarrays where current element is present
            ans += left_size * right_size ;
        }
        
        return ans ;
     }
}

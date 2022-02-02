package Searching_Sorting_level_02;
import java.util.*;

public class Q38_Leaders_in_an_array {


    // method 01 :

    // time comp : O(n) and Space comp : O(n)
    
    static ArrayList<Integer> leaders(int arr[], int n){
        
        int[] rmax = new int[n] ; // this will store the largest element from right end to current index
        rmax[n-1] = arr[n-1] ;
        for(int i = n-2 ; i >= 0 ; i--){
            rmax[i] = arr[i] > rmax[i+1] ? arr[i] : rmax[i+1] ; // checking if current array element is larger or rmax[i+1] element is larger
        }
        

        ArrayList<Integer> ans = new ArrayList<>() ;
        
        for(int i = 0 ; i < n ; i++){
            
            if(rmax[i] <= arr[i]){ // if current element is greater or equal to largest element till now from right end then add it to the answer
                ans.add(arr[i]) ;
            }
        }
        
        return ans ;
    }

    // method 02 :
    // time comp is : O(n Logn) and space is : O(1)

    static ArrayList<Integer> leaders2(int arr[], int n){
        
        int rmax = Integer.MIN_VALUE ;
        ArrayList<Integer> ans = new ArrayList<>() ;
        
        for(int i = n-1 ; i >= 0 ; i--){
            if(rmax <= arr[i]){
                rmax = arr[i] ;
                ans.add(arr[i]) ;
            }
        }
        
        Collections.reverse(ans) ;
        
        return ans ;
    }

}

package Recursion_and_backtracking_level_02;
import java.util.*;

public class Q19_Tug_Of_War {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in) ; 
        int n = sc.nextInt() ;

        int[] arr = new int[n] ;

        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt() ;
        }

        minDiff = Integer.MAX_VALUE ;
        ans ="" ;

        helper(arr , 0 , new ArrayList<Integer>() , new ArrayList<Integer>() ,0,0) ;

        sc.close(); 
    }

    private static void helper(int[] arr, int i, ArrayList<Integer> set1, ArrayList<Integer> set2, int sos1,int sos2) {

        if(i >= arr.length){
            int delta = Math.abs(sos1+sos2) ;
            if(delta < minDiff){
                minDiff = delta;
                ans = set1 +" " +set2 ;
            }

            return ;
        }

        // adding current value in first set and genrating
        if(set1.size() < (arr.length+1)/2){  
            set1.add(arr[i]) ;
            helper(arr, i+1, set1, set2, sos1 + arr[i], sos2);
            set1.remove(set1.size()-1) ; // backtracking
        }

        // adding current value in second set and generating answer
        if(set2.size() < (arr.length+1)/2){ 
            
            set2.add(arr[i]) ;
           helper(arr, i+1, set1, set2, sos1, sos2+arr[i]);
            set2.remove(set2.size()-1) ;

        }


    }

    static int minDiff  ;
    static String ans  ;
}

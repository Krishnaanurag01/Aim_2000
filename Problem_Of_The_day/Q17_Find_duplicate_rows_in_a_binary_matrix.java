package Problem_Of_The_day ;
/**
 * Q17_Find_duplicate_rows_in_a_binary_matrix
 */

import java.util.*;
public class Q17_Find_duplicate_rows_in_a_binary_matrix {

    public static ArrayList<Integer> repeatedRows(int matrix[][], int m, int n)
    {
        //code here
        
        ArrayList<Integer> ans = new ArrayList<>(); 
        HashSet<String> set = new HashSet<>() ;
        String s = "" ;
        
        for(int i = 0 ; i< m ; i++){
            for(int j = 0 ;j < n ; j++){
                
                s += matrix[i][j] ;
            }
            
            if( !set.contains(s) ){
                set.add(s) ;
            }
            else{
                ans.add(i) ;
            }
            
            s = "" ;
        }
        
        return ans ;
        
    }

    
}
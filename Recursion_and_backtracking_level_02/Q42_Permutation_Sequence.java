package Recursion_and_backtracking_level_02;
import java.util.*;

public class Q42_Permutation_Sequence {

    public String getPermutation(int n, int k) {
        
        int fact = 1 ; 
        ArrayList<Integer> numbers = new ArrayList<>() ;
        
        for(int i = 1 ; i < n ; i++){
            fact = fact * i ; // calculating the fact of n-1. because each number can have fact no of sequence starting with it self
            numbers.add(i) ;
        }
        
        numbers.add(n) ;
        String ans = "" ;
        k = k -1 ; // making k 0 based indexed 
        
        while(true){
            ans += numbers.get(k/fact); // this is the digit that will fall into our sequence
            numbers.remove(k/fact); 
             
            if(numbers.size() == 0) return ans ;
            
            k = k % fact ; // now we have to find the other digit or in general we are going more deep of sequence
            
            fact = fact / numbers.size( ) ;       // this is the fact of remaining group
        }
       
    }
}

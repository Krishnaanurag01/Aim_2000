package LeetCode_Contests.Contest_311;

public class Q1_Smallest_Even_Multiple {

    public int smallestEvenMultiple(int n) {
        
        while(n % n != 0 || n % 2 != 0){
            n = n + n ; 
        }
        return n ;
    }
}

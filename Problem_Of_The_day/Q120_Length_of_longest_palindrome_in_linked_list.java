package Problem_Of_The_day;
import java.util.*;

public class Q120_Length_of_longest_palindrome_in_linked_list {

    class Node{
        int data ;
        Node next ;
    }

    // converting linkedlist into list.
    public static int maxPalindrome(Node head)
    {
      List<Integer> list = new ArrayList<>() ;
      Node curr = head ;
      while(curr != null){
          list.add(curr.data) ;
          curr = curr.next ;
      }
      
      return helper(list) ;
    }
    
    static int helper(List<Integer> list){
        
        boolean[][] dp = new boolean[list.size()][list.size()] ;
        
        int ans = 0 ;
        
        for(int g = 0 ; g < list.size() ; g++){
        for(int i = 0 , j = g ; j < list.size() ; j++,i++){
            
            if(g == 0){
                dp[i][j] = true ;
            }
            else if(g == 1){
                dp[i][j] = list.get(i) == list.get(j) ;
            }
            else{
                if(list.get(i) == list.get(j)){
                    dp[i][j] = dp[i+1][j-1] ;
                }
                else{
                    dp[i][j] = false ;
                }
            }
            if(dp[i][j]){
                ans = Math.max(ans,j-i+1) ;
            }
        }
        }
        
        return ans ;
    }
}

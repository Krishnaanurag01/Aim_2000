package Problem_Of_The_day;
import java.util.*;

public class Q262_Stepping_Numbers {

    int steppingNumbers(int n, int m){
        
        int ans = 0 ;
        int size = (m+"").length() ;
        LinkedList<Integer> ll = new LinkedList<>() ;
        
        if(size > 1){
            if(n < 10){ // we are adding count of single digit number manually.
                ans += (10 - n) ;
            }
            
            for(int i = 1; i <= 9 ; i++){ // for bfs we are adding single digit
                ll.add(i);
            }
        }
        else{
            return m - n + 1 ; // if range is single digit number then return count.
        }
    
          
        // running bfs.    
        while(ll.size() > 0){
           
            Integer rf = ll.removeFirst() ;
            if(rf >= n && rf <= m && rf > 9){
                    ans++;
            }
                
            if(String.valueOf(rf).length() == size){ // if size reached then skip further.
                continue ;
            }
            
            
            int ld = rf % 10 ;
            
            if(ld - 1 >= 0){ // adding next lesser adjecent digit
                ll.add( (rf * 10) + (ld-1));
            }
            
            if(ld + 1 < 10){// adding next greater adjecent digit
                ll.add( (rf * 10) + (ld+1));
            }
            
        }
        
        return ans ;
    }
}
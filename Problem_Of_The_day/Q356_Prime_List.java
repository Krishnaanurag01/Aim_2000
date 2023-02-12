package Problem_Of_The_day;
import java.util.*;

public class Q356_Prime_List {

    class Node{
        int val ;
        Node next ;
    }

    Node primeList(Node head){
        boolean[] isPrime = new boolean[(int)1e5] ;
        markPrime(isPrime); // using seive.
        
        Node curr = head ;
        
        while(curr!= null){
            if(curr.val == 1){
                curr.val = 2 ; curr = curr.next ; continue ;
            }
            
            int x = curr.val ; // take the prime from left
            int y = curr.val ; // from right
            
            while(isPrime[x] == false) x-- ;
            while(isPrime[y] == false) y++ ;
            
            if(curr.val - x > y - curr.val) curr.val = y ; // assigning when yth side is near
            else curr.val = x ; // else x is assigned
            curr = curr.next ;
        }
        
        return head;
    }
    
    void markPrime(boolean[] isPrime){
        
        Arrays.fill(isPrime, true) ;
        isPrime[1] = false ;
        isPrime[0] = false ;
        
        for(int i = 2 ; i < isPrime.length ; i++){
            if(isPrime[i] == false) continue ;
            for(int j = i+i ; j < isPrime.length ;  j+= i){
                isPrime[j] = false;
            }
        }
    }
}


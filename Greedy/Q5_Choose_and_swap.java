package Greedy;

import java.util.SortedSet;
import java.util.TreeSet;

public class Q5_Choose_and_swap {

    String chooseandswap(String A){
         
        if(A.length() <= 1) return A;
           // Code Here
           SortedSet<Character> set = new TreeSet<>() ;
           for(char ch : A.toCharArray())
           set.add(ch); // storing all char in set
           
           for(int i = 0 ; i < A.length() && set.size() != 1 ; i++){ // if set has only one char then it will not run
               char ch = A.charAt(i) ; // finding first char
               set.remove(ch); // and removing the current char
               if(set.first() < ch ){ // if set.top element is less than current char then perform operation
                  A = A.replaceAll(ch+"","}"); // update all ch with "{"   // ccad - > (took ch = c and top is a) }}ad 
                   A = A.replaceAll(set.first()+"",ch+""); // now  update set top with ch - > "}}ad" -> "}}cd"
                   A = A.replaceAll("}",set.first()+""); // --> "}}cd" --> "aacd"
                   
                   break ;
                   }
                   
                   
               }
               
                return A ;
           }
    
}

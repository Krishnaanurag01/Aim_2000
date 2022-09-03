package Problem_Of_The_day;
import java.util.*;

public class Q219_Numbers_With_Same_Consecutive_Differences {

    //method 02 : faster one. using bfs.

    public int[] numsSameConsecDiff2(int n, int k){

        // using BFS
        LinkedList<Integer> q = new LinkedList<>() ;
       
        // adding all the singleton number first.
        for(int i = 1 ; i <= 9 ; i++){
            q.add(i);
        }
        
        int m = 1 ; // this will help us to decide when to stop making new numbers.
        while(q.size() > 0){
            if(n == m) break;
            int size = q.size() ;
            while(size-- > 0){ 
                int rn = q.removeFirst() ; // getting first number
                int ld = rn % 10 ; // and it's last digit
                
                for(int i = 0 ; i <= 9 ; i++){
                    if(Math.abs(ld - i) == k) q.add(rn*10 + i) ; // trying 0 - 9 and adding new number with of m size.
                }
            }
            m++;
        }

        return q.stream().mapToInt(i -> i).toArray() ; // converting to array.
    }





    

    // method 01 : using dfs..
    public int[] numsSameConsecDiff(int n, int k){
        ArrayList<Integer> list = new ArrayList<>() ;
        
        // first digit can't be zero so starting from 1 to 9.
        for(int i = 1 ; i <= 9 ; i++){
         helper(n-1,i+"",i, k,list) ; // and calling a recursive function for other part.
        }
        
        return list.stream().mapToInt(i -> i).toArray() ;
    }
    
    public void helper(int n, String nsf,int prev, int k, ArrayList<Integer> list){
        if(n == 0) { // add to answer.
            list.add(Integer.parseInt(nsf)) ;
            return;
        }
        
        // goes from 0 to 9
        for(int i = 0 ; i <= 9 ; i++){
            if(Math.abs(prev - i) == k){ // if the absolute diff is equals to K then you can use this digit.
               helper(n-1, nsf+i, i, k, list);   
            }
        }
    }
}

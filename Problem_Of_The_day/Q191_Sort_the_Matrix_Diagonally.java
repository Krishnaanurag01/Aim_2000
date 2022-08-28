package Problem_Of_The_day;
import java.util.*;

public class Q191_Sort_the_Matrix_Diagonally {

    public int[][] diagonalSort(int[][] mat) {
     
        // first taking the diagonal that are below 0th row.
        for(int i = mat.length - 2 ; i >= 0 ; i--){
            PriorityQueue<Integer> pq = new PriorityQueue<>() ;
            int m = i ;
            int n = 0 ;
            
            // taking the diagonal value in pq.
            while(m < mat.length && n < mat[0].length){ 
                pq.add(mat[m][n]) ;
                m++ ;
                n++ ;
            }
            
            m = i ;
            n = 0 ;
            
            // and storing them in asc order.
            while(m < mat.length && n < mat[0].length){
                mat[m][n] = pq.poll() ;
                m++;
                n++;
            }
        }
        
        // now taking the diagonal after 0th col.
        for(int j = 1 ; j < mat[0].length - 1 ; j++){
            int m = 0 ;
            int n = j ;
            PriorityQueue<Integer> pq = new PriorityQueue<>() ;
            
            while(m < mat.length && n < mat[0].length){
                pq.add(mat[m][n]) ;
                m++ ;
                n++ ;
            }
            
            m = 0 ;
            n = j ;
            
            while(m < mat.length && n < mat[0].length){
                mat[m][n] = pq.poll() ;
                m++;
                n++;
            }
            
        }
        
        return mat ;
    }
}

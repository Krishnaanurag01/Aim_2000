package Searching_Sorting_level_02;
import java.util.*;

public class Q1_Marks_of_PCM {
    
    class Maths implements Comparable<Maths>{
        
        int p ; // physics marks
        int c ; // checm marks
        int m ; // maths marks
        
        Maths(int x , int y , int z){
            p = x ;
            c = y ;
            m = z ;
        }
        
        public int compareTo( Maths o){

            if(this.p != o.p){  // if physics marks is not equal then sort it on the basis of physics marks
                return this.p - o.p ;
            }
            else if(this.c != o.p){ // when physics marks is equal check if chem marks not equal then sort on chem marks
                return this.c - o.c ;
            }
            else{ // if both physics and chem marks are equal then sort on ascending order of maths marks. 
                return this.m - o.m ;
            }
        }
        
    }
    
    public void customSort (int phy[], int chem[], int math[], int N)
    {
        // your code here
        Maths[] arr = new Maths[N] ;
        
        for(int i = 0 ; i < N ; i++){
            arr[i] = new Maths(phy[i],chem[i],math[i]) ;
        }
        
        Arrays.sort(arr) ;
        
        for(int i = 0 ; i < N ; i++){
            phy[i] = arr[i].p ;
            chem[i] = arr[i].c ;
            math[i] = arr[i].m ;
         }
    }

}

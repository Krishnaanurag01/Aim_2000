package HashMap_and_Heap;
import java.util.*;


public class Q2_Common_elements_1 {
public static void main(String[] args) throws Exception {
    // write your code here
    
    Scanner sc = new Scanner( System.in ) ;
    
    int n1 = sc.nextInt() ;
    HashSet<Integer> set = new HashSet<>() ;
    
    for(int i = 0 ; i < n1 ; i++){
        set.add( sc.nextInt() ) ;
    }
    
    
    int n2 = sc.nextInt() ;
    int[] arr2 = new int[n2] ;
    
    for(int i = 0 ; i < n2 ; i++){
        arr2[i] = sc.nextInt() ;
    }
    
    HashSet<Integer> set2 = new HashSet<>() ;
    
    for(int i : arr2){
        
        if(set2.contains(i) == false && set.contains(i) == true ){
            System.out.println(i) ;
            set2.add(i) ;
        }
    }
    
    sc.close();
    
    
 }

}
    
package HashMap_and_Heap;
import java.io.*;
import java.util.*;

public class Q3_Common_element_2 {
    

    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in )) ;
        int n1 = Integer.parseInt( br.readLine()) ;
        int[] arr1 = new int[n1] ;
        for(int i = 0 ; i < n1 ; i++){
            arr1[i] = Integer.parseInt( br.readLine() ) ;
        }
        
        
        int n2 = Integer.parseInt( br.readLine()) ;
        int[] arr2 = new int[n2] ;
        for(int i = 0 ; i < n2 ; i++){
            arr2[i] = Integer.parseInt( br.readLine() ) ;
        }
        
        
        HashMap<Integer,Integer> map1 = new HashMap<>() ;
        
        for(int i : arr1){
            map1.put(i , map1.getOrDefault(i,0)+1) ;
        }
    
        
        HashMap<Integer,Integer> map2 = new HashMap<>() ;
        
        for(int i : arr2){
            map2.put(i , map2.getOrDefault(i,0)+1) ;
        }
    
    
        for(Integer e : map1.keySet()){
            if(map2.containsKey(e)){
                int f1 = map1.get(e);
                int f2 = map2.get(e) ;
    
                if(f1 <  f2){
                    for(int i = 0 ; i < f1 ; i++){
                        System.out.println(e) ;
                    }
                }
                else{
                    for(int i = 0 ; i < f1 ; i++){
                        System.out.println(e) ;
                    }
                }
            }
        }
    
    }
}

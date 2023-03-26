package Problem_Of_The_day ;

public class Q383_Frogs_and_Jumps {

public int unvisitedLeaves(int N, int leaves, int frogs[]){
    boolean[] arr = new boolean[leaves+1] ;
    
    for(int f : frogs){
        if(f > leaves) continue ; 
        
        // makes jump of f in arr if not done before
        if(arr[f] == false){ // means not visited so visit
            for(int i = f ; i < arr.length ; i += f){
                arr[i] = true ; // means visited
            }
        }
    }
    
    int count = 0 ;
    
    for(int i = 1 ; i < arr.length ; i++){
        if(arr[i] == false) count++ ;
    }
    
    return count ;
}
}

package Problem_Of_The_day ;

public class Q138_Jump_Game_III {
    
    boolean[] visited ;
    public boolean canReach(int[] arr, int start) {
        
        visited = new boolean[arr.length] ;
        return helper(arr,start) ;
    }
    
    boolean helper(int[] arr, int idx){
        if(arr[idx] == 0) return true ;
        visited[idx] = true ;
        
        if(idx + arr[idx]  < arr.length && visited[idx + arr[idx]] == false && helper(arr,idx + arr[idx])) return true ;
        if(idx - arr[idx]  >= 0 && visited[idx - arr[idx]]  == false && helper(arr,idx - arr[idx])) return true ;
        
        visited[idx] = false ;
        
        
        return false;
    }
    
}

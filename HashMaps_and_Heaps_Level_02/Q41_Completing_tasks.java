package HashMaps_and_Heaps_Level_02;
import java.util.*;

public class Q41_Completing_tasks {

    static class Tasks{
        ArrayList<Integer> tanya,manya ;

        Tasks(){
            tanya = new ArrayList<>() ;
            manya = new ArrayList<>() ;
        }
    }

    Tasks findTasks(int[] arr, int m, int n) {
        
        HashSet<Integer> set = new HashSet<>() ;
        
        // storing the completed task in set.
        for(int i : arr){
            set.add(i) ;
        }
        
        Tasks task = new Tasks() ;
        
        int turn = 0 ; // 0 for tanya and 1 for manya 
        
        // assigning tasks in alternate fashion.
        for(int i = 1 ; i <= n ; i++){
            if(set.contains(i) ) continue ; // if task is already completed then skip
            
            // else allocate to tanya or manya in alternate fashion

            if(turn % 2 == 0){ 
                task.tanya.add(i) ;
                turn++ ;
            }
            else{
                task.manya.add(i) ;
                turn++ ;
            }
        }
        
        return task ;
    }
    
}

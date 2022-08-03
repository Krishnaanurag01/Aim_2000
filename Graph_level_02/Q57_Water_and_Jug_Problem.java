package Graph_level_02;

import java.util.*;

public class Q57_Water_and_Jug_Problem {

    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {

        int combinedJug = jug1Capacity + jug2Capacity; // making a jug with combined capacity
        if (combinedJug < targetCapacity)
            return false; // means even if we will both we still not be able to measure the target

        boolean[] visited = new boolean[combinedJug + 1];
        LinkedList<Integer> q = new LinkedList<>();
        q.add(0); // because initally both the jug is empty
        visited[0] = true;
        int[] operations = { jug1Capacity, -jug1Capacity, jug2Capacity, -jug2Capacity }; // we can add or subtract cap1
                                                                                         // and same with cap2

        while (q.size() > 0) {
            int CurrCap = q.removeFirst();

            if (CurrCap == targetCapacity)
                return true;

            for (int i = 0; i < 4; i++) {
                int newCap = CurrCap + operations[i];

                if (newCap < 0 || newCap > combinedJug) { // if the new capacity of jug is less than 0 or greater than
                                                          // target then skip
                    continue;
                }

                if (newCap == targetCapacity)
                    return true; // else if target then return true

                if (visited[newCap] == false) {
                    q.add(newCap); // else if not visited then add it to queue.
                    visited[newCap] = true;
                }
            }
        }

        return false;
    }

    // dfs approch : a bit slower

    public boolean canMeasureWater2(int jug1Capacity, int jug2Capacity, int targetCapacity) {

        int combinedJug = jug1Capacity + jug2Capacity; // making a jug with combined capacity
        if (combinedJug < targetCapacity)
            return false;

        boolean[] visited = new boolean[combinedJug + 1];
        int[] operations = { jug1Capacity, -jug1Capacity, jug2Capacity, -jug2Capacity }; // we can add or subtract cap1
                                                                                         // and same with cap2

        return helper(0, combinedJug, visited, operations, targetCapacity);
    }

    boolean helper(int currCap , int maxCap, boolean[] visited, int[] opr, int targetCap){
        if(currCap == targetCap) return true ;
        visited[currCap] = true ;
        
        for(int i = 0 ; i < 4 ; i++){
                int newCap = currCap + opr[i] ;
                
                if(newCap < 0 || newCap > maxCap){ // if the new capacity of jug is less than 0 or greater than target then skip
                    continue ;
                }
                
                if(newCap == targetCap) return true; // else if target then return true
                
                if(visited[newCap] == false){
                  if( helper(newCap,maxCap,visited,opr,targetCap) ) return true ;  
                }
        }
        
        return false;
    }
}

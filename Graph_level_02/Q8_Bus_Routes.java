package Graph_level_02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Q8_Bus_Routes {


    public static int numBusesToDestination(int[][] routes, int source, int target) {
        
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>() ; // this will store how many busses comes on a single busstop.

        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {

                int bus_stop = routes[i][j] ; // this is bus stop
                ArrayList<Integer> bus_list = map.getOrDefault(bus_stop, new ArrayList<>()) ;

                bus_list.add(i) ; // adding ith bus

                map.put(bus_stop, bus_list) ; // storing in map.

            }
        }


        LinkedList<Integer> queue = new LinkedList<>() ; // for bfs
        HashSet<Integer> bus_set = new HashSet<>() ; // bus visited
        HashSet<Integer> bus_stop_set = new HashSet<>() ; // bus stop visited

        queue.add(source) ; // adding source bus stop in queue and bus stop set.
        bus_stop_set.add(source) ;
        
        int level = 0 ;


        while (queue.size() > 0) {
            // size of current level.
            int size = queue.size() ; // help in level order traversal.

            while (size-- > 0) {

                int removed_bus_stop = queue.removeFirst() ; // removing the first bus stop.

                if( removed_bus_stop == target){ // if it is the target bus stop then return level
                    return level ;
                }

                // o\w
                ArrayList<Integer> busses = map.get(removed_bus_stop) ; // now getting list of all busses that comes on removed bus stop.

                for (Integer bus : busses) {
                    // if the bus is already visited then continue.
                    if(bus_set.contains(bus) == true){
                        continue ;
                    }

                    // else making bus visited by adding it to the bus set.
                    bus_set.add(bus) ;

                    for (Integer bus_stopss : routes[bus]) { // now checking each bus stop where bus goes
                        
                        if(bus_stop_set.contains(bus_stopss) == true){ // if the busstop is already visited then skip it.
                            continue ;
                        }

                        queue.add(bus_stopss) ; // else add it to the queue and bus stop set.
                        bus_stop_set.add(bus_stopss);
                    }
                }

                
            }
            level++ ; // increasing level.
        }

        return -1 ; // if we didn't reach the destination bus stop then return -1.
    }
    
}

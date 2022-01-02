package Greedy;

import java.util.*;


public class Q11_Minimum_Cost_to_cut_a_board_into_squares {


    public static void main(String[] args) {
        int m = 5, n = 3;
        Integer X[] = {2, 1, 3, 1, 4};
        Integer Y[] = {4, 1, 2};

        get_min_cost(Y, X , m , n) ;
    }

    public static void get_min_cost(Integer[] horizontal , Integer[] vertical , int m , int n) {
        

        // sorting both the horizontal and vertical  array in descending order.

        Arrays.sort(horizontal, Collections.reverseOrder());
        Arrays.sort(vertical , Collections.reverseOrder());


        // index for horizontal and vertical array.
        int h = 0 ;
        int v = 0 ;

        int hc = 1 , vc = 1 ; // hc -> horizontal count initially and vc -> vertical count intially
        int cost = 0 ;  
        while (h < n && v < m) {
            
            if (horizontal[h] <= vertical[v]) { // choosing the larger cost cut first as if we cut the larger cut first then it will cost us low cost becuase initially the horizontal and vertical count is very less.
                cost += vertical[v]*vc ; // cutting vertically * no of vertical count.
                hc++; // increasing horizontal count because if we cut down vertically then it partition array into two parts horizontally.
                v++;
            }
            else{ // vice verse.
                cost += horizontal[h]*hc ;
                vc++;
                h++;
            }
            
        }


        while (h < n ) { // if horizontl cut left then again perform for this only.
            cost += horizontal[h]*hc ;
            vc++;
            h++;
        }

        while (v < m ) { // if vertical cut left then again perform for this only.
            cost += vertical[v]*vc ;
            hc++;
            v++;
        }


        System.out.println(cost);

    }


    // with array lists.
    public static int boardCutting(ArrayList<Integer> horizontal, ArrayList<Integer> vertical, int m, int n)
    {
        
        Collections.sort(horizontal, Collections.reverseOrder());
        Collections.sort(vertical , Collections.reverseOrder());

        int h = 0 ;
        int v = 0 ;

        int hc = 1 , vc = 1 ;
        int cost = 0 ; 
        while (h < m-1 && v < n-1 ) {
            
            if (horizontal.get(h) <= vertical.get(v)) {
                cost += vertical.get(v)*vc ;
                hc++;
                v++;
            }
            else{
                cost += horizontal.get(h)*hc ;
                vc++;
                h++;
            }
            
        }


        while (h < m-1 ) {
            cost += horizontal.get(h)*hc ;
            vc++;
            h++;
        }

        while (v < n-1 ) {
            cost += vertical.get(v)*vc ;
            hc++;
            v++;
        }


        return cost;

    }
    
}

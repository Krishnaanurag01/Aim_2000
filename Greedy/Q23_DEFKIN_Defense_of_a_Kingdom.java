package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Q23_DEFKIN_Defense_of_a_Kingdom {

    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader( System.in)) ;

        int t = Integer.parseInt(br.readLine()) ;

        // testcase loop
        for (int k = 0; k < t ; k++) { // running every test case

            String[] whn = br.readLine().split(" ") ;
        int w = Integer.parseInt(whn[0]) ;
        int h = Integer.parseInt(whn[1]) ; ;
        int n = Integer.parseInt(whn[2]) ; ;

        PriorityQueue<Integer> q1 = new PriorityQueue<>() ; //_for_max_width
        PriorityQueue<Integer> q2 = new PriorityQueue<>() ; //_for_max_height


        q1.add(w+1) ; // adding last width +1 for distance between last tower and boundary
        q2.add(h+1) ; // same for height

        for (int i = 0; i < n ; i++) {

            String[] tower_i_j = br.readLine().split(" ") ;  // i denotes height and j denotes width

            int nh = Integer.parseInt( tower_i_j[1] ) ;// this is height
            int nw = Integer.parseInt( tower_i_j[0] ) ; // this is width

            q1.add(nw) ;
            q2.add(nh) ;

        }

        int lw = 0 ; // last width
        int max_width = 0 ;

        while (q1.size() != 0) {
            Integer tw = q1.remove() ;
            max_width = Math.max(max_width, tw-lw -1) ; // calculatig the distance between last tower and current tower.
            lw = tw ; // updating current tower as last tower for next tower.
        }


        
        int lh = 0 ; // last height
        int max_height = 0 ;

        while (q2.size() != 0) {
            Integer th = q2.remove() ;
            max_height = Math.max(max_height, th-lh -1) ;// calculatig the distance between last tower and current tower.
            lh = th ;// updating current tower as last tower for next tower.
        }

        // System.out.println( max_height + "  " + max_width);

        System.out.println( max_height*max_width );


            
        }

        

    }
    
}

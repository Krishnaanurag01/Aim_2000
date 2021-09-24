package Dynamic_Programming_level_01;

public class Q14_Count_possible_ways_to_construct_buildings {

    public static void main(String[] args) {

        get_total_way_to_construct_buildings(3);
        
    }


    // same as previous two question , here building is (binary 0) and space is( binary 1) and two consecutives building not allowed.
    public static void get_total_way_to_construct_buildings(int n ) {

        int ob = 1 ; // old building
        int os = 1 ; // old space 

        for (int i = 2 ; i <= n ; i++) {// same concept.
            int nb = os;
            int ns = ob + os ;

            ob = nb ;
            os = ns ;
        }

        int answer = ob + os  ;
        int final_ans = answer*answer ; // here finding the square because we have to arrange building both side of the road. so for 1 arrangement of first side of road there can answer(calculated above) arrangement of another side.
        // thats why finding square. 
        System.out.println(final_ans);
        
    }
    
}

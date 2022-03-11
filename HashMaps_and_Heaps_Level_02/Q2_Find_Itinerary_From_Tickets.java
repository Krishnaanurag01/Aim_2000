package HashMaps_and_Heaps_Level_02;
import java.util.*;

public class Q2_Find_Itinerary_From_Tickets {

    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int noofpairs_src_des = scn.nextInt();
		HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < noofpairs_src_des; i++) {
			String s1 = scn.next();
			String s2 = scn.next();
			map.put(s1, s2);	
		}
        scn.close();


		HashMap<String,Boolean> psrc = new HashMap<>() ; // storing potential Source

		for(String src  : map.keySet()){
			String dest = map.get(src) ;

			psrc.put(dest,false) ; // destination could never be the potential source
			
			if(psrc.containsKey(src) == false){ // if map already has src then that must be the destination becuase only destination is we are storing directly so do not add , else add with true
				psrc.put(src,true) ;
			}
		}

		String srce = "" ; // getting the potential source

		for (String src : psrc.keySet()) {
			if(psrc.get(src) == true){
				srce = src ;
				break ;
			}
		}

        // adding to answer
		while(true){

			if(map.containsKey(srce)){ // checking if we can move from srce
				System.out.print(srce + " -> ");
				srce = map.get(srce) ; // moving to next tuicket
			}
			else{
				System.out.print(srce + "."); // ending at the last stopage.
				break ;
			}
		}


	}
    
}

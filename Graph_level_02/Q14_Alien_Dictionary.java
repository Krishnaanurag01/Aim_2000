package Graph_level_02;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Q14_Alien_Dictionary {

    public String findOrder(String [] dict, int N, int K)
    {
        
        HashMap<Character , HashSet<Character> > map = new HashMap<>() ;
        HashMap<Character,Integer> indegree = new HashMap<>() ;

        for (String string : dict) {
            for (char ch : string.toCharArray()) {
                indegree.put(ch, 0 ) ;
            }
        }


        for (int i = 0; i < dict.length - 1 ; i++) {
            
            String curr = dict[i] ;
            String next = dict[i+1] ;

            int len = Math.min(curr.length() , next.length() ) ;

            for (int j = 0; j < len ; j++) {
                
                char ch1 = curr.charAt(j);
                char ch2 = next.charAt(j);

                if(ch1 != ch2 ){

                    if(map.containsKey(ch1)){

                        HashSet<Character> set = map.get(ch1) ;
                        set.add(ch2) ;
                        map.put(ch1, set) ;
                        indegree.put(ch2, indegree.get(ch2) + 1 ) ;

                    }
                    else{

                        HashSet<Character> set = new HashSet<>() ;

                        set.add(ch2) ;
                        map.put(ch1, set) ;
                        indegree.put(ch2, indegree.get(ch2) + 1 ) ;


                    }

                    break ;

                }



            }
        }



        LinkedList<Character> queue = new LinkedList<>() ;
        StringBuilder sb = new StringBuilder() ;

        for (Character ch : indegree.keySet()) {

            if(indegree.get(ch) == 0){
                queue.add(ch) ;
            }
            
        }
        

        int count = 0 ;

        while (queue.size() > 0 ) {

            Character rem = queue.removeFirst() ;
            sb.append(rem) ;
            count++ ;

            if(map.containsKey(rem) == true){

                HashSet<Character> set = map.get(rem) ;


                for (Character nbr : set) {
                    indegree.put(nbr, indegree.get(nbr) - 1) ;

                    if(indegree.get(nbr) == 0 ){
                        queue.add(nbr) ;
                    }
                }

            }
            
        }


        if(count == indegree.size() ){
            return sb.toString() ;
        }
        else{
            return "" ;
        }
        
    }
    
}

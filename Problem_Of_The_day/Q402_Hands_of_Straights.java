package Problem_Of_The_day; 

public class Q402_Hands_of_Straights {
    static boolean isStraightHand(int N, int groupSize, int hand[]) {
        Arrays.sort(hand) ;
        HashMap<Integer,Integer> map = new HashMap<>() ;
        
        // storing val -> freq
        for(int i = 0 ; i < N; i++) {
            int val = hand[i] ;
            map.put(val, map.getOrDefault(val,0)+1) ;
        }
        
       for(int val : hand){
        
           
           if(map.containsKey(val) == false) continue ; // now present means used already
           int temp = groupSize ;  // else take this temp group size
// and consecutive numbers and update their freq after using it.
           while(temp-- > 0){
               if(map.containsKey(val) == false) return false ;
               
               int freq = map.get(val) ;
               if(freq == 1){
                   map.remove(val) ;
               }
               else{
                   map.put(val, freq - 1) ;
               }
               val++ ;
           }
       }
        
        
        return true ;
    }    
}

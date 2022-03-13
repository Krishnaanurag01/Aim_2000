package HashMaps_and_Heaps_Level_02;
import java.util.*;

public class Q49_Maximum_Frequency_Stack {


    // starts from here.

    class FreqStack {
    
        HashMap<Integer, LinkedList<Integer>> st ; // stores max freq as key and stack consist of all element that has freq equals to key.
        
        HashMap<Integer,Integer> fmap ; // frequency map
        int maxfreq ; // will contain the max frequency of element.
    
        public FreqStack() {
            st = new HashMap<>() ;
            fmap = new HashMap<>();
            maxfreq = 0 ;
        }
        
        public void push(int val) {
            
            fmap.put(val, fmap.getOrDefault(val,0)+1) ; // incrementing the freq of current val
            
            int freq= fmap.get(val) ; // not getting the freq of current element after incrementing
            
            if(st.containsKey(freq) == false ){
                st.put(freq, new LinkedList<Integer>() ) ; // initializing the stack with corresponding freq.
            }
            
            st.get(freq).addFirst(val) ; // adding on top.
            maxfreq = Math.max(maxfreq, fmap.get(val)) ; // updating the max frequency
        }
        
        public int pop() {
            
            // getting the max freq element.
            
            int val = st.get(maxfreq).removeFirst() ;
            
            if(st.get(maxfreq).size() == 0){
                // means stack becomes empty that means we don't have any more element of maxFreq so decrease the maxFreq.
                maxfreq-- ;
            }
            
            // also decrement the freq of val in fmap.
            
            int freq = fmap.get(val) ;
            
            if(freq == 1){
                fmap.remove(val) ;
            }
            else{
                fmap.put(val,freq-1) ;
            }
            
            return val ;
            
        }
    }


    // ends here.
    
}

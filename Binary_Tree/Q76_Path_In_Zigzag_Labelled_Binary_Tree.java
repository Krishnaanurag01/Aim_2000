package Binary_Tree;
import java.util.*;

public class Q76_Path_In_Zigzag_Labelled_Binary_Tree {

    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> ans = new ArrayList<>() ;
        
        int llv = 1 ; // last level value => start of current level ;
        int currLvlVal = 0; // current level Value
        
        while(currLvlVal < label){
            currLvlVal += llv ;
            llv *= 2 ; // getting llv for next level
        }
        
        llv /= 2 ; // as it was added extra so coming to last level; 
        
        while(label != 1){
            ans.add(label) ;
            int comp = 3*llv - label - 1 ;
            int parent = comp/2 ;
            label = parent ; // going to parent
            llv /= 2 ; // getting llv of parent level.
        }
        
        ans.add(1) ; // adding the top most parent.
        Collections.reverse(ans) ;
        return ans ;
        
    }
    
}

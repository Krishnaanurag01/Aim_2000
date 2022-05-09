package LeetCode_Daily;
import java.util.*;

public class Q5_Flatten_Nested_List_Iterator {

    public interface NestedInteger {
        
             // @return true if this NestedInteger holds a single integer, rather than a nested list.
             public boolean isInteger();
        
             // @return the single integer that this NestedInteger holds, if it holds a single integer
             // Return null if this NestedInteger holds a nested list
             public Integer getInteger();
        
             // @return the nested list that this NestedInteger holds, if it holds a nested list
             // Return empty list if this NestedInteger holds a single integer
             public List<NestedInteger> getList();
         }

    public class NestedIterator implements Iterator<Integer> {

        List<Integer> flatten ;
        int idx ;
        public NestedIterator(List<NestedInteger> nestedList) {
            
            flatten = new ArrayList<>() ;
            idx = 0 ;
            // doing preprocessing that is adding all the value in the int list in start
            for(NestedInteger ni : nestedList){
                helper(ni,flatten) ;
            }
        }
    
        @Override
        public Integer next() {
            return flatten.get(idx++) ;
        }
    
        @Override
        public boolean hasNext() {
            return idx < flatten.size() ;
        }
        
        void helper(NestedInteger ni, List<Integer> flatten){
            
            if(ni.isInteger()){
                flatten.add( ni.getInteger()) ;
            }
            else{
                for(NestedInteger ini: ni.getList()){
                    helper(ini,flatten);
                }
            }
        }
    }
    
}

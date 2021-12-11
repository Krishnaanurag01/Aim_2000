package Stack_and_Queue_level01;
import java.util.*;


public class Q36_Design_a_Stack_With_Increment_Operation {

    int[] values ; // values
    int[] ince ; // increment
    int index;
    
    public void CustomStack(int maxSize) {
        values = new int[maxSize] ; // initializing value and increment array.
        ince = new int[maxSize] ;
        index = -1;
    }
    
    public void push(int x) {
        if(index+1 == values.length){ // if index == size then return 
            return ;
        }
        index++ ;
        values[index] = x ; // storing x as value
        ince[index] = 0 ; // incrementing value 0
        
    }
    
    public int pop() {
        if(index == -1){ // if index is -1 ==> stack is empty
            return -1 ; // so returning -1
        }
        
        int x = values[index] ; // getting index value
        int inc = ince[index] ; // getting increment value
        index-- ; // now drecrementing index
        
        if(index>= 0){ // and if index is 0 or higher then adding increment value to previous index element
            ince[index] += inc ;
        }
        
        
        return  (x + inc) ; // returning result
    }
    
    public void increment(int k, int val) {
        int x = Math.min(k-1,index) ; // choosing index.
        
        if(index >= 0){
            ince[x] += val ; 
        }
    }
    
}

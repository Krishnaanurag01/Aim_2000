package HashMaps_and_Heaps_Level_01;
import java.util.*;

public class Q4_Find_Median_from_Data_Stream {
    
}

class MedianFinder {
    
    PriorityQueue<Integer> left ; // this is max priority queue
    PriorityQueue<Integer> right ; // this is min priority queue

    public MedianFinder() { // intialization when  object is created
        left = new PriorityQueue<>( Collections.reverseOrder() ) ;
        right = new PriorityQueue<>() ;
    }
    
    // adding number to queue.

    public void addNum(int num) {
    
        // if num is greater than right side element then add it to right
        if(right.size() > 0 && num > right.peek() ){
            right.add(num) ;
        }else{ // else add to left
            left.add(num) ;
        }

        // both the priority queue should not have differene of 2 in size.
        
        // if right side have more element then remove and add to left
        if(right.size() - left.size() == 2){
            left.add( right.poll() ) ;
        } // else remove from left and add to right
        else if(left.size() - right.size() == 2){
            right.add( left.poll() ) ;
        }
        
    }
    
    public double findMedian() {
        
         if(size() == 0)
            return -1 ;
        
        
        
            // when left side has more element then return left peek as total element is odd.(becuase left has one extra element in it's side)
        if(this.left.size() > this.right.size() ){
            return left.peek() ;
        } // when right side has more then return from right
        else if(this.right.size() > this.left.size()){
            return right.peek() ;
        }
        else{ // else when size is even(left + right) then return the avg of both middle element
            return (left.peek() * 1.0 + right.peek() * 1.0 )/2.0 ;
        }
        
        
    }

    
    public int size(){
        return this.left.size() + this.right.size() ;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

package HashMaps_and_Heaps_Level_01;

import java.util.ArrayList;

public class Q6_Implement_Priority_Queue_using_Heap_Solution {

    public static void main(String[] args) {

        SelfPriorityQueue q = new SelfPriorityQueue() ;

        q.add(5);
        q.add(6);
        q.add(2);

        System.out.println( q.remove() ) ;

        System.out.println(q.peek());
        
    }


}

class SelfPriorityQueue  {
    
   private ArrayList<Integer> list ; 

    SelfPriorityQueue(){
        list = new ArrayList<>() ;
    }

    // add operation 

    void add(int num){

        list.add(num) ;
        int li = size() -1 ; // this is index of inserted element
        
        upheapify(li) ;// heapifying

    }


    private void upheapify(int li) { // heapifying from down to top

        int pi = (li-1)/2 ; // parent index of li.

        if(pi >= 0 && list.get(pi) > list.get(li) ){ // if parent element is larger then do below operation
            swap(li,pi) ; // swaping
            upheapify(pi); // and call for parent heapification
        }

    }

    // end of add


    // remove operation.

    public int remove(){ // removes the top element

        if(size() == 0){
            System.out.println("Underflow");
            return -1 ;
        }

        int li = size() -1 ; // last index

        int val = list.get(0) ;
        swap(0, li); // swapping the top element with bottom right most element.
        list.remove(size()-1) ; // removing the swapped element
        downHeapify(0) ;


        return val ;
    }


    private void downHeapify(int idx) {

        int minIdx = idx ;

        int lci = 2*minIdx + 1 ; // left child index
        int rci = 2*minIdx + 2 ; // right child index

        // checking if leftt side element is smaller than current element
        if(lci < size() && list.get(lci) < list.get(minIdx ) ){
            minIdx = lci ;
        }

        // checking if right side element is smaller than current element
        if(rci < size() && list.get(rci) < list.get(minIdx ) ){
            minIdx = rci ;
        }

        // swapping if founf the smaller one.
        if(minIdx != idx){
            swap(minIdx, idx);
            downHeapify(minIdx); // and moving next level
        }

    }



    // end of remove


    int peek(){

        if (size() == 0) {
            System.out.println("Underflow"); 
            return -1 ;
        }

        return list.get(0) ;
    }

    private void swap(int li, int pi) {

        int temp = list.get(li) ;
        list.set(li, list.get(pi) ) ;
        list.set(pi, temp) ;
    }

    int size(){
        return list.size() ;
    }
}

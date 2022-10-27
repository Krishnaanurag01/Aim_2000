package Problem_Of_The_day;
import java.util.*;

public class Q267_Print_leaf_nodes_from_preorder_traversal_of_BST {

    public int[] leafNodes(int arr[], int N)
    {
        ArrayList<Integer> l = new ArrayList<>() ;
        
        helper(0,arr.length-1, arr,l) ;
        
        return l.stream().mapToInt(i -> i).toArray() ;
    }
    
    void helper(int idx,int ei, int[] arr, ArrayList<Integer> list){
        
        if(idx >= arr.length) return ; // when out of bound.
        
        // preorder : *ab
        int root = arr[idx] ; // -> root
        
        // finding the a or left part range.
        int left_start = idx + 1 ;
        int left_end = idx ;
        
        // searching the left end 
        while(left_end < arr.length && arr[left_end] <= root){
            left_end++ ;
        }
        
        left_end-- ; // becuase we have incremented one extra
        
        boolean f1 = false ; // if this gets true means current root has either left or right part.
        if(left_end >= left_start){ // if left range is valid then go there.
            f1 = true ;
            helper(left_start, left_end, arr, list) ;
        }

        
        if(left_end + 1 <= ei){ // if right range is valid go there
            f1 = true ;
            helper(left_end + 1, ei, arr, list) ;
        }
        
        if(f1 == false){// if no part is present then current root is leaf so add it to the answer.
            list.add(root) ;
        }
        
    }
}

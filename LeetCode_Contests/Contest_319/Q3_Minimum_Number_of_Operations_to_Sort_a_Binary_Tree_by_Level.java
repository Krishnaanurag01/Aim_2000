package LeetCode_Contests.Contest_319;
import java.util.*;

public class Q3_Minimum_Number_of_Operations_to_Sort_a_Binary_Tree_by_Level {

    public int minimumOperations(TreeNode root) {
        
        int ans = 0 ;
        
        LinkedList<TreeNode> ll = new LinkedList<>() ;
        ll.add(root) ;
        
        while(ll.size() > 0){
            int size = ll.size() ;
            Pair[] arr = new Pair[size] ;
            int k = 0 ;
            
            // taking each level values in the arr in the form of Pair(val,idx)
            while(size-- > 0){
                TreeNode prev = ll.removeFirst() ;
                arr[k] = new Pair(prev.val,k++) ;
                
                // and adding childs in next queue
                if(prev.left != null) ll.add(prev.left) ;
                if(prev.right != null) ll.add(prev.right) ;
            }
            
            // getting min swap to sort the current level
            ans += minSwap(arr) ;
        }
        
        
        return ans ;
    }
    
    int minSwap(Pair[] Arr){
        
        // sorting first
        Arrays.sort(Arr, (a,b) -> a.val - b.val) ;
        int count = 0 ;
        
        for(int i = 0 ; i< Arr.length ; i++){
            if(Arr[i].idx == i) continue ;  // if pair idx is equals to i then skip
            
            while(Arr[i].idx != i){ // until the idx is not same keep swaping 
                Pair temp = Arr[Arr[i].idx] ;
                Arr[Arr[i].idx] = Arr[i] ;
                Arr[i] = temp ;
                count++ ; // and count in every swap
            }
        }
       
        return count ;
    }
    
    class Pair{
        int val ;
        int idx ;
        
        Pair(int x, int y){
            val = x ;
            idx = y ;
        }
    }

    class TreeNode{
        int val ;
        TreeNode left,right ;
    }
}


package Problem_Of_The_day;
import java.util.*;

public class Q207_Find_pairs_with_given_sum_in_doubly_linked_list {

    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>() ;
        if(head == null) return ans ;
        
        Node start = head ;
        Node end = head ;
        
        // moving end to last node.
        while(end.next != null){
            end = end.next ;
        }
        
        // two pointers.
        while(start.data < end.data){
            int sum = start.data + end.data ;
            if(sum == target){
                ArrayList<Integer> list = new ArrayList<>() ;
                list.add(start.data) ;
                list.add(end.data) ;
                ans.add(list) ;
                start = start.next ;
                end = end.prev ;
            }
            else if(sum < target){
                start = start.next ;
            }
            else{
                end = end.prev ;
            }
        }
        
        return ans ;
    }

    class Node{
        int data ;
        Node next,prev ;
    }
}

package Dynamic_Programming_level_02;
import java.util.*;

public class Q111_Most_Frequent_Subtree_Sum {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
       class Solution {
           HashMap<Integer,Integer> map ;
           int max = 0 ;
           public int[] findFrequentTreeSum(TreeNode root) {
               map = new HashMap<>() ;
               helper(root) ;
               System.out.println(map) ;
               
               ArrayList<Integer> list = new ArrayList<>() ;
               
               for(int key : map.keySet()){
                   if(map.get(key) == max){
                       list.add(key);
                   }
               }
       
               return list.stream().mapToInt(i->i).toArray() ;
           }
           
           int helper(TreeNode root){
               if(root == null) return 0 ;
               
               int curr = root.val + helper(root.left) + helper(root.right) ;
               map.put(curr, map.getOrDefault(curr,0)+1);
               max = Math.max(max,map.get(curr));
               return curr; 
           }
}}

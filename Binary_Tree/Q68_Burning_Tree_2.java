package Binary_Tree;
import java.util.*;

public class Q68_Burning_Tree_2 {
    
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    
        TreeNode(int val) {
          this.val = val;
        }
      }
    
      // same as previous question. here we returning the list at  which the tree burnt.
      static ArrayList<ArrayList<Integer>> timeList ; // taking list instead of time.  // oth index contains list of node that burnt of 0th time and so on.
      public static ArrayList<ArrayList<Integer>> burningTree(TreeNode root, int data) {
    
        timeList = new ArrayList<>() ;
            helper(root,data) ;
            return timeList;
      }
    
    
      static int helper(TreeNode root, int target){
            if(root == null) return -1 ;
            
            if(root.val == target){
              ArrayList<Integer> timeZero = new ArrayList<>() ; // as there could be only one node who got burnt at 0 time is target node so adding that in list
              timeZero.add(root.val) ;
              timeList.add(timeZero) ;
    
                getTime(root.left,1,root) ;
                getTime(root.right,1,root);
                return 1 ;
            }
            
            int ld = helper(root.left,target) ;
            int rd = helper(root.right,target) ;
            
            if(ld != -1){
                getTime(root,ld,root.left) ;
                return ld + 1 ;
            }
            else if(rd != -1){
                getTime(root,rd,root.right) ;
                return rd + 1 ;
            }
            
            return -1 ;
        }
    
        static void getTime(TreeNode root, int tsf, TreeNode blockedNode){
            if(root == null || root == blockedNode) return ;
            
            if(tsf == timeList.size()){ // when got new time then initialzie it's list and add the node in it then add to main list.
              ArrayList<Integer> tsfList = new ArrayList<>() ;
              tsfList.add(root.val) ;
              timeList.add(tsfList) ;
            }
            else{
              timeList.get(tsf).add(root.val) ; // else add when lesser time taken.
            }
    
            getTime(root.left,tsf+1, blockedNode) ;
            getTime(root.right,tsf+1,blockedNode) ;
        }
}

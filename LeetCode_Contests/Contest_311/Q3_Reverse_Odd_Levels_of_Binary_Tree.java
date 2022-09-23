package LeetCode_Contests.Contest_311;
import java.util.*;

public class Q3_Reverse_Odd_Levels_of_Binary_Tree {

    public TreeNode reverseOddLevels(TreeNode root) {
        
        if(root == null) return root ;
        
        LinkedList<TreeNode> ll = new LinkedList<>() ;
        int level = 0 ;
        ll.add(root) ;
        
        while(ll.size() > 0 ){
            int size = ll.size() ;
            LinkedList<TreeNode> ln = new LinkedList<>() ;
            Stack<Integer> st = new Stack<>() ;
            
            while(size-- > 0 ){
                TreeNode rn = ll.removeFirst() ;
                ln.add(rn) ;
                st.push(rn.val) ;
                
                if(rn.left != null){
                    ll.add(rn.left );
                }
                
                if(rn.right != null){
                    ll.add(rn.right) ;
                }
            }
            
            if(level % 2 != 0){
                // System.out.println("Came") ;
                while(st.size() > 0 ){
                    TreeNode node = ln.removeFirst() ;
                    int temp = st.pop() ;
                    // System.out.println(node.val +" - "+temp );
                    node.val = temp ;
                }
            }
            
            level++ ;
        }
        
        return root ;
        
    }
    class TreeNode {
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
}

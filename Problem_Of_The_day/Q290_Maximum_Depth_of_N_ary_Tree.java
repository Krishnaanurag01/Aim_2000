package Problem_Of_The_day;
import java.util.*;

public class Q290_Maximum_Depth_of_N_ary_Tree {

    public int maxDepth(Node root) {
        
        return helper(root) ;
    }
    
    int helper(Node root){
        if(root == null) return 0 ;
        
        int max = 0 ;
        for(Node child : root.children){
            max = Math.max(max,helper(child)) ;
        }
        
        return max + 1 ;
    }
    
    class Node {
        public int val;
        public List<Node> children;
    
        public Node() {}
    
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}

package Problem_Of_The_day;
import java.util.*;

public class Q170_Nary_Tree_Level_Order_Traversal {

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
    };


    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>() ;
        if(root == null) return ans ;
        
        LinkedList<Node> q = new LinkedList<>() ;
        q.add(root) ;
        
        while(q.size() > 0){
            int size = q.size() ;
            List<Integer> list = new ArrayList<>() ;
            while(size-- > 0){
                Node rn = q.removeFirst() ;
                list.add(rn.val) ; 
                
                for(Node child : rn.children){ // adding child to Queue
                    q.add(child) ;
                }
            }
            ans.add(list) ;
        }
        
        return ans ;
    }
}

package Binary_Tree;
import java.util.*;

// extension of left view of binary tree

public class Q11_1_Find_Bottom_Left_Tree_Value {

    static class TreeNode {

        int data ; 
        TreeNode left ;
        TreeNode right ;

        public TreeNode(int d) {
            data = d ;
        }
    }

    public int findBottomLeftValue(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        int ans = 0 ;

        LinkedList<TreeNode> queue = new LinkedList<>();  // using linked list for queue with add last , remove first and get first methods.
        queue.addFirst(root);

        while (queue.size() != 0) { // every time this will have a level of tree.
            int size = queue.size(); // here finding the soze of level.
            // adding the first element.
            ans = queue.getFirst().data;  // getting first element of a level for left view.
        

            while (size-- > 0) { // remove every element of current level and add its children.
                // now remove the node and add its child nodes.
                TreeNode rn = queue.removeFirst();
                if(rn.left != null) queue.addLast(rn.left);
                if(rn.right!= null) queue.addLast(rn.right);
            }
        }

        return ans;
    }
    
}

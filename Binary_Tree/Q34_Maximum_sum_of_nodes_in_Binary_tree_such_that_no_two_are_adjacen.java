package Binary_Tree;

import java.util.HashMap;


public class Q34_Maximum_sum_of_nodes_in_Binary_tree_such_that_no_two_are_adjacen {


    static class TreeNode {

        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int d) {
            data = d;
        }
    }


    // time and space is : o(n).


    static HashMap<TreeNode,Integer> map = new HashMap<>() ;
    public static int get_max_sum(TreeNode node) {

        if(node == null) return 0 ; // when node is null return sum 0 

        if(map.containsKey(node)){// when the node we loooking for already available in map (acts as a dp) then return its value.
            return map.get(node) ;
        }

        // now find the sum : if we including the current element or excluding the current node.
        int including = node.data ; // first including the current node.

        if(node.left != null){  // if its left and right not equals to null then it means we can goleft and right childrens.
            // becuase we caan not directly add two nodes which are adjecent.
            including += get_max_sum(node.left.left); // so we are looking into its child of child.
            including += get_max_sum(node.left.right);
        }
        if(node.right != null){ // same as above for right child of child.
            including += get_max_sum(node.right.left);
            including += get_max_sum(node.right.right);
        }

        // now calculating the sum when current element is excluding.
        // for this we simply skip the current node and look into children nodes.
        int excluding = get_max_sum(node.left) + get_max_sum(node.right) ;

        int maxIs = Math.max(including, excluding) ; // now choosing between including sum and excluding sum , whichever has larger value  will be selected.
// and then stored in map so that we can use again when we come to this node from somewhere else.
        map.put(node, maxIs) ;

        // and then returning the stored value. this is returned when map has not saved any key with this node.
        return map.get(node) ;
        
    }














    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.left.left = new TreeNode(1);    
        
       System.out.println( get_max_sum(root) );
        // System.out.println(sum);
    }
    
}

package Binary_Tree;

import java.util.ArrayList;
import java.util.LinkedList;



public class Q11_left_view_of_binary_tree {

    private static TreeNode root ;

    static class TreeNode {

        int data ; 
        TreeNode left ;
        TreeNode right ;

        public TreeNode(int d) {
            data = d ;
        }
    }



    // iterative way  : 
    // time and space : o(n) & o(height)



    public static ArrayList<Integer> get_left_view(TreeNode root) {
        if(root == null){
            return null;
        }
        ArrayList<Integer> ansList = new ArrayList<>();

        LinkedList<TreeNode> queue = new LinkedList<>();  // using linked list for queue with add last , remove first and get first methods.
        queue.addFirst(root);

        while (queue.size() != 0) { // every time this will have a level of tree.
            int size = queue.size(); // here finding the soze of level.
            // adding the first element.
            ansList.add(queue.getFirst().data);  // getting first element of a level for left view.
        

            while (size-- > 0) { // remove every element of current level and add its children.
                // now remove the node and add its child nodes.
                TreeNode rn = queue.removeFirst();
                if(rn.left != null) queue.addLast(rn.left);
                if(rn.right!= null) queue.addLast(rn.right);
            }
        }

        return ansList;
    }

    // recursive solution :
    // time and space  : o(n) & o(n)

    public static ArrayList<Integer> leftView_recursively(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>() ;
        if(root == null){
            return list;
        }
        leftView_recursive(root , list , 0) ;
        return list ;
    }



    private static void leftView_recursive(TreeNode root2, ArrayList<Integer> list, int level) {
    
        if(root2 == null){
            return ;
        }
        if(level == list.size()){ // when level == size then we can  insert the data.
            list.add(root2.data);
        }

        leftView_recursive(root2.left, list, level+1); // increase the level .  // using left side first gives the left view.
        leftView_recursive(root2.right, list, level+1); // increase the level   // this helps when any node is child of right side and has no left childs.
    }


    public static void main(String[] args) {
        

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);

        // get_left_view(root);

        System.out.println( leftView_recursively(root));
    
    }
    
}

package Binary_Tree;

import java.util.ArrayList;

public class Q41_Morris_Traversal_Inorder {

    TreeNode root ;
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        public TreeNode(int d) { data = d; }
    }

    // takes nearly o(n) time ( o(n) + o(w) for thread) and o(1) space.
    public static ArrayList<Integer> morris_traversal_Inorder(TreeNode root) {
        ArrayList<Integer> list= new ArrayList<>() ;
        TreeNode curr = root ; // take the current as root.
        TreeNode prev;

        while (curr != null) { // traverse untill it becomes null
            if(curr.left == null){ // if left null then print and move to right becuase we already have made thread to root
                list.add(curr.data) ;
                curr = curr.right ;
            }
            else{
                prev = curr.left ; // now if not null then take the left node and search the right most node and then connect it with the root.
                
                while (prev.right != null && prev.right != curr) { // if prev.right is not null and not connected with the root then keep moving.
                    prev = prev.right ;
                }
                // now we have two case ! 1st is prev.right could be null or it could be not null (means it's already threaded)

                if(prev.right == null){ // when null then connect it with the root.
                    prev.right = curr ; // connecting with the root
                    curr = curr.left ; // and move the root to the left.
                }
                else{ // when already connected then delete the right thread.
                    prev.right = null ;
                    list.add(curr.data); // add the data.
                    curr = curr.right ; // and move to right.
                }
            }
        }

        System.out.println(list);



        return list ;
    }



    public static void main(String[] args) {
        
        Q41_Morris_Traversal_Inorder tree = new Q41_Morris_Traversal_Inorder() ;
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);



        morris_traversal_Inorder(tree.root);
    }
    
}

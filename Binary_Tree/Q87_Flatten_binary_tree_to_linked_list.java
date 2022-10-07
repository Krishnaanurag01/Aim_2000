package Binary_Tree;

public class Q87_Flatten_binary_tree_to_linked_list {

    public static void flatten(Node root)
    {
        helper(root) ;
    }
    
    static Node helper(Node root){
        if(root == null) return null ;
        
        Node temp1 = helper(root.left) ; // take the linked list of left child
        Node temp2 = helper(root.right) ; // take the linked list of right child
        
        root.left = null ; // making left pointer null
        
        if(temp1 != null){ // if left ll is not null then
           root.right = temp1 ; // make left ll as next ll of root.
           while(temp1.right != null){ // and not go to tail of left ll
               temp1 = temp1.right ;
           }
           temp1.right = temp2 ; // and attach right ll in the tail of left ll
           
           if(temp2 != null) temp2.left = null ; // make left pointer null
        }
        else{ // if left ll is not present then directly add right ll as next nodes of root
           root.right = temp2 ; 
           if(temp2 != null) temp2.left = null ;
        }
        
        return root ;
    }

    class Node{
        int data ;
        Node left,right ;
    }
}

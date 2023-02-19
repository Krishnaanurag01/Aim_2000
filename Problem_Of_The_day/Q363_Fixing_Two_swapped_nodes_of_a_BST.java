package Problem_Of_The_day;
import java.util.*;

public class Q363_Fixing_Two_swapped_nodes_of_a_BST {

    public Node correctBST(Node root) {
        // code here.
        
        // first find the inorder order.
        ArrayList<Node> inorder = new ArrayList<>() ;
        getInOrder(root, inorder) ;
        
        Node a = null ; // first defective node
        Node b = null ;  // second defective node
        
        // first node is the one which is larger in value but not in ascending order from left
        for(int i = 0 ; i < inorder.size() - 1; i++){
            if(inorder.get(i).data > inorder.get(i+1).data){
                a = inorder.get(i) ;
                break ;
            }
        }
        
        // second node is the one who is smaller in value but not in order from right to left
        for(int i = inorder.size() - 1 ; i >= 1 ; i--){
            if(inorder.get(i).data < inorder.get(i-1).data){
                b = inorder.get(i) ;
                break ;
            }
        }
        
        // now just swap the values.
        int temp = a.data ;
        a.data = b.data ;
        b.data = temp ;
        
        return root ;
    }
    
    void getInOrder(Node root, ArrayList<Node> order){
        if(root == null) return ;
        
        getInOrder(root.left, order) ;
        order.add(root) ;
        getInOrder(root.right, order) ;
    }

    class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
}

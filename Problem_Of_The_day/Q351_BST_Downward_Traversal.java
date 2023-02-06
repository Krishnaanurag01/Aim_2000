package Problem_Of_The_day ;
/**
 * Q351_BST_Downward_Traversal
 */
public class Q351_BST_Downward_Traversal {

    long verticallyDownBST(Node root,int target)
    {
        return helper(root, target) ;
    }
    
    // this will find the target node.
    int helper(Node root, int target){
        if(root == null ) return -1 ;
        if(root.data == target){ // if target is found then get sum of all below nodes lying below in same vertical line
            return getSum(root.left, -1) + getSum(root.right, 1) ;
        }
        
        int left = helper(root.left, target) ;
        if(left != -1) return left ;
        int right = helper(root.right, target) ;
        if(right != -1) return right ;
        return -1;
    }
    
    int getSum(Node root, int pos){
        if(root == null) return 0 ;
        
        int sum = (pos == 0 ? root.data : 0 ); // when pos is 0 means we are below the target node vertical line s0 take the node data.
        sum += getSum(root.left, pos -1) ;
        sum += getSum(root.right, pos +1) ;
        return sum ;
    }
    


    class Node{
        int data ;
        Node left,right ;
    }
}
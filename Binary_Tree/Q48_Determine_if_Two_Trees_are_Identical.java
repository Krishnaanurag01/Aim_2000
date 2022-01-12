package Binary_Tree;

public class Q48_Determine_if_Two_Trees_are_Identical {
    
    class Node{
        int data;
        Node left,right;
        Node(int d)
        {
            data=d;
            left=null;
            right=null;
        }

    }

    boolean isIdentical(Node root1, Node root2)
	{
	    if(root1 == null && root2 == null) return true ;
	    if(root1 == null || root2 == null) return false ;
	    
	    if(root1.data == root2.data && isIdentical(root1.left,root2.left) && isIdentical(root1.right,root2.right) ){
	        return true ;
	    }
	    
	    return false ;
	}

}

package Binary_Search_Tree;

public class Q31_Fixing_Two_nodes_of_a_BST {


    public static class Node {

        int data;
        Node left, right;
        public Node(int d) {
            this.data = d;
        }

    }


    // Here am using morris trvaersal for O(1) space but we can also use basic recursive inorder traversal.
    public Node correctBST(Node root)
    {


        Node curr = root ; 
        // larger and smaller will hold those two nodes that are not sorted or that are swapped.
        Node larger = null ;
        Node smaller = null ;
        // we will carry previous node so that we can check whether current node is greater than previous or not.
        Node prev = null ;
        
        // using morris alsgo : check explanation in binary tree package.
        while(curr != null ){
            Node left = curr.left ;
            if(left == null ){
                
                if(prev != null && prev.data > curr.data){ // if prev is not null and greater than current node then do following.
                    if(larger == null) // check if larger came before or not if not then also update the larger.(it's like first point)
                    {
                        larger = prev ;
                    } // and smaller is like last point, so keep updating smaller everytime.
                    smaller = curr ;
                }
            prev = curr;  // making current node prev so that we can check next node with current node.
            curr = curr.right ;
           }
            else{
                Node rightMostNode = getRightMostNode(left,curr) ;
                
                if(rightMostNode.right == null){
                    rightMostNode.right = curr ;
                    curr = curr.left ;
                }
                else{
                    rightMostNode.right = null ;
                    
                    if(prev != null && prev.data > curr.data){ // if prev is not null and greater than current node then do following.
                        if(larger == null) // check if larger came before or not if not then also update the larger.(it's like first point)
                        {
                            larger = prev ;
                        } // and smaller is like last point, so keep updating smaller everytime.
                        smaller = curr ;
                    }
                    prev = curr;  // making current node prev so that we can check next node with current node.              
                    curr = curr.right ;
                }
            }
        }
    
        // now just swap the values of both the nodes.
        
        int temp = larger.data ;
        larger.data = smaller.data ;
        smaller.data = temp ;
        
        return root;
    }
    
    
    
    // getting right most node
    public Node getRightMostNode(Node node, Node curr){
        
        while(node.right != null && node.right != curr){
            node = node.right ;
        }
        
        return node ;
    }
    
}

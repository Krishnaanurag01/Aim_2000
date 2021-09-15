package Binary_Search_Tree;



public class Q10_Construct_Binary_Search_Tree_FromInOrder_Traversal {

    Node root;

    public static class Node {

        int data;
        Node left, right;
        public Node(int d) {
            this.data = d;
        }

    }


    public static Node construct_BST_From_InOrder(int[] inorder) { // as for inorder the middle element is root. so we are applying kinda binary search intution here .
        int end = inorder.length - 1 ;
        int start = 0 ;

        return BST_FROM_INORDER(inorder,start,end) ;

    }



    private static Node BST_FROM_INORDER(int[] inorder, int start, int end) {

        if(start > end)  // when start becomes greater then return .
        return null;

        int mid = ( start + end ) / 2 ; // else find mid index. 

        Node node = new Node(inorder[mid]); // make node with it. (first will be our root)
        node.left = BST_FROM_INORDER(inorder, start, mid - 1); // now do the same  operation in left part
        node.right = BST_FROM_INORDER(inorder, mid + 1 , end) ; // and right part 

        return node ; // return node .
    }



    public static void preOrder(Node root) {
        if(root == null) return ;

        System.out.print(root.data +" ");
        preOrder(root.left);
        preOrder(root.right);
    }



    public static void main(String[] args) {
        int[] inorder = {10 , 20 , 30 , 100 , 150 , 200 , 300} ;
        Node root = construct_BST_From_InOrder(inorder) ;

        preOrder(root);
        
    }
    
}

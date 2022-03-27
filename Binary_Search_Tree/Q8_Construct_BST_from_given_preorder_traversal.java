package Binary_Search_Tree;


public class Q8_Construct_BST_from_given_preorder_traversal {
    
    Node root;

    public static class Node {

        int data;
        Node left, right;
        public Node(int d) {
            this.data = d;
        }

    }

    public void insert_node(int data) {
        root = insert_node(root, data);
    }

    public static Node insert_node(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (root.data > data) {
            root.left = insert_node(root.left, data);
        } else {
            root.right = insert_node(root.right, data);
        }

        return root;
    }


    public static void preOrder(Node root) {
        if(root == null) return ;

        System.out.print(root.data +" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static Node constructTree(int[] pre) { 
        if(pre.length == 0) return null ;

        int left_range = - (int) 1e9 - 1 ;  // take left range as - infinit (min integer value - 1) 
        int right_range = (int) 1e9 + 1 ;   // take right range as infinit (max integer value + 1)

        return constructTree(pre,left_range , right_range); // now construct with it.
    }


    static int index = 0 ;
    private static Node constructTree(int[] pre, int left_range, int right_range) {
          // when index is greater or equal  then we performed for  all the nodes so return it. 
          // otherwise when arr[index] is less than or greater than left and right range then return.
        if(index >= pre.length || pre[index] < left_range || pre[index] > right_range){
            return null ;
        }
        Node node = new Node(pre[index++]) ;  // otherwise make a node .
        node.left = constructTree(pre,left_range , node.data);  // perform same with different range in left.
        node.right = constructTree(pre, node.data  ,right_range) ; // and different for right .

        return node;
    }

    public static void main(String[] args) {


        int pre[] = new int[] { 10, 5, 1, 7, 40, 50 };

        Node root = constructTree(pre) ;

        preOrder(root);
        
    }


    // leetcode solution : 

    class Solution {
        public Node bstFromPreorder(int[] preorder) {
            return helper(preorder,0,preorder.length-1) ; //paasing to helper function with some ranges.
        }
        
        public Node helper(int[] pre, int si, int ei){
            
            if(si > ei ) return null ;
            
            Node root = new Node( pre[si] ) ; // creating root node by taking the first node of preorder(that is always root)
            if(si == ei) return root ; // if both become equal then simply return.
    
            int rootIdx = si+1 ; // this is the index where the first element arrives that is greater than root.
            while(rootIdx < pre.length && pre[rootIdx] < pre[si]) rootIdx++ ;
            
            root.left = helper(pre,si+1,rootIdx - 1) ; // so sending left with range si +1 to rootTdx-1(that is first greater element -1)
            root.right = helper(pre, rootIdx, ei ) ;// right range is first greater element to end.
            return root ;
        }
    }
}

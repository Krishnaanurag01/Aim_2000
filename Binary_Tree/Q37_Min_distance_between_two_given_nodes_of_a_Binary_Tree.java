package Binary_Tree;


public class Q37_Min_distance_between_two_given_nodes_of_a_Binary_Tree {

    TreeNode root ;
    
    static class TreeNode {

        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int d) {
            data = d;
        }
    }


    // public static int minDustance(TreeNode root , int a , int b) {

    //     if(root == null){
    //         return 0 ;
    //     }
        
    //     int left = minDustance(root.left, a, b);
    //     int right = minDustance(root.right, a, b) ;

    //     if(root.data == a || root.data == b){
    //         return 1 ;
    //     }
    //     if(left != 0 && right != 0 ){
    //         return left + right ;
    //     }

    //     if(left == 0 && right == 0) return 0 ;

    //     return left==0 ? right : left + 1 ;
        
    // }


    // lca same as previous.
    public static TreeNode getLCA(TreeNode node , int n1 , int n2) {
        if(node == null || node.data == n1 || node.data == n2){
            return node ;
        }

        TreeNode left =  getLCA(node.left, n1, n2) ;
        TreeNode right = getLCA(node.right, n1, n2) ;

        if(left == null){ // means left part does not have any of the element
            return right ;
        }
        else if(right == null){ // means right part does not have any of the element
            return left ;
        }
        else{ // when both has element then current node is the lowest common ancestor
            return node ;
        }
    }


    // distance from lca to node.
    public static int lca_to_node(TreeNode lca , int n) {

        if(lca == null) return 0 ; // when reached null return 0 

        if(lca.data == n){ // when found return 1.
            return 1 ;
        }


        int left = lca_to_node(lca.left, n); // moving left side 
        int right = lca_to_node(lca.right, n); // moving right side


        if(left == 0 && right == 0) return 0 ;  //when both left and right is 0 then it means we didn't find the desired node yet so return 0.

        // otherwise if any one of both is not null then we find the node already then return the length with + 1 for current node length.
        return left + right + 1 ;
    }
















    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.right = new TreeNode(8);

        TreeNode lca = getLCA(root, 4, 6); // first find the common point(which is lca) of both nodes values .

        int n1 = lca_to_node(lca, 4) ; // now calculate the distance from lca to value.
        int n2 = lca_to_node(lca, 6);

        System.out.println(n1 + n2 ); // add both distance and subtract by 2 becuase we calculated the total nodes for both value insted of total edges. eg : in above tree lca is 1 and from 1 to 4 => 3 nodes present and 1 to 6 => 3 nodes present so toal becomes 6 and if we subtract both the 4 and 6 value nodes then we get the total distance ( edges).

        // System.out.println(minDustance(root, 4, 6));
        
    }
    
}

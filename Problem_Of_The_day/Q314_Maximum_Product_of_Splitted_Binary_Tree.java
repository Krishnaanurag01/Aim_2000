package Problem_Of_The_day;

public class Q314_Maximum_Product_of_Splitted_Binary_Tree {

    // using this node class for forming a new tree.
    class Node{
        int val ;
        long sum ;
        Node left ;
        Node right ;
        
        Node(int val, long x, Node l, Node r){
            this.val = val ;
            sum = x ;
            left = l ;
            right = r ;
        }
    }
    class TreeNode{
        int val ;
        TreeNode left,right ;
    }

    long total ; // total sum of entire tree
    long max ; // answer
    int mod = (int)1e9 + 7 ;
    
    public int maxProduct(TreeNode root) {
        Node nroot = reConstruct(root) ; // forming a new tree with Node class
        total = nroot.sum ;
        max = 0 ;
        helper(nroot) ;
        
        return (int)(max % mod); // returning answer by doing modulo
    }
    
    void helper(Node node){
        if(node == null) return ;
        
        if(node.left != null){ // if theres a edge in left
            long other = total - node.left.sum ; // taking the other sum
            max = Math.max(max,  node.left.sum * other) ; // finding the max answer
        }
        
        if(node.right != null){ // if theres a edge in right
            long other = total - node.right.sum ;
            max = Math.max(max,  node.right.sum * other ) ;
        }
     
        helper(node.left) ;
        helper(node.right) ;
    }
    
    Node reConstruct(TreeNode root){
        if(root == null) return null ;
        
        Node left = reConstruct(root.left);
        Node right = reConstruct(root.right);

        long sum = root.val + (left != null ? left.sum : 0) + (right != null ? right.sum : 0) ;
        Node node = new Node(root.val , sum , left, right) ;
        
        return node ;
    }
}

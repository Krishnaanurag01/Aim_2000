package Binary_Tree;

public class Q61_Serialize_and_Deserialize_Binary_Tree {

    class TreeNode{
        int val ;
        TreeNode left, right ;

        TreeNode(int data){val = data ;}
    }
    
    // create tree in some string format sequence so that we can again make tree from string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder() ;
        helper(root,sb) ;
        return sb.toString() ;
    }
    
    void helper(TreeNode root, StringBuilder sb){
        
        if(root == null){ // assign null for null nodes as well
            sb.append("null,");
            return ;
        }

        // adding sequence in preorder.
        
        sb.append(root.val+",") ; 
        
        helper(root.left,sb) ;
        helper(root.right,sb) ;
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        String[] arr = data.split(",") ; // now spilitting the string on ","
        idx = 0 ;
        return helperDecode(arr) ;
    }
    
    static int idx ;
    TreeNode helperDecode(String[] arr){
        
        if(arr[idx].equals("null")){
            idx++ ;
            return null ;
        }
        
        int val = Integer.parseInt(arr[idx]) ; // get the int value
        TreeNode root = new TreeNode(val) ; // create node with it
        idx++ ;
        
        root.left = helperDecode(arr) ; // and assing next in it's left
        root.right = helperDecode(arr) ; // and right
        
        return root ;
        
    }
}

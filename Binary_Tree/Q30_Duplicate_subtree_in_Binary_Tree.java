package Binary_Tree;

import java.util.*;



public class Q30_Duplicate_subtree_in_Binary_Tree {

    private static TreeNode root ;

    static class TreeNode {

        int data ; 
        TreeNode left ;
        TreeNode right ;

        public TreeNode(int d) {
            data = d ;
        }
    }




    List<TreeNode> result;
    Map<String,Integer> map;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map=new HashMap<>();
        result=new LinkedList<>();
        traverse(root);
        return result;
    }
    
    String traverse(TreeNode root){
        if(root==null){
            return "N";
        }
        String value=root.data+","+traverse(root.left)+","+traverse(root.right);
        map.put(value,map.getOrDefault(value,0)+1);
        if(map.get(value)==2){
            result.add(root);
        }
        return value;
    }



 

    // gfg solution :

   

    public static String contains_duplicate(TreeNode node, HashSet<String> subTree) {
        if(node == null){ // when reach null return "$"
            return "$";
        }

        String s = "";

        String lstr = contains_duplicate(node.left, subTree); // finding in left part.
        if(lstr.equals(s)){  // this method runs when we found one subtree this will help in not running the process ahead and started returning for the answer.  // when line 80 becomes true the it will return "".
            return s ;
        }

        String rstr = contains_duplicate(node.right, subTree); // finding in right part.
        if(rstr.equals(s)){
            // this method runs when we found one subtree this will help in not running the process ahead and started returning for the answer.
            return s ;
        }

        s = s + node.data + lstr + rstr ; // making string of subtree.

        if(s.length() > 3 && subTree.contains(s)){ // here s.length > 3 means if s length is 3 then its string is something like this 
            // "a$$" which is nothing but leaf node which we don't have to pass. so when our string is not of elaf node and someone already made that string then it will return "" and from this moment this method will start returning the ans.
            return "";
        }

        subTree.add(s); // o\w add  to the set and return.

        return s ;

    }



















    public static void main(String[] args) {
        root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.left.right.right = new TreeNode(14);
        root.left.right.left = new TreeNode(10);
        root.right.right = new TreeNode(25);

        // System.out.println(contains_sub_tree(root));

        HashSet<String> set = new HashSet<>() ;
        
       System.out.println( contains_duplicate(root, set)==""?1:0);


    }
    
}

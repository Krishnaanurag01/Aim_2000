package Binary_Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;


public class Q40_Check_if_Tree_is_Isomorphic {

    private  TreeNode root ;

    static class TreeNode {

        int data ; 
        TreeNode left ;
        TreeNode right ;

        public TreeNode(int d) {
            data = d ;
        }
    }



    // method - 01 : taking alot of extra space and time.

    public static boolean is_isomorphic(TreeNode root1 , TreeNode root2) {

        if(root1 == null || root2 == null){
            return root1 == root2 ;
        }

        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>() ;

        LinkedList<TreeNode> queue = new LinkedList<>() ;

        queue.add(root1);

        while (queue.size() != 0) {
            int size = queue.size() ;
            while (size-- > 0) {
                TreeNode node = queue.removeFirst() ;

                ArrayList<Integer> list = new ArrayList<>() ;

                map.put(node.data, list) ;

                if(node.left != null){
                    queue.addLast(node.left);
                   map.get(node.data).add(node.left.data);
                    
                }

                if(node.right != null){
                    queue.addLast(node.right);
                    map.get(node.data).add(node.right.data);
                }
            }
        }
        
        queue = new LinkedList<>() ;

        queue.add(root2);
        while(queue.size() != 0){
            int size = queue.size() ;
            while (size-- >0) {
                TreeNode node = queue.removeFirst() ;
                
                if(!map.containsKey(node.data)){
                    return false ;
                }


                if(node.left != null){
                    queue.addLast(node.left);
                  if( !map.get(node.data).contains(node.left.data)){
                      return false;
                  }
                    
                }

                if(node.right != null){
                    queue.addLast(node.right);
                    if( !map.get(node.data).contains(node.right.data)){
                        return false;
                    }
                }
            }
        }


        return true;
    }

    // method -2  : taking no extra space and o(n) time .





    public static boolean is_isomorphic2(TreeNode root1 , TreeNode root2) {
        if(root1 == null || root2 == null){
            return root1 == root2 ;
        }

        if(root1.data != root2.data){
            return false ;
        }


        return is_isomorphic2(root1.left, root2.left) && is_isomorphic2(root1.right, root2.right) 
                        || is_isomorphic2(root1.left, root2.right) && is_isomorphic2(root1.right, root2.left) ;
    }









    public static void main(String[] args) {

        Q40_Check_if_Tree_is_Isomorphic tree = new Q40_Check_if_Tree_is_Isomorphic() ;

        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(6);
        tree.root.left.right.left = new TreeNode(7);
        tree.root.left.right.right = new TreeNode(8);
  
        Q40_Check_if_Tree_is_Isomorphic tree2 = new Q40_Check_if_Tree_is_Isomorphic();

        tree2.root = new TreeNode(1);
        tree2.root.left = new TreeNode(3);
        tree2.root.right = new TreeNode(2);
        tree2.root.right.left = new TreeNode(4);
        tree2.root.right.right = new TreeNode(5);
        tree2.root.left.right = new TreeNode(6);
        tree2.root.right.right.left = new TreeNode(8);
        tree2.root.right.right.right = new TreeNode(7);


        System.out.println(is_isomorphic(tree.root, tree2.root));

        System.out.println(is_isomorphic2(tree.root, tree2.root));
  

        
    }
    
}

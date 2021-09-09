package Binary_Tree;

import java.util.HashMap;

public class Q26_Construct_the_Binary_Tree_from_Postorder_and_Inorder_Traversal {



     static class TreeNode {

        int data ; 
        TreeNode left ;
        TreeNode right ;

        public TreeNode(int d) {
            data = d ;
        }
    }



    // its same as q25.



    public static TreeNode buildTree(int[] postOrder , int inOrder[]) {
        
        HashMap<Integer,Integer> map = new HashMap<>() ;

        for (int i = 0; i < inOrder.length; i++) {
            map.put(inOrder[i], i);
        }

        int postStart = 0 ;
        int postEnd = postOrder.length - 1 ;
        int inStart = 0 ;
        int inEnd = inOrder.length - 1 ;

        return buildTree2(postOrder , postStart, postEnd , inOrder , inStart , inEnd , map);
    }




    private static TreeNode buildTree2(int[] postOrder, int postStart, int postEnd, int[] inOrder, int inStart,
            int inEnd, HashMap<Integer, Integer> map) {


        if(postStart > postEnd || inStart > inEnd) return null ;

        TreeNode root = new TreeNode(postOrder[postEnd]); // the difference is here, here we are making root of postorder last element(which is always  root).

        int root_indx = map.get(root.data);  // here doing the same thing which we did in Q25. (getting the root index from map)
        int leftElements = root_indx - inStart ; // and findng left elements in inorder.


        // now sending postorder start and postorder strat + left elements  - 1 this will be the next post order for left side.
        // and in order as usual.
        root.left = buildTree2(postOrder, postStart, postStart + leftElements-1, inOrder, inStart, root_indx - 1 , map);

        //
        root.right = buildTree2(postOrder, postStart+leftElements, postEnd - 1, inOrder, root_indx + 1 , inEnd, map);

        return root ;

    }


















    public static void main(String[] args) {
        
    }
    
}

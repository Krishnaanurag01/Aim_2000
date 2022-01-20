 package Binary_Tree;

import java.util.HashMap;

public class Q25_Construct_a_Binary_Tree_from_Preorder_and_inorder_Traversal {

    // private static TreeNode root ;

    static class TreeNode {

        int data ; 
        TreeNode left ;
        TreeNode right ;

        public TreeNode(int d) {
            data = d ;
        }
    }

    // method 1 : time and space is O(n).

    public static TreeNode buildTree(int[] preorder , int[] inorder) {
        

        HashMap<Integer,Integer> map = new HashMap<>(); // for storing the index of inorder so that we won't calculate the length of left and right side again and again each time.

        for (int i = 0; i < inorder.length ; i++) {
            map.put(inorder[i],i); // storing the index.
        }


        int preStart = 0 ;
        int preEnd = preorder.length - 1;
        int inStart = 0 ;
        int inEnd = inorder.length - 1 ;

        return buildTree(preorder,preStart,preEnd, inorder,inStart,inEnd,map);
    }


    private static TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,
            HashMap<Integer, Integer> map) {

        if(preStart > preEnd || inStart > inEnd) return null ; // return null otherwise it will give error.

        TreeNode root = new TreeNode(preorder[preStart]); // now make the node .

        int rootIdx = map.get(root.data); // find the root index in inorder .that will be the main key for further steps.
        int leftElements = rootIdx - inStart ;// finding the length of rest elements.


        // now send preorder with prestart + 1 for next tree and preEnd will be prestart + left elements.
        // and inorder will be 0 to root - 1. this contains the left part.
        root.left = buildTree(preorder, preStart + 1 , preStart + leftElements , inorder, inStart , rootIdx - 1 , map);


        // now for right side send preorder with preStart + left elements + 1 (because the left side is left part of tree.) to preend.
        // and inorder will start from root index of inorder + 1 ( this will be our right side.) to the end.
        root.right = buildTree(preorder, preStart + leftElements + 1 , preEnd, inorder, rootIdx + 1, inEnd, map);

        return root;
    }


    // method - 02  ;

    // this is same as above but without the hashmap.

    public static TreeNode buildTree1(int[] preorder , int[] inorder) {

       return buildTree2(preorder,0,preorder.length-1, inorder, 0, inorder.length-1);
        
    }


    private static TreeNode buildTree2(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {

        if(preStart > preEnd || inStart > inEnd){
            return null ;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        int root_val = root.data;
        // int preIdx = preStart ;
        int root_idx = inStart ; /// root value index in inorder.
        

        while (inorder[root_idx] != root_val) { // finding the root element in inorder.
            root_idx++;
        }

        int leftElements = root_idx - inStart ; // left elements in inorder of root.

        root.left = buildTree2(preorder, preStart+1, preStart + leftElements , inorder, inStart, root_idx - 1 );
        root.right = buildTree2(preorder, preStart+leftElements+1, preEnd , inorder, root_idx + 1 , inEnd );

        return root ;
    }



















    public static void main(String[] args) {

    //    System.out.println( buildTree(new int[]{1,6,8,7},new int[]{1,6,7,8}).data);

    System.out.println(Math.sqrt(9));
        
    }
    
}

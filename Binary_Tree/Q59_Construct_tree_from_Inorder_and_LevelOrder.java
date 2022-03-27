package Binary_Tree;
import java.util.*;

public class Q59_Construct_tree_from_Inorder_and_LevelOrder {

    public static class Node {
        int data;
        Node left,right ;
        Node(int data) {
          this.data = data;
        }
    }


    // starts from here.
    Node buildTree(int inord[], int level[])
    {
        
        int n = inord.length - 1 ;
        
        return helper(inord, 0, n, level) ;
    }
    
    Node helper(int[] inord, int startIdx, int endIdx, int[] level){
        
        if(startIdx > endIdx) return null ;
        
        Node node = new Node( level[0] ); // making root nodes by choosing the first node of level order .
        if(level.length == 1) return node;
        int rootVal = node.data ; // getting root val
        int rootIdx = startIdx ; // now finding the index of root in inorder.
        
        while(inord[rootIdx] != rootVal ) rootIdx++ ;
        
        HashSet<Integer> set = new HashSet<>() ; // adding the left child subtree into the set ( 0 -  root index - 1 in inorder ) so that we can distinguish in level order
        for(int i = 0 ; i < rootIdx ; i++) set.add(inord[i]) ;
        
        
        int[] lofls = new int[ rootIdx - startIdx ] ; // level order for left subtree
        int[] lofrs = new int[ endIdx - rootIdx ] ; // level order for right subtree
        
        // as all the nodes present in set is left subtree of root. so we'll use that
        // now adding the leftsubtree node in lofls and right on lofrs.
        int ls = 0 , rs = 0 ; // left substree and right subtree index.
        for(int i = 1 ; i < level.length ; i++ ) { // ignoring 0 becuase it is root (we used above in new node)
        int val = level[i] ;
        if(set.size() != 0 && set.contains(val) ){
            // if present in set then it is left part.
            lofls[ls++] = val ;
        }
        else{ // else they are right subtree part.
            lofrs[rs++] = val ;
        }
        }
        
        node.left = helper(inord,startIdx,rootIdx-1,lofls) ;
        node.right = helper(inord,rootIdx+1, endIdx, lofrs) ;
        
        return node ;
    }
    
    
}

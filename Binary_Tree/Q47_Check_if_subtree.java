package Binary_Tree;

public class Q47_Check_if_subtree {


    class Node{
        int data;
        Node left,right;
        Node(int d)
        {
            data=d;
            left=null;
            right=null;
        }

    }

    public static boolean isSubtree(Node T, Node S) {
        
        return isSubtree_(T,S) == 1 ? true : false ;
    }
    
    public static int isSubtree_(Node T, Node S) {
        if(T == null && S != null) return 0 ;
        if(T == null && S == null) return 1 ;
        
        if( isIdentical(T,S) == 1) return 1 ;
        
        int left = isSubtree_(T.left,S) ;
        if(left == 1){
            return 1 ;
        }
        
        
        int right = isSubtree_(T.right,S) ;
        
        if(right == 1){
            return 1 ;
        }
        
        return 0 ;
        
    }
    
    public static int isIdentical(Node T, Node S){
        if(T == null && S == null) return 1 ;
        if(T != null && S != null){
            if(T.data == S.data && isIdentical(T.left,S.left) == 1 && isIdentical(T.right,S.right) ==1 ){
                return 1 ;
            }
        }
        
        return 0 ;
    }
    
}

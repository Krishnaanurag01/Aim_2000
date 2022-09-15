package Problem_Of_The_day;
import java.util.* ;;

public class Q228_Pseudo_Palindromic_Paths_in_a_Binary_Tree {

    public int pseudoPalindromicPaths (TreeNode root) {
        
        HashMap<Integer,Integer> map = new HashMap<>() ;
        map.put(root.val, 1) ;
        return helper(root, map) ;
    }
    
    int helper(TreeNode root, HashMap<Integer,Integer> map ){
        if(root.left == null && root.right == null){ // when it is leaf node then check.
            int odd = 0 ;
            
            for(int key : map.keySet()){ // find digits with odd count.
                if(map.get(key) % 2 != 0) odd++ ;
            }
            
            if(odd == 0 || odd == 1) return 1 ; // if there is only 0 or 1 odd count then it is valid.
            return 0 ;
        }
        
        int left = 0 ;
        if(root.left != null){
            int freq = map.getOrDefault(root.left.val,0) ; // addding left value in map
            map.put(root.left.val, freq + 1) ;
            left = helper(root.left, map) ; 
        
            // storing previous value.
            map.put(root.left.val, freq) ;
        }
        
        int right = 0 ;
        if(root.right != null){
            int freq = map.getOrDefault(root.right.val,0) ;
            map.put(root.right.val, freq + 1) ;
            right = helper(root.right, map) ;
        
          
            map.put(root.right.val, freq) ;
        }
        
        return left + right ;
    }

    class TreeNode{
        int val ;
        TreeNode left,right;
    }
}

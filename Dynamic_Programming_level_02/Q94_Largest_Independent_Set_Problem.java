package Dynamic_Programming_level_02;

// import java.util.HashMap;

public class Q94_Largest_Independent_Set_Problem {
    
    static class node {
        int data , liss ;
        node left , right ;

        public node(int data){
            this.data = data ;
            liss = 0 ;
        }
    }
    public static void main(String[] args) {
        node root = new node(20);
        root.left = new node(8);
        root.left.left = new node(4);
        root.left.right = new node(12);
        root.left.right.left = new node(10);
        root.left.right.right = new node(14);
        root.right = new node(22);
        root.right.right = new node(25);

        System.out.println("Size of the Largest Independent Set is " + get_LISS(root) ) ;
    }

    // we only have to return total count of nodes who are not directly connected means if we choose current node then we can select it's child's child node (grandchild node) and if we don't select current node then we can select it's child nodes. so we only have to return the max one.

    public static int get_LISS(node root) {
        
        if(root == null){
            return 0 ; // when reached null then return 0.
        }

        if(root.liss != 0 ){ // if liss is already present then simply return it.
            return root.liss ;
        }

        if(root.left == null && root.right == null){
            return root.liss = 1 ;   // when at the leaf node then return 1 as it can only select it self.
        }

        int exclude_current = get_LISS(root.left) + get_LISS(root.right) ; // this is the exclude part 

        // if we include current then

        int include = 1 ;  // including current Node and adding with the grand childrens.

        if(root.left != null){
            include += get_LISS( root.left.left ) + get_LISS(root.left.right) ; // adding left child kids.
        }
        if(root.right != null){
            include += get_LISS( root.right.left ) + get_LISS(root.right.right) ; // adding right child kids.
        }

        return root.liss = Math.max(exclude_current, include ) ; // return answer.
    }




    // without using any external node.liss and using only hashmap.

    // static HashMap<node,Integer> map = new HashMap<>() ; ;
    
    // public static int get_LISS2(node root) {
        
    //     if(root == null){
    //         return 0 ;
    //     }

    //     if( map.containsKey(root) ){ // if liss is already present then simply return it.
    //         return map.get(root) ;
    //     }

    //     if(root.left == null && root.right == null){
    //         map.put(root,1) ;
    //         return 1 ;
    //     }

    //     int exclude_current = get_LISS2(root.left) + get_LISS2(root.right) ;

    //     // if we include current then

    //     int include = 1 ;

    //     if(root.left != null){
    //         include += get_LISS2( root.left.left ) + get_LISS2(root.left.right) ;
    //     }
    //     if(root.right != null){
    //         include += get_LISS2( root.right.left ) + get_LISS2(root.right.right) ;
    //     }
        
    //     map.put(root, Math.max(exclude_current, include ) ) ;
        
    //     return  Math.max(exclude_current, include ) ;
    // }
}

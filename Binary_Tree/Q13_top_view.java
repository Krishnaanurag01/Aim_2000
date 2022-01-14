package Binary_Tree;
import java.util.* ;
public class Q13_top_view {
    private static TreeNode root ;

    static class TreeNode {

        int data ; 
        TreeNode left ;
        TreeNode right ;

        public TreeNode(int d) {
            data = d ;
        }
    }

    static class vPair {
        // vpair= vertical pair.
        TreeNode node ;
        int hl ; // horizontal level

        public vPair(TreeNode node , int level){
            this.node = node ;
            hl =level ;
        }

    }

    // Method - 1 using extra space for hashmap. time and space is o(n).

    // public static ArrayList<Integer> get_top_view(TreeNode node) {
    //     ArrayList<Integer> list = new ArrayList<>();
    //     if(node == null){
    //         return list ;
    //     }

    //     LinkedList<vPair> queue = new LinkedList<>() ;

    //     HashMap<Integer,Integer> map = new HashMap<>() ;

    //     queue.add(new vPair(node,0));

    //     int min = 0 ; 
    //     int max = 0 ;


    //     while (queue.size() != 0) {
    //         int size = queue.size() ;
    //         while (size-- > 0) {
    //             vPair rp = queue.removeFirst();

    //             min = Math.min(min, rp.hl);
    //             max = Math.max(max, rp.hl);

    //             if(!map.containsKey(rp.hl)){
    //                 map.put(rp.hl, rp.node.data);
    //             }

    //             if(rp.node.left != null) queue.addLast(new vPair(rp.node.left, rp.hl - 1));
    //             if(rp.node.right != null) queue.addLast(new vPair(rp.node.right, rp.hl + 1));
    //         }
    //     }

    //     for (int i = min ; i <= max ; i++) {
    //         list.add(map.get(i));
    //     }


    //     return list ;
    // }


    // method - 2

    public static void width(TreeNode root , int level , int[] arr) {
        if(root == null) return ;

        arr[0] = Math.min(arr[0], level);
        arr[1] = Math.max(arr[1], level);

        width(root.left, level-1 , arr);
        width(root.right, level+1 , arr);
    }

    public static ArrayList<Integer> get_top_view2(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();

        if(root == null) return list ;

        int[] minMax = new int[2] ;
        width(root, 0 , minMax);
        int len = minMax[1] - minMax[0] + 1 ;

        for (int i = 0; i < len ; i++)  list.add(null);

        LinkedList<vPair> queue = new LinkedList<>();
        queue.add(new vPair(root, Math.abs(minMax[0])));

        while (queue.size() != 0) {
            int size = queue.size() ;

            while (size-- > 0) {
                vPair rp = queue.removeFirst();

                if(list.get(rp.hl) == null) list.set(rp.hl, rp.node.data);


                if(rp.node.left != null) queue.addLast(new vPair(rp.node.left, rp.hl - 1));
                if(rp.node.right != null) queue.addLast(new vPair(rp.node.right, rp.hl + 1));
            }

        }

        return list ;
    }
















    public static void main(String[] args) {

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        // root.right.left.left = new TreeNode(7);
        // root.right.left.right = new TreeNode(8);

    System.out.println(get_top_view2(root));
        
    }
    
}

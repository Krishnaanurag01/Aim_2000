package Problem_Of_The_day;

public class Q88_BST_to_greater_sum_tree {

    class Node{
        int data ;
        Node left,right ;
    }
    
    int sum = 0;
    public  void transformTree (Node root)
    {
        if(root == null) return ;
        transformTree(root.right) ;
        int bkp = root.data ;
        root.data = sum ;
        sum += bkp  ;
        transformTree(root.left) ;

    }
}

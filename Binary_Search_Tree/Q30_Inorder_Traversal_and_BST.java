package Binary_Search_Tree;

public class Q30_Inorder_Traversal_and_BST {
    
    static int isRepresentingBST(int arr[], int N)
    {
        // code here
        
        for(int i = 0 ; i < N - 1; i++){
            if(arr[i] >= arr[i+1] ) return 0 ;
        }
        
        return 1 ;
    }
    
}

package Binary_Tree;

import java.util.ArrayList;
import java.util.HashMap;

public class Q27_Minimum_swap_required_to_convert_binary_tree_to_BST {

    static class TreeNode {

        int data ; 
        TreeNode left ;
        TreeNode right ;

        public TreeNode(int d) {
            data = d ;
        }
    }
    
    private static void inorder(int[] arr, ArrayList<Integer> inordeList, int end , int index) {
        if(index >= end) return ;

        inorder(arr, inordeList, end, 2*index + 1);

        inordeList.add(arr[index]);

        inorder(arr, inordeList, end, 2*index + 2);
    }

    public static int get_min_swaps_to_bst(int[] arr ) {
        ArrayList<Integer> inordeList = new ArrayList<>();
        inorder(arr,inordeList,arr.length-1 , 0);


        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        int swaps = 0 ;

        for (int i = 0; i < arr.length; i++) {

            if(arr[i] != inordeList.get(i)){

                swaps++;

                int originalValue = arr[i];

                swap(arr,i,map.get(inordeList.get(i)));

                map.put(originalValue,map.get(inordeList.get(i)));

                map.put(inordeList.get(i), i);

            }
            
        }

        return swaps ;

    }

    private static void swap(int[] arr, int i, int swappingIdx) {

        int temp = arr[i];
        arr[i] = arr[swappingIdx];
        arr[swappingIdx] = temp ;
    }


    public static void main(String[] args) {
        System.out.println(get_min_swaps_to_bst(new int[]{ 5, 6, 7, 8, 9, 10, 11 }));
    }



    
}

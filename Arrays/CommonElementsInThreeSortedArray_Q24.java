package Arrays;

import java.util.ArrayList;

public class CommonElementsInThreeSortedArray_Q24 {
    public static void main(String[] args) {
        int[] arr1 = {1, 5, 10, 20,  80};
        int[] arr2 = {6, 7, 20, 80, 100};
        int[] arr3 = {3, 4, 15, 20,  80, 120};
        ArrayList<Integer> list = getCommonElements(arr1, arr2, arr3, arr1.length, arr2.length, arr3.length);
        for (Integer integer : list) {
            System.out.print(integer+" ");
        }
    }

    public static ArrayList<Integer> getCommonElements(int[] arr1 , int[] arr2 ,int[] arr3 ,int k ,int l ,int m) {
        
        int i = 0;
        int j = 0;
        int p = 0;
        ArrayList<Integer> list =new ArrayList<>();
        while (i < k && j < l && p < m) {
            if(arr1[i] < arr2[j]){
                i++;
            }
            else if(arr2[j] < arr1[i]){
                j++;
            }
            else{

                // this will remove the duplicate element.
                if(i>0 && arr1[i]==arr1[i-1]){
                    i++;
                    continue;
                }
                // 

                while(p<m && arr3[p]<arr2[j])p++;
                if(p< m && arr3[p] == arr2[j]){
                    list.add(arr2[j]);
                }
                i++;
                j++;
            }
            
        }
               
        return list;
        
    }
}

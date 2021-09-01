package Searching_and_Sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class Q11_Find_All_Four_Sum_Numbers {
    public static void main(String[] args) {
        int[] arr = { 10, 2, 3, 4, 5, 7, 8 };
        System.out.println(getFourSumNumber(arr, 23));
        System.out.println(GetAllQuadruple_sum(arr, 23));
    }

    public static ArrayList<ArrayList<Integer>> getFourSumNumber(int[] arr, int sum) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Arrays.sort(arr);

        // ArrayList<Integer> innerlist = new ArrayList<>();
        int st = 0;
        int ei = arr.length-1;

        for (int i = 0; i <= ei; i++) {
            if (i != st && arr[i] == arr[i - 1]) continue ;

            ArrayList<ArrayList<Integer>> innerlist = findThreeSum(i + 1, arr, sum - arr[i],ei);
            createResult(list, innerlist, arr[i]);
        }
        return list;
    } // 2 3 8 10 $2 4 7 10 $3 5 7 8 $

    private static ArrayList<ArrayList<Integer>> findThreeSum(int i, int[] arr, int sum, int ei) {

        ArrayList<ArrayList<Integer>> resultlist = new ArrayList<>();

        for (int k = i; k <=ei; k++) {
            if (k != i && arr[k] == arr[k - 1]) continue;

            ArrayList<ArrayList<Integer>> innerlist = findTwoSum(k + 1, arr, sum - arr[k], ei);
            createResult(resultlist, innerlist, arr[k]);
        }
        return resultlist;
    }

    private static ArrayList<ArrayList<Integer>> findTwoSum(int i, int[] arr, int sum ,int ei) {

        // int j = arr.length - 1;
        ArrayList<ArrayList<Integer>> innerlist = new ArrayList<>();

        while (i < ei) {
            if (arr[i] + arr[ei] == sum) {
                // innerlist.add(Arrays.asList(arr[i],arr[ei]));
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(arr[i]);
                temp.add(arr[ei]);
                innerlist.add(temp);
                i++;
                ei--;

                while (i < ei && arr[i] == arr[i - 1])
                    i++;
                while (ei > i && arr[ei] == arr[ei + 1])
                    ei--;

            } else if (arr[i] + arr[ei] < sum) {
                i++;
            } else {
                ei--;
            }

        }

        return innerlist;
    }

    public static void createResult(ArrayList<ArrayList<Integer>> result, ArrayList<ArrayList<Integer>> innerList,
            int i) {

        for (ArrayList<Integer> val : innerList) {
            val.add(0, i);
            result.add(val);
        }

    }

    // method - 2  using 2 for loop and 1 while loop : time comp and space comp :- o(n2)

    public static ArrayList<ArrayList<Integer>> GetAllQuadruple_sum(int[] arr , int sum ) {
       
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            if(i!= 0 && arr[i]==arr[i-1]) continue; // this is used so that if we encounter same number then we'll skip it.
            for(int j = i+1 ; j < arr.length ; j++){

            if(j!= i+1 && arr[j]==arr[j-1]) continue; // this is used so that if we encounter same number then we'll skip it.

            int k = j+1 ; 
            int m = arr.length-1;

            while(k < m ){
                int isItEqualToSum = arr[i] + arr[j] + arr[k] + arr[m] ;

                if(sum < isItEqualToSum){
                    m--;
                }
                else if(sum > isItEqualToSum){
                    k++;
                }
                else{
                   list.add(new ArrayList(Arrays.asList(arr[i] , arr[j] ,arr[k] , arr[m])));

                   k++;
                   m--;
                   while (k < m && arr[k] == arr[k-1]) k++;  // again checking if same element encounter then skip and move further.
                   while (k < m && arr[m] == arr[m+1]) m--;

                }
            }


            }
        }




        return list;
    }
}

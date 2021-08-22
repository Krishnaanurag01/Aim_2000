package Searching_and_Sorting;

import java.util.HashSet;

public class Q7_Find_Missing_And_Repeating {
    public static void main(String[] args) {

        int[] n = {1, 3, 3};

        n = getMissingAndRepeatingNumber(n);
        for (int i : n) {
            System.out.println(i);
        }
        
    }
    public static int[] getMissingAndRepeatingNumber(int[] arr ) {
        
        HashSet<Integer> set = new HashSet<>();
        int[] resultArr = new int[2];
        int max = arr.length;
        
        for (Integer integer : arr) {
            if(set.contains(integer)){
                resultArr[0] = integer;
            }
            set.add(integer);
        }

        for(int i = 1 ; i <= max+1 ; i++){
            if(!set.contains(i)){
                resultArr[1] = i ;
                break;
            }
        }

        return resultArr;
    }
}

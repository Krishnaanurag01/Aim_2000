package Searching_and_Sorting;

import java.util.Arrays;
import java.util.Comparator;

public class Q17_Sort_by_Set_Bit_Count {
    public static void main(String[] args) {
        
    }
    public static void Sort_by_Set_Bit_Count(Integer[] arr) {
        

        Arrays.sort(arr , new Comparator<Integer>(){

            @Override
            public int compare(Integer in1, Integer in2) {
                int cb1 = Integer.bitCount(in1);
                int cb2 = Integer.bitCount(in2);

                if(cb1 <= cb2) return 1 ;
                else{
                    return -1;
                }

            }
            
        });
    }
}

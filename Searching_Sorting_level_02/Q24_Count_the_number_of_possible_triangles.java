package Searching_Sorting_level_02;

import java.util.Arrays;

public class Q24_Count_the_number_of_possible_triangles {


    static int findNumberOfTriangles(int arr[], int n)
    {

        // step 01 : sort the array

        Arrays.sort(arr);

        int count = 0 ; // will contain the answer.

        for (int i = n-1 ; i >= 2 ; i--) {
            
            int l = 0 ;
            int r = i-1 ;

            while (l < r) {
                
                int sum = arr[l] + arr[r] ;

                if(sum > arr[i]){ // when sum of two borders are greater than one border of triangle then it is valid triangle
                    count += (r-l); // this means for ex : 2,3,4,5,6,7,8,9 -> let l is 2 and r is 8 now if 2+8 > 9 then all the element in between the 2 and 8 will also be a valid traingle by combining with 8 so calculate all the possible by r-l formula and then calculte for r-1.

                    r-- ;
                }
                else{ // else if size is less than then increase left pointer for larger values.
                    l++ ;
                }
            }
        }



        return count ;
    }
    
}

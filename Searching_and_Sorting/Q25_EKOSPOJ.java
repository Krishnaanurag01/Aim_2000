package Searching_and_Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class Q25_EKOSPOJ {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int N = sc.nextInt();
        int minWood = sc.nextInt();
        int[] woodArr = new int[N];

        for (int i = 0; i < woodArr.length; i++) {
            woodArr[i] = sc.nextInt();
        }
        Arrays.sort(woodArr);

        System.out.println(getHightOfBlade(woodArr, minWood));
    }

    // time complexcity : o(nlogn) and o(1) space
    public static int getHightOfBlade(int[] woodArr , int minWood) {
        
        int low = woodArr[0];
        int high = woodArr[woodArr.length-1];
       

        while (low <= high) {
            int mid = low + (high - low)/2 ;
            
            int woodWithMidHeight = getWoodWith_MID_HEIGHT_BLADE(woodArr , mid);
            if( woodWithMidHeight == minWood ){
                return mid;
            }
            else if( woodWithMidHeight > minWood){
                low = mid + 1;
            }
            else{
                high = mid - 1 ; 
            }
        }

       
        return 0 ;
    }
    private static int getWoodWith_MID_HEIGHT_BLADE(int[] woodArr , int bladeLength) {

        int sum = 0 ;

        for (int i : woodArr) {
            if(i >= bladeLength){
                
                sum += i - bladeLength;
            }
        }
        return sum;
    }
}

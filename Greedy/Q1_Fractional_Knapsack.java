package Greedy ;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Q1_Fractional_Knapsack
 */
public class Q1_Fractional_Knapsack {

    class Item {
        int value, weight;
        Item(int x, int y){
            this.value = x;
            this.weight = y;
        }
    }

    class itemComparator implements Comparator<Item>{

        @Override
        public int compare(Item o1, Item o2) {
           double r1 = (double) o1.value/ (double) o1.weight  ;
           double r2 = (double) o2.value/ (double) o2.weight  ;

           if(r1 < r2 ) return 1 ;
           else if( r1 > r2 ) return -1 ;
           
            return 0;
        }
        
    }



    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        // Your code here

        Arrays.sort(arr , new itemComparator());

        double answer = 0 ;

        int current_weight = 0 ;

        for (int i = 0; i < arr.length; i++) {
            
            if(current_weight + arr[i].weight <= W){
                current_weight += arr[i].weight ;
                answer += arr[i].value ;
            }

            else{
                int remain = W - current_weight ;

                double profit_ratio = (double) arr[i].value/ (double) arr[i].weight ;
                answer += (profit_ratio* (double) remain ) ;
                break ;
            }
        }


        return answer ;
    }
}
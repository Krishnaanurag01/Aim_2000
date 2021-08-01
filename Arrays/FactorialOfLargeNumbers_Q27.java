package Arrays;

// import java.math.BigInteger;

import java.util.ArrayList;

public class FactorialOfLargeNumbers_Q27 {
    public static void main(String[] args) {
        System.out.println(getFactorial(20000));

        // using external module.
        // System.out.println(factUsiInteger(20000));
    }
    public static ArrayList<Integer> getFactorial(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        // int size = 0; no need of it.
        int c = 0; //carry
        result.add(1);
        int var = 2; // we are starting multiplication from 2. because multiplication with 1 gives same output.
        
        while(var<=n){
            
            for(int i = result.size()- 1 ; i >=0 ;i-- ){
                
                // getting values from list end and mutiplying with given numbers factorial and adding carry then storing to the temp variable because we have to replce that index with sum only not carry.  
                int temp = result.get(i)*var+c;

                // getting last digit of above calculation and replacing with old digit.
                result.set(i,temp%10);

                // remainning digit stored in carry variable which will be addded at first location.
                c = temp/10;
            }
            while(c!=0){
                result.add(0,c%10);
                // size++;
                c=c/10;
            }
            
            var++;
        }
        return result;
    }

    // using external libraries.

    // public static BigInteger factUsiInteger(int N) {
    //     BigInteger j = new BigInteger("1");

    //     for (int i = 2; i <=N; i++) {
    //         j = j.multiply(BigInteger.valueOf(i));
    //     }
    //     return j;
    // }
}

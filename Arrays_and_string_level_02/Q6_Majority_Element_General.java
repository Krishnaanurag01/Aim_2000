package Arrays_and_string_level_02;
import java.util.*;

public class Q6_Majority_Element_General {
    
   
     public static ArrayList<Integer> majorityElement(int[] arr, int k) {

        ArrayList<Integer> list = new ArrayList<>() ;
        HashMap<Integer,Integer> map = new HashMap<>() ;

        for(int i : arr){ // making frequency map.
            map.put(i,map.getOrDefault(i,0)+1) ;
        }

        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            if((int)e.getValue() > arr.length/k){    // adding keys whose freq is greater than n/k 
                list.add( (int) e.getKey()) ;
            }
        }

        Collections.sort(list) ; /// giving list by sorting them.

        return list ;
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        ArrayList<Integer> res = majorityElement(arr, k);
        System.out.println(res);
        scn.close(); 
    }

}

package HashMaps_and_Heaps_Level_02;
import java.util.*;

public class Q3_Check_If_An_Array_Can_Be_Divided_Into_Pairs_Whose_Sum_Is_Divisible_By_K {

    
	public static void solution(int[] arr, int k){
		//write your code here

		 int n = arr.length ;
        
       HashMap<Integer,Integer> map = new HashMap<>() ; // store remainder as key and it's frequency
        
       // storing remainder
        for(int i = 0 ; i < n ; i++){
            int val = arr[i] ;
            int r1 = val % k ;
           
                map.put(r1, map.getOrDefault(r1,0)+1) ;
        }
        
        
        for(int i = 0 ; i < arr.length ; i++){
            int val = arr[i] ;
            int r1 = val % k ;
            
            if(r1 == 0){ // if remainder is 0 then check if total freq is even or not if even then we can make equal pairs
                int freq = map.get(r1) ;
                
                if(freq % 2 != 0){
					System.out.println(false);
                    // return false;
					return ;
                }
            }
            else if( 2*r1 == k ){ // if both remainder is same then check if their frequency is even or not
                int freq = map.get(r1) ;
                if(freq % 2 != 0){
					System.out.println(false);
                    return ;
                }
            }
            else{ // else when both remainder is different then check if their frequency is same or not
                int f1 = map.get(r1) ;
                int f2 = map.getOrDefault(k-r1,0) ;
                
                if(f1 != f2){
					System.out.println(false);
                    return ;
				}
            }
        }
        
        
        System.out.println(true);
        
        return  ;
        

	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		solution(arr,k);
        scn.close();
	}
    
}

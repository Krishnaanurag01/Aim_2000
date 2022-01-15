package Arrays_and_string;

public class Q27_Wiggle_Sort_1 {

    public static void wiggleSort(int[] arr) {
      
        for(int i = 0 ; i < arr.length-1 ; i++){
            
            if(i % 2 == 0 ){ // for even
                if(arr[i] > arr[i+1]){ // next element must be greater or equals to current but if it isn't then do swap
                    swap(arr,i,i+1) ;
                }
            }
            else{ // for odd
                  if(arr[i] < arr[i+1]){// next element must be smaller or equals to current but if it isn't then do swap
                    swap(arr,i,i+1) ;
                }       
            }
        }
     
    }
    
    public static void swap(int[] arr , int i , int j){
        int temp = arr[i] ;
        arr[i] = arr[j] ;
        arr[j] = temp ;
    }
    
}

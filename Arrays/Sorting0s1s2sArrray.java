package Arrays;

public class Sorting0s1s2sArrray {
    public static void main(String[] args) {
        int[] arr= {0,1,2,1,2,0,1,0,2};
        sortingOs1s2s(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
    public static void sortingOs1s2s(int[] arr) {
        int l = 0, m = 0;
        int temp ;
        int h = arr.length-1;
        while (m<=h) {
            switch (arr[m]) {
                case 0:
                temp = arr[l];
                arr[l] =arr[m];
                arr[m] = temp;
                l++;
                m++;                    
                    break;
                case 1:
                m++;
                    break;
                case 2:
                temp = arr[h];
                arr[h] = arr[m];
                arr[m] = temp;
                h--;
                break;            
                default:
                    break;
            }
            
        }
        
    }


    // method 02 :

    public void sortColors(int[] nums) {
        
        int zero = 0 ;
        int two  = nums.length - 1; 
        
        for(int i = 0 ; i < nums.length && i <= two ; i++ ){
            
            int val = nums[i] ;
            
            if(val == 0 ){ // when got 0 then swap with the zeroth index.
                
                nums[i] = nums[zero] ;
                nums[zero] = val ;
                zero++ ;
                
                
            }
            else if(val == 2){ // when got 2 then swap with twoth index and also do i-- so that current element will be checked again.
                
                nums[i] = nums[two] ;
                nums[two] = val ;
                two--;
                i-- ;
            }
        }
    }
    
}

package Arrays;

public class Intersection {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {1,2,3,4,6,8,9,12};        
        System.out.println(intersectionOfArrays(arr1, arr2));
        
    }
    public static int intersectionOfArrays(int[] arr1 , int[] arr2) {
        int intersectionCount=0;
        int ptr1 = 0 , ptr2 =0;
        while (ptr1< arr1.length && ptr2 < arr2.length) {
            if(arr1[ptr1] < arr2[ptr2]){
                ptr1++;
            }
            else if(arr2[ptr2] < arr1[ptr1]){
                ptr2++;
            }
            else{
                intersectionCount++;
                ptr1++;
                ptr2++;
            }            
        }
        return intersectionCount;
        
    }
    
}

package Arrays;
public class Union {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {2,4,6,8,9,12};        
        System.out.println(getUnion(arr1, arr2));
    }
    public static int getUnion(int[] arr1, int[] arr2) {
        int unionCount = 0;
        int ptr1=0 , ptr2=0;
        while(ptr1 < arr1.length && ptr2 < arr2.length){
            if(arr1[ptr1]<arr2[ptr2]){
            unionCount++;
            ptr1++;
            }
            else if(arr1[ptr1] > arr2[ptr2]){
                unionCount++;
                ptr2++;
            }
            else{
                unionCount++;
                ptr1++;
                ptr2++;
            }
        }
        while(ptr1< arr1.length){
            unionCount++;
            ptr1++;
        }
        while(ptr2< arr2.length){
            unionCount++;
            ptr2++;
        }


        return unionCount;
        
    }
    
}

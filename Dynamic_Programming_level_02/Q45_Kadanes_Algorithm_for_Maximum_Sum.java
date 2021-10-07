package Dynamic_Programming_level_02;

public class Q45_Kadanes_Algorithm_for_Maximum_Sum {

    public static void main(String[] args) {
        
    }

    public static int get_max_sum(int[] arr) {
        int cmax = arr[0] ;
        int bmax = arr[0] ;

        for (int i = 1; i < arr.length; i++) {
            cmax = cmax + arr[i] ;
            if(cmax < arr[i]){
                cmax = arr[i];
            }
            if(bmax < cmax){
                bmax = cmax ;
            }
        }

    return bmax;
    }
    
}

package Problem_Of_The_day;

public class Q34_Binary_Array_Sorting {
    

    static void binSort(int A[], int N)
    {
        int onePoint = -1 ;

        for(int i = 0 ; i < N ; i++){

            if(onePoint == -1 && A[i] == 1){
                onePoint = i ;
                continue ;
            }

            if(onePoint != -1){
                if(A[i] == 0)
                {
                    // int temp = A[i] ;
                    A[i] = A[onePoint] ;
                    A[onePoint] = 0 ;
                    onePoint++;

                }



            }
            
        }
    }
}

package Problem_Of_The_day;

public class Q312_Black_and_White {
    static long numOfWays(int N, int M)
    {
       long ans = 0 ;
       int mod = (int)1e9+7 ;
       
       long total = ((long)N * (long)M) % mod ; // total cells of the board.
       
       for(int i = 0 ; i < N ; i++){
           for(int j = 0 ; j < M ; j++){
               int non_placeble = 0 ; // checking all the 8 moves where current cell knight can move and if any move possible then it means on that cell another knight can't be placed
               
               if(i - 2 >= 0 && j - 1 >= 0){
                   non_placeble++ ;
               }
               
               if(i - 2 >= 0 && j + 1 < M){
                   non_placeble++ ;
               }
               
               
               if(i + 2 < N && j - 1 >= 0){
                   non_placeble++ ;
               }
               
               if(i + 2 < N && j + 1 < M){
                   non_placeble++ ;
               }
               
               if(j + 2 < M && i + 1 < N){
                   non_placeble++ ;
               }
               
               if(j + 2 < M && i - 1 >= 0 ){
                   non_placeble++ ;
               }
               
               if(j - 2 >= 0 && i + 1 < N){
                   non_placeble++ ;
               }
               
               if(j - 2 >= 0 && i - 1 >= 0 ){
                   non_placeble++ ;
               }
               
               
               long temp = (total - non_placeble - 1 + mod ) % mod ; // total cell minus non placeble cell minus current cell is total cell possible where other knight can be placed
               
               ans = ((ans + temp) + mod) % mod ;
           }
       }
       
       return ans ;
    }
}

package Dynamic_Programming_level_02 ;

/**
 * Q102_word_wrap
 */
public class Q102_word_wrap {

    public static void main(String[] args) {
        int l[] = {3, 2, 2, 5};
        int n = l.length;
        int M = 6;

        get_min_space(l, n, M);
    }


    static int MAX = Integer.MAX_VALUE ;

    public static void get_min_space(int[] arr,int n , int m) {
        
        int[][] space = new int[n+1][n+1]; // this will store the total space left after placing the words.
        int[][] cost = new int[n+1][n+1] ;// this will store the total cost.
        int[] optimal_cost = new int[n+1] ; // this will store the optimal cost(min)
        int[] path = new int[n+1] ;

        for (int i = 1; i <= n; i++) {
            space[i][i] = m-arr[i-1]; // space left after the first word in the line
            for (int j = i+1; j <=n ; j++) {
                space[i][j] = space[i][j-1] - arr[j-1] - 1 ;  // now subtracting the previous left space - current word and -1 denotes the gap between 2 two words that is not countable so subtracting it.
            }
        }


        // finding cost.

        for (int i = 1; i <= n ; i++) {
            
            for (int j = i ; j <= n; j++) {

                if(space[i][j] < 0){ // if the space left is is -1 then we cant't place words there so storing max.
                    cost[i][j] = MAX ;
                }
                else if(j == n && space[i][j] >= 0){
                    cost[i][j] = 0 ; // when we stored all the words then the space after the last word is countable so storing 0.
                }
                else{
                    cost[i][j] = space[i][j] * space[i][j] ; // else cost is square of space left.
                }
                
            }
        }


        // finding the optimal cost.

        for (int j = 1; j <= n; j++) {
            
            optimal_cost[j] = MAX ; // storing max by default help in finding the minimum cost.
            for (int i = 1; i <= j; i++) {
                // checking if previous optimal cost is not max also the cost is not max and then comapring previous cost vs current cost and storing the minimum one.
                if(optimal_cost[i-1] != MAX && cost[i][j] != MAX && (optimal_cost[i-1] + cost[i][j] < optimal_cost[j])){
                    optimal_cost[j] = cost[i][j] + optimal_cost[i-1] ;
                    path[j] = i ;// this is the index of element .
                }
            }
        }


        for (int i : optimal_cost) {
            System.out.println(i);
        }


        // printSolution(path, n);//


    }

    static int printSolution (int p[], int n)
    {
        int k;
        if (p[n] == 1)
        k = 1;
        else
        k = printSolution (p, p[n]-1) + 1;
        System.out.println("Line number" + " " + k + ": " +
                    "From word no." +" "+ p[n] + " " + "to" + " " + n);
        return k;
    }
}
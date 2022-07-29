package Problem_Of_The_day;

public class Q127_Find_the_Town_Judge {

    public int findJudge(int n, int[][] trust) {
        
        int[] trusts = new int[n+1] ;
        int[] trusted = new int[n+1] ;
        
        for(int[] t : trust){
            trusts[t[0]]++ ;
            trusted[t[1]]++ ;
        }
        
        for(int i = 1 ; i <= n ; i++){
            if(trusts[i] == 0 && trusted[i] == n-1) return i ;
        }
        
        return -1;
    }
}

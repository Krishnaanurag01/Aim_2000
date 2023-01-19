package Problem_Of_The_day ;

public class Q341_Carpet_into_Box {

    int carpetBox(int A, int B, int C, int D) { 
        if((A <= C && B <= D) || (A <= D && B <= C)) return 0 ; // if carpet get fit in the box then store it.
        
        if(A > C && A > D) return 1 + carpetBox(A/2, B, C, D) ; // if A is greater than both then we gotta fold this A length
        if(B > C && B > D) return 1 + carpetBox(A, B/2, C, D) ; // if B is greater than both then we gotta fold this B length
        
        // now ab A aur B na he fit ho saktey h aur na he dono side box k dono side se bade h matlab koi 1 side issue create kar rha h toh dono side 1-1 baar fold kar k min moves nikal lo
        
        return Math.min(1 + carpetBox(A/2, B, C, D), 1 + carpetBox(A, B/2, C, D)) ;
      }
    
}

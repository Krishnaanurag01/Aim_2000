package Problem_Of_The_day ;
public class Q302_LCM_Triplet {
    
    long lcmTriplets(long n) {

        if(n<=2) return n; // when number is 2 or 1 then lcm is same.
        
        if(n%2!=0) // when number is odd 
            return n*(n-1)*(n-2); // then multiple of lasst three. ex : 7 * 6 * 5 gives max
        else{
            if(n%3==0){ // if number divisible by three then choose
                return (n-1)*(n-2)*(n-3); // N = 6 - > 5 * 4 * 3 gives max
            }
            else
                return n*(n-1)*(n-3); // when number is even then ex 10 -> 10*9*7
        }
    }
}

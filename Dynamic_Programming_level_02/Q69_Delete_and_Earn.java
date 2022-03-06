package Dynamic_Programming_level_02;

public class Q69_Delete_and_Earn {

    public static void main(String[] args) {
        
    }

    public static int get_max(int[] nums) {
        
        int[] count = new int[10001]; // constraints! given that size could be 10^4;
        
        for(int i : nums){
            count[i]++; // storing the frequency of each ith element of nums array
        }
        
        int include = 0 ; // store sum  of when previous excluding number + current number(stores max )
        int exclude = 0 ; // store sum of when excluding current number
        
        for(int i = 0 ; i < count.length ; i++){
            int nincl = exclude + count[i]* i ; // here adding previous excluding + current number frequency(count[i])*current number(i)
            int nexclu = Math.max(include,exclude); // stores max of previous excluding or previous including.
            
            include = nincl ; // now update both including and excluding
            exclude = nexclu ;
        }
        
        return Math.max(include,exclude) ; // retun max
    }
    
}

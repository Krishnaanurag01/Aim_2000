package Problem_Of_The_day;

public class Q175_Find_the_Student_that_Will_Replace_the_Chalk {

    public int chalkReplacer(int[] chalk, int k) {
        
        // In the first loop we will subtract the chalk and also find the total sum of chalk all studdents need
        long sum = 0 ;
        for(int i = 0 ; i < chalk.length ; i++){
            if(k < chalk[i]) return i ;
            k -= chalk[i] ;
            sum += chalk[i] ;
        }
        
        k = k % (int)sum ; // here we doing modulo - eska matlab agar k chalk total need sum se bhi jyda toh wo againi sare student ko de sakta toh directly last stage check karo jab k chalk humare total need se kam h.
        
        for(int i = 0 ; i < chalk.length ; i++){
            if(k < chalk[i]) return i ;
            k -= chalk[i] ;
        }
        
        return -1;
    }
}

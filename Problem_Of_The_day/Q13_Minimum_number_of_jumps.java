package Problem_Of_The_day;

public class Q13_Minimum_number_of_jumps {
    
    static int minJumps(int[] arr){
        // your code here
        
        if(arr.length <= 1 ) return 0 ; // if length is 1 or lesser then return 0 becuase it can't jump ;
        
        if(arr[0] == 0 ) return -1 ; // if the first jump is of 0 size then return -1 as it can't reach end from start.
        
        int max_reach = arr[0] ; // max distance.
        int steps = arr[0] ; // this is total steps we can walk.
        int jump = 1 ; // number of jumps.
        
        for( int i = 1 ; i < arr.length ; i++){
            
            if( i == arr.length - 1) return jump ; // if we reached the last stair then return jump.
            
            max_reach = Math.max(max_reach ,  i + arr[i] ) ; // keep updating the max_reach , this will help when there is 0 jump stair in between the array.
            
            steps-- ; // after walking one step remove one step as well.
            
            if( steps == 0 ){ // when the steps becomes left then increase the jump as we need to jump.
                jump++ ;
                
                if(i >= max_reach) return -1 ; // if we already reach to our max reach then return -1 as we can't move further. ( must be 0 ini between the array)
                
                steps = max_reach - i ; // finding the steps. here we are not assinging the arr[i] directly becuase there might be some possibilities that arr[i] gives lesser steps than max reach.
            }
        }

        // returning the total jumps.
        return jump ;
    }

}

package Arrays_and_string_level_02;

public class Q78_Number_of_Ways_to_Divide_a_Long_Corridor {

    public int numberOfWays(String corridor) {
        
        int seats = 0 ;
        int plants = 0 ;
        int totalSeats = 0 ;
        
        long ans = 1;  // when we have only two seats in the coridor then bydefault answer is 1 as we can not place any extra divider. 
        boolean isFirstDividerPlaced = false; // as we have to keep track of plants after the first divider is placed so this is a flag which denotes corres.
        
        for(char ch : corridor.toCharArray()){
            if(ch == 'S'){
                totalSeats++ ;
                seats++;
            }
            else if(seats == 0 ){ // calculate plants only when the seats are 0.(and we make these zero after a pair)
                plants++;
            }
            
            if(seats == 2){ // when two seats present then perform following.
                if(isFirstDividerPlaced){ // when first divider is placed after that calculate total ways. only
                    ans = mul(ans, add(plants , 1)) ; // plants +1 means we can place divider as much as plants +1
                }
                
                isFirstDividerPlaced = true; // this makes the first divide true.
                plants = 0 ;// and after that initilizing this values so that we can calculate the no of plants in after the current seat (which is 2nd seat of pair) and next seat.
                // this count of plants denotes that we can place divider in between.
                seats = 0 ;
            }
        }
        
        if(totalSeats % 2 != 0 || totalSeats == 0 ) return 0 ;
        
        return (int)ans ;     
        
    }

    // mod operations.
    
    int M = (int)1e9+7 ;
    
    long mod(long a){
        return  ((a % M) + M)%M ;
    }
    
    long add(long a, long b){
        return mod(mod(a) + mod(b)) ;
    }
    
    long mul(long a, long b){
        return mod(mod(a)*mod(b)) ;
    }
}

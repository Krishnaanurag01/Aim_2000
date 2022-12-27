package Problem_Of_The_day; 

public class Q319_Wine_Buying_and_Selling {

    long wineSelling(int Arr[],int N){
        
        long ans = 0 ;
        int sell_idx = 0 ; // last index where we have sold wines, helps in not searching from  start instead we cans tart from last sold house.
        
        for(int i = 0 ; i < N ; i++){
            int val = Arr[i] ;
            if(val >= 0 ) continue ; // if current house can buy then skip.
            
            while(val < 0 && sell_idx < N){ // while all the wine is not sold
                if(Arr[sell_idx] > 0){ // if current house can buy wine then sell it to them
                    int temp = Arr[sell_idx] ;
                    
                    if(Math.abs(val) >= temp){ // sell as much as they can buy
                        Arr[sell_idx] = 0 ;
                        ans = ans + ( temp * Math.abs(Math.abs(sell_idx) - Math.abs(i))) ;
                        val = temp + val ;
                        sell_idx++ ;
                    }
                    else{ // if they can more than we have then sell all we have
                        ans = ans + ( Math.abs(val) * Math.abs(Math.abs(sell_idx) - Math.abs(i))) ;
                        Arr[sell_idx] = temp + val ;
                        val = 0 ;
                    }
                }
                else{ // otherwise move to other house
                    sell_idx++ ;
                }
            }
        }
        
        return ans ;
    }
}

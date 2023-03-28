package Problem_Of_The_day;

public class Q384_Shy_Geek {
    
    static Shop shop;
    Solution(Shop shop){
        this.shop = shop;
    }
    static long find(int n, long k){
        // Return the number of chocolates Geek had
        // enjoyed out of 'n' chocolates availabe in the
        // 'shop'.
        
    
        int high = n - 1 ; // esko bahar rhakha h kyuki last time jha par humara high phocha tha uske aage toh es baar high ja nhi sakta kyuki ab humara paisa(K) kam ho gya h last time ke hisab se 
        long ans = 0 ;
        
        while(k > 0){
            
            int low = 0 ; // esko andar rhakha h kyuki humara range start se high (ye kam hoga har baar isliy bahar h ) hoga har baar
            
            int cost = -1 ; // price of costlier chocolate
            
            while(low <= high){
                int mid = low + (high - low)/2 ;
                int mprice = shop.get(mid) ; // getting price of mid index choco
                
                if(mprice <= k){ // finding the costilier one
                    cost = mprice ;
                    low = mid + 1 ;
                }
                else{
                    high = mid - 1 ;
                }
            }
            
            if(cost > -1){ // means theres one chocolate that we can afford
                ans += (k / cost*1L) ; //so buy as many as possible
                k = k % cost ; // and get the rest money
            }
            else break ; // means we can't afford any more chocolate ab
        }
        
        return ans ;
    }


    static class shop{

        int get(int idx){
            return -1 ;
        }
    }
}

package Greedy;

public class Q12_check_if_it_is_possible_to_survive_on_island {
    

    static int minimumDays(int S, int N, int M){
       
        int total_sundays_init = S/7 ;
        int total_days_we_can_buy_food = S-total_sundays_init ; // subtracting sundays from S days.
        
        int total_days_we_need_to_buy = (S*M) % N == 0 ? (S*M)/N : (S*M) / N + 1 ; // if number is divisible by N then do it directly else add + 1 with it.
        
        
        if(total_days_we_need_to_buy <= total_days_we_can_buy_food ){
            return total_days_we_need_to_buy ; 
        }
        
        return -1;
    }
}

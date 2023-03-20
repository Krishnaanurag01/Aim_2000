package Problem_Of_The_day;

public class Q380_Can_Place_Flowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
       
        //  greedy brute force
        for(int i = 0 ; i < flowerbed.length ; i++){
            if(flowerbed[i] == 0){
                if(i == 0){
                    if(i+1 < flowerbed.length && flowerbed[i+1] != 1){
                        n-- ;
                        flowerbed[i] = 1 ;
                    }
                    else if(i + 1 == flowerbed.length){
                         n-- ;
                        flowerbed[i] = 1 ;
                    }
                }
                else{
                    if(flowerbed[i-1] != 1){
                         if(i+1 < flowerbed.length && flowerbed[i+1] != 1){
                            n-- ;
                            flowerbed[i] = 1 ;
                          }
                          else if(i + 1 == flowerbed.length){
                            n-- ;
                            flowerbed[i] = 1 ;
                          }
                    }
                }
            }
        }
        
        return n <= 0 ;
    }    
}

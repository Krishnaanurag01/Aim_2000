package Problem_Of_The_day;
import java.util.*;

public class Q353_Fruit_Into_Baskets {

    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> map = new HashMap<>() ;
        int best = 0 ;
        
        int i = -1 ;
        int j = -1 ;
        
        while(true){
            boolean f1 = false;
            boolean f2 = false;
            
            while(i < fruits.length -1 && map.size() <= 2){
                i++ ;
                int fruit = fruits[i] ;
                map.put(fruit, map.getOrDefault(fruit,0)+1) ;
                f1 = true ;
                
                if(map.size() <= 2){
                    best = Math.max(best, i - j) ;
                }
                else{
                    break ;
                }
            }
            
            while(j < fruits.length-1 && map.size() > 2){
                j++;
                int fruit = fruits[j] ;
                int freq = map.get(fruit) ;
                
                if(freq == 1){
                    map.remove(fruit) ;
                }
                else{
                    map.put(fruit, freq - 1) ;
                }
                
                if(map.size() <= 2){
                    best = Math.max(best, i - j) ;
                }
                
                f2 = true ;
            }
            
            if(f1 == false && f2 == false) break ;
        }
        
        
        return best ;
    }
}

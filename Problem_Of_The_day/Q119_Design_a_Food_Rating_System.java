package Problem_Of_The_day;
import java.util.*;

public class Q119_Design_a_Food_Rating_System {

    class FoodRatings {

        HashMap<String,PriorityQueue<foodObj>> cuisineMap;
        HashMap<String,foodObj> foodMap ;
        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            cuisineMap = new HashMap<>() ;
            foodMap = new HashMap<>() ;
            
            for(int i = 0 ; i < foods.length ; i++){
                foodObj fobj = new foodObj(foods[i], cuisines[i], ratings[i]) ;
                
                PriorityQueue<foodObj> pq = cuisineMap.getOrDefault(cuisines[i], new PriorityQueue<foodObj>()) ;
                
                pq.add(fobj) ;
                cuisineMap.put(cuisines[i],pq) ;
                foodMap.put(foods[i],fobj) ;
            }
        }
        
        public void changeRating(String food, int newRating) {
            foodObj Food = foodMap.get(food) ;
            PriorityQueue<foodObj> pq = cuisineMap.get(Food.cuisine) ;
            pq.remove(Food) ;
            Food.rating = newRating ;
            pq.offer(Food) ;
        }
        
        public String highestRated(String cuisine) {
            return cuisineMap.get(cuisine).peek().name ;
        }
        
        class foodObj implements Comparable<foodObj>{
            String name,cuisine ;
                int rating ;
            foodObj(String x, String y, int z){
                name = x ;
                cuisine = y ;
                rating = z ;
            }
            
            public int compareTo(foodObj o){
               if(this.rating != o.rating){
                   return o.rating - this.rating ;
               }
                else return this.name.compareTo(o.name) ;
            }
        }
    }
    
}

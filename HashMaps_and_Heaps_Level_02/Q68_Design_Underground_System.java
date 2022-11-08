package HashMaps_and_Heaps_Level_02;
import java.util.*;

public class Q68_Design_Underground_System {
    

    class UndergroundSystem {

        HashMap<String, HashMap<String, avgTime >> semap ; // START TO END MAP.
        HashMap<Integer, Entry> inMap ; // this is checkIn map where we store passenger detail about the id, entry station , entry time
        
        public UndergroundSystem() {
            semap = new HashMap<>() ;
            inMap = new HashMap<>() ;
        }
        
        public void checkIn(int id, String stationName, int t) {
            inMap.put(id, new Entry(stationName, t)) ;
        }
        
        public void checkOut(int id, String stationName, int t) {
            String inStation = inMap.get(id).station ; // entry station.
            
            
            // now looking for previous end station of instation if any exist otherwise add new entry.
                HashMap<String, avgTime> ends = semap.getOrDefault(inStation, new HashMap<>()) ;
                
                avgTime val = ends.getOrDefault(stationName, new avgTime()) ; // got the avgTime obj of current route
                val.freq++ ; // now increase the freq as we have another customer data
                val.totalTime += (t - inMap.get(id).time ) ; // and increase the total time
                
                ends.put(stationName,val) ; // now putting back to respective maps.
                semap.put(inStation, ends) ;
    
            inMap.remove(id) ; // ans as current passegenge completed it's journey so remvoing it's entry
        }
        
        public double getAverageTime(String startStation, String endStation) {
            
            avgTime t = semap.get(startStation).get(endStation) ; // getting the object of current route
            
            return (t.totalTime*1.0)/(t.freq*1.0); // and returning avg time.
        }
        
        class Entry{
            String station ;
            int time ;
            
            Entry(String s, int y){
                station = s ;
                time = y ;
            }
        }
        
        class avgTime{
            int freq ;
            int totalTime ;
        }
    }
    
}

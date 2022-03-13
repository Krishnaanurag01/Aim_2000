package HashMaps_and_Heaps_Level_02;
import java.util.*;

public class Q45_Subdomain_Visit_Count {

    public List<String> subdomainVisits(String[] cpdomains) {
        
        HashMap<String,Integer> map = new HashMap<>() ; // stores the domain with visited count.
        
        for(String domain : cpdomains){  // accessing each domain

            int count = Integer.parseInt( domain.split(" ")[0] ) ; // extracting the visit count
          
            String[] d = domain.split(" ")[1].split("\\.") ; // spliting the domain on "."
            
            StringBuilder sb = new StringBuilder() ;
            
            for(int i = d.length - 1  ; i >= 0 ; i--){
                
                sb.insert(0,d[i]) ; // adding subdomain in sb
                String s = sb.toString() ; // converting for map
                map.put(s,map.getOrDefault(s,0)+count) ;
                sb.insert(0,".") ; // adding "." in last will help us in handelling "." for full domain
            }
        }
        
        // System.out.println(map) ;
        
        List<String> ans = new ArrayList<>() ;
        
        // now accessing each sub domain and adding to answer by making string builder.
        for(String key : map.keySet()){
            StringBuilder sb = new StringBuilder() ;
            int count = map.get(key) ;
            sb.append(count) ;
            sb.append(" ") ;
            sb.append(key) ;
            
            ans.add(sb.toString()) ;
        }
        
        return ans  ;
        
    }
    
}

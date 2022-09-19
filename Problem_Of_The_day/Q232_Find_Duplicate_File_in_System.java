package Problem_Of_The_day;
import java.util.*;

public class Q232_Find_Duplicate_File_in_System {

    public List<List<String>> findDuplicate(String[] paths) {
        
        List<List<String>> ans = new ArrayList<>() ;
        HashMap<String,List<String>> map = new HashMap<>() ;
        
        for(int k = 0 ; k < paths.length ; k++){
            String[] s = paths[k].split(" ") ;
            
            // as 0th index has the path so starting from index 1.
            for(int i = 1 ; i < s.length ; i++){
                // sb -> path + current file.
                StringBuilder sb = new StringBuilder(s[0]+"/"+ ( s[i].substring(0,s[i].lastIndexOf('(')) ) ) ;
                String file = s[i].substring(s[i].lastIndexOf('(') +1, s[i].length() - 1) ; // find content.
                List<String> list = map.getOrDefault(file, new ArrayList<>()) ; // getting the list of current file.
                list.add(sb.toString()) ;
                map.put(file,list) ;
            }
        }
        
        for(String key : map.keySet()){
            if(map.get(key).size() < 2) continue ; // if the size is less than 2 then it means it does not has any duplicacy.
            ans.add(map.get(key)) ; // otherwise add to answer.
        }
        
        return ans ;
    }
}

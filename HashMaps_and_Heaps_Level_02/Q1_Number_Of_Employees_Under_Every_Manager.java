package HashMaps_and_Heaps_Level_02;
import java.util.*;

public class Q1_Number_Of_Employees_Under_Every_Manager {

    
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
         scn.nextLine() ; // moving to next line so taking garbage of current line
    
         // taking employees - managers
        HashMap<String,String> map = new HashMap<>() ;
    
        for(int i = 0 ; i < n ; i++){
    
          String[] s = scn.nextLine().split(" ") ;
    
          map.put(s[0],s[1]) ;
        }
    
        solve(map) ;
        scn.close();
      }
    
      public static void solve(HashMap<String,String> map){
    
        // this will contain each manager with their employees
        HashMap<String,HashSet<String>> tree = new HashMap<>() ;
        String ceo = "" ;
    
        for (String emp : map.keySet()) {
          String mang = map.get(emp) ;
    
          if(emp.equals(mang)){ // when both the equal the it is the ceo of the company
            ceo = emp ;
          }
          else{
            HashSet<String> emps =  tree.getOrDefault(mang, new HashSet<String>());  
            emps.add(emp) ; // adding employeee to managers list
            tree.put(mang,emps) ;
          }
        }
    
    
        HashMap<String,Integer> result = new HashMap<>() ; // mappping managers with number of employee  
        getSize(tree,ceo,result)  ;
    
        for (String mnrg : result.keySet()) {
          System.out.println(mnrg + " " + result.get(mnrg));
        }
      }
    
      static int getSize(HashMap<String,HashSet<String>> tree, String ceo, HashMap<String,Integer> result   ){
    
        if(tree.containsKey(ceo) == false){ // if not contains then
          result.put(ceo,0) ; // store 0 in you
          return 1 ; // and return 1 for yourself
        }
    
        int counts = 0 ;
    
        for (String emp : tree.get(ceo)) { // going to each employee and getting their counts
           counts += getSize(tree,emp,result) ;
        }
    
        result.put(ceo,counts) ; // storing the count
     
        return counts+1 ; // and returning +1(denotes current manager)
    
      }
    
}

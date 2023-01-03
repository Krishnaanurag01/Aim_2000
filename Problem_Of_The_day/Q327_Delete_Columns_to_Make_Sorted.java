package Problem_Of_The_day;

public class Q327_Delete_Columns_to_Make_Sorted {

    public int minDeletionSize(String[] strs) {
        
        int ans =0 ;
        
        for(int j = 0 ; j < strs[0].length() ; j++){
            
            char prev = '*' ;
            for(int i = 0 ; i < strs.length ; i++){
                char ch = strs[i].charAt(j)  ; 
                
               if(prev == '*'){
                   prev = ch ;
               }
                else if(prev > ch){
                    ans++;
                    break;
                }
                
                prev = ch ;
            }
        }
        return ans;
    }
}

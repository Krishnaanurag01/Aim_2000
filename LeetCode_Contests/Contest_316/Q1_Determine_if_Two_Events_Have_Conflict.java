package LeetCode_Contests.Contest_316;

public class Q1_Determine_if_Two_Events_Have_Conflict {
    
    public boolean haveConflict(String[] event1, String[] event2) {
        
        // converting this 24hour time stamp into minutes and then comparing.
        
        int first_start = Integer.parseInt(event1[0].split(":")[0]) * 60 + ( Integer.parseInt(event1[0].split(":")[1])) ;
        int first_end = Integer.parseInt(event1[1].split(":")[0]) * 60 + ( Integer.parseInt(event1[1].split(":")[1])) ; 

        int sec_start = Integer.parseInt(event2[0].split(":")[0]) * 60 + ( Integer.parseInt(event2[0].split(":")[1])) ;
        int sec_end = Integer.parseInt(event2[1].split(":")[0]) * 60 + ( Integer.parseInt(event2[1].split(":")[1])) ;

        
        // if second event starts first then check it's end with first start. 
        if(sec_start < first_start) return sec_end >= first_start ;
        
        if(first_end >= sec_start) return true ;
        return false;
    }
}

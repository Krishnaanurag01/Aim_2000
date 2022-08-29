package Problem_Of_The_day;

public class Q194_Merge_Triplets_to_Form_Target_Triplet {
    
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int ai = -1;
        int bi = -1;
        int ci = -1; 
        
        // we just have to choose the max ai,bi,ci from triplet whose every value is less than or equal to corresponding target value. 
        for(int[] triplet : triplets){
            if(triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] <= target[2]){
                ai = Math.max(ai,triplet[0]) ;
                bi = Math.max(bi,triplet[1]) ;
                ci = Math.max(ci,triplet[2]) ;
            }
        }
        
        if(ai != target[0]) return false;
        if(bi != target[1]) return false;
        if(ci != target[2]) return false;
        
        return true ;
    }
}

package Stack_and_Queue_level01;

public class Q29_Trapping_Rain_Water {

    public int trap(int[] h) {
        
    
        int l = 0 ; // left pointer
        int r = h.length - 1 ; // right pointer
        int lmax = 0 ; // left max
        int rmax = 0 ; // right max
        int ans = 0 ;
        
        
        while(l < r){
            lmax = Math.max(lmax,h[l]);  // update lmax and right max            
            rmax = Math.max(rmax,h[r]);
            
            if(lmax < rmax){ // if l is smaller then subtract from building height and add to ans else go with rmax
                ans += lmax - h[l] ;
                l++;
            }
            else{
                ans+= rmax - h[r] ;
                r-- ;
            }
        }
        
        return ans ;
        
    }
    
}

package Recursion_and_backtracking_level_02;
import java.io.*;

public class Q21_Combinations_1 {

    public static void combinations(int cb, int tb, int ssf, int ts, String asf){
        
      if(cb > tb){ // when current box is higher (exceeded)

        if(ssf == ts){ // when total items used is equal to total iteams 
            System.out.println(asf); 
        }
        return ;
    }

    if(ssf < tb) // when item used so far is lesser than total then we store one item in current box
        combinations(cb+1, tb, ssf+1, ts, asf+"i");

        // when we don't store item in current box
        combinations(cb+1 , tb, ssf, ts, asf+"_");

      }
    
      public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nboxes = Integer.parseInt(br.readLine());
        int ritems = Integer.parseInt(br.readLine());
        combinations(1, nboxes, 0, ritems, "");
        br.close();
      }
    
}


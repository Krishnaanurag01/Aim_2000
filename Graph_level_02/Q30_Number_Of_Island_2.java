package Graph_level_02;
import java.util.*;
import java.io.*;

public class Q30_Number_Of_Island_2 {
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int m = Integer.parseInt(st[0]);
        int n = Integer.parseInt(st[1]);
        int q = Integer.parseInt(st[2]);
    
        int[][] pos = new int[q][2];
        for (int i = 0; i < q; i++) {
          st = br.readLine().split(" ");
          pos[i][0] = Integer.parseInt(st[0]);
          pos[i][1] = Integer.parseInt(st[1]);
        }
    
        System.out.println(numIslands2(m, n, pos));
      }
    
      public static List<Integer> numIslands2(int m, int n, int[][] positions) {
    
    // using dsu(disjoin set union) algo
          int[] parent = new int[m*n] ;
        int[] rank = new int[m*n] ;
    
        Arrays.fill(parent,-1) ; // this will help us in identifying which cell has came before(visited)
    
        List<Integer> ans = new ArrayList<>() ;
    
        int count = 0 ; // will hold number of island found so far
    
        int[][] direc = { {0,1},{1,0},{0,-1},{-1,0} } ; // adjecent directions
    
        for(int i = 0 ; i < positions.length ; i++){
    
          int row = positions[i][0] ;
          int col = positions[i][1] ;
    
          int cellNo = row*n + col ;// getting the cell number of matrix.
    
          if(parent[cellNo] != -1){ // means used before
            ans.add(count)  ; // so add old count as no new island found and continue
            continue; 
          }

          // dsu part
          
          parent[cellNo] = cellNo ; // else make it's own parent initally
          rank[cellNo] = 1 ; 
          count++ ; // increasing becuase we added a land
    
          // going all four directions.
          for(int j = 0 ; j < 4 ; j++){
    
            int rDash = row + direc[j][0] ;
            int cDash = col + direc[j][1] ;
    
            int adjCell = rDash*n + cDash ; // adjecnt cell
    
            // if out of found then continue
            // else if parent[adcell] = -1 means there is no island so also continue
            if(rDash < 0 || cDash < 0 || rDash >= m || cDash >= n || parent[adjCell] == -1){
              continue ;
            }
    
            // union operation
    
            int lx = find(cellNo,parent) ;
            int ly = find(adjCell,parent) ;
    
            if(lx != ly){
              
              if(rank[lx] < rank[ly]){
                parent[lx] = ly ;
              }
              else if(rank[ly] < rank[lx]){
                parent[ly] = lx ;
              }
              else{
                parent[lx] = ly ;
                rank[ly]++ ;
              }
    
              count-- ; // becuase we are merging two island into one
    
            }
    
    
          }
    
          ans.add(count) ;
        }
    
        return ans ;
        
    
      }
    
    
      public static int find(int x, int parent[] ){
    
        if(parent[x] == x){
          return x ;
        }
    
        int temp = find(parent[x] , parent) ;
        parent[x] = temp ;
        return temp ;
      
      }


}

package Graph_level_02;

public class Q47_Regions_Cut_By_Slashes {

    // using DSU.
    static int parent[] ;
    static int rank[] ;
    int count  ;
    // visulize grid as dotted grid
    public int regionsBySlashes(String[] grid) {
        int n = grid.length ;
        int dots = n+1 ;
        parent = new int[dots*dots] ;
        rank = new int[dots*dots] ;
        
        for(int i = 0 ; i < dots * dots ; i++){
            parent[i] = i ;
            rank[i] = 1 ;
        }
        
      count = 1 ; // for defualt grid.
        // making the default grid.
        for(int i = 0 ; i < dots ; i++){
            for(int j = 0 ; j < dots; j++){
                if(i == 0 || i == dots - 1 || j == 0 || j == dots - 1){
                    
                        int cellNo = i*dots + j ;
                    if(cellNo != 0)
                        union(0,cellNo) ;
                }
            }
        }
        
        for(int i = 0 ; i < grid.length ; i++){
           char[] ch = grid[i].toCharArray() ;
            for(int j = 0 ; j < ch.length ; j++ ){
                if(ch[j] == '/'){
                    int u = i*dots+(j+1) ;
                    int v = (i+1)*dots+j ;
                    union(u,v) ;
                }
                else if(ch[j] == '\\' ){
                    int u = i*dots+(j) ;
                    int v = (i+1)*dots+(j+1) ;
                    union(u,v) ;
                }
            }
        }
        
        return count ;
    }
    
    void union(int u, int v){
        int lx = find(u,parent) ;
        int ly = find(v,parent) ;
        
        if(lx != ly){
            if(rank[lx] > rank[ly]){
                parent[ly] = lx ;
            }
            else if(rank[ly] > rank[lx]){
                parent[lx] = ly ;
            }
            else{
                parent[ly] = lx ;
                rank[lx]++ ;
            }
        }
        else{ // if parent same then it is forming a region so increase the count
            count++ ;
        }
    }
    
    int find(int x, int[] parent){
        if(parent[x] == x){
            return x ;
        }
        int temp = find(parent[x],parent) ;
        return parent[x] = temp ;
    }
}

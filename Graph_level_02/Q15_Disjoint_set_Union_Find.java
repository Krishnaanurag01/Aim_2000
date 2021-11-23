package Graph_level_02;


// kruskal uses this for finding the MST.
public class Q15_Disjoint_set_Union_Find {
    
    int find(int A[],int X)
    {
      if(A[X] == X){
          return X; 
      }
      
      int temp = find(A,A[X]);
      A[X] = temp ;
      
      return temp ;
}

void unionSet(int A[],int X,int Z)
    {
     //add code here.
     
     int LX = find(A,X) ;
     int LZ = find(A,Z) ;
     
     if(LX != LZ ){
         
         A[LX] = LZ ;
     }
}

}

package Problem_Of_The_day;

public class Q397_Minimum_Number {
    public static int minimumNumber(int n, int[] arr) {
        int m=Integer.MAX_VALUE;
        boolean odd=false;
      
      for(int i=0;i<n;i++)
      {
          if(arr[i]%2==1)
          {
              odd=true;
              break;
          }
          
          m=Math.min(m,arr[i]);
      }
      
      if(odd)
      return 1;
      else
      return m;
  }
}

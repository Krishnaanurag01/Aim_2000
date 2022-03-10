package HashMaps_and_Heaps_Level_02;
import java.util.* ;

public class Q20_Find_Anagram_Mappings {

    public static int[] anagramMappings(int[] arr1, int[] arr2) {

		HashMap<Integer,ArrayList<Integer>> map = new HashMap<>() ;

        // adding all number with their index in map of arr2.
		for(int i = 0 ; i < arr2.length ; i++){
			ArrayList<Integer> inList = map.getOrDefault(arr2[i], new ArrayList<Integer>() ) ;
			inList.add(i) ;
			map.put(arr2[i], inList) ;
		}

		int[] ans = new int[arr1.length] ;

        // now getting index for arr1[i] and adding it to answer.
		for(int i = 0 ; i < arr1.length ; i++){
			ArrayList<Integer> inList = map.getOrDefault(arr1[i], new ArrayList<Integer>() ) ;
			
			if(inList.size() > 0){
				int idx = inList.remove(0) ;
				ans[i] = idx ;
			}
		}


		return ans;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = s.nextInt();
		}
		for (int j = 0; j < b.length; j++) {
			b[j] = s.nextInt();
		}
		int[] res = anagramMappings(a, b);
		for (int j = 0; j < res.length; j++) {
			System.out.print(res[j] + " ");
		}
        s.close();
	}
    
}

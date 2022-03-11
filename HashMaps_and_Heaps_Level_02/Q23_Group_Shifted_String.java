package HashMaps_and_Heaps_Level_02;
import java.util.*;

public class Q23_Group_Shifted_String {

    public static ArrayList<ArrayList<String>> groupShiftedStrings(String[] strs) {
		
		ArrayList<ArrayList<String>> ans = new ArrayList<>() ;

		HashMap<String,ArrayList<String>> map = new HashMap<>() ;

		for(String s : strs){
			String key = getKey(s) ; // getting key for each string.

            // and storing current string with correspond to key.
			ArrayList<String> inAns = map.getOrDefault(key, new ArrayList<>()) ;

			inAns.add(s) ;
			map.put(key,inAns) ;
		}

		for (ArrayList<String> an : map.values()) {
			ans.add(an) ;
		}

		return ans;
	}

    // key generation.
	static String getKey(String s){

		String key = "" ;

		for(int i = 1 ; i < s.length() ; i++){
			char curr = s.charAt(i) ;
			char prev = s.charAt(i-1) ;

            // taking difference
			int diff = curr - prev ;

            // if it is negative then making it positive.
			if(diff < 0){
				diff += 26 ;
			}

			key += diff + "#" ;
		}

		key +='.' ;

		return key ;
	}

    // Pre defined Input function.

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] arr = new String[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.next();
		}
		ArrayList<ArrayList<String>> shiftedGroup = groupShiftedStrings(arr);
		for (ArrayList<String> lst : shiftedGroup) {
			Collections.sort(lst);
		}
		shiftedGroup.sort(new ListComparator());
		display(shiftedGroup);
        sc.close();
	}

	// it is used to make the result unique
	static class ListComparator implements Comparator<List<String>> {
		@Override
		public int compare(List<String> l1, List<String> l2) {
			if (l1.size() != l2.size()) {
				return l2.size() - l1.size();
			}

			String l1str = l1.get(0);
			String l2str = l2.get(0);
			return l1str.compareTo(l2str);

		}
	}

	public static void display(ArrayList<ArrayList<String>> list) {
		for (int i = 0; i < list.size(); i++) {
			ArrayList<String> currList = list.get(i);
			for (int j = 0; j < currList.size(); j++) {
				System.out.print(currList.get(j) + " ");
			}
			System.out.println();
		}
	}
    
}

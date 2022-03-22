
package Recursion_and_backtracking_level_02;

import java.util.*;

public class Q11_K_partitions {

	static int counter = 0;

	public static void solution(int i, int n, int k, int ssf, ArrayList<ArrayList<Integer>> ans) {
		// write your code here
		if (i > n) { // when i > n then return
			if (ssf == k) { // if set so far(ssf) equals to k means if we got all the k subset then print
							// the answer
				counter++;

				System.out.print(counter + ". "); // first print the index num

				for (ArrayList<Integer> a : ans) // now printing entire set
				{
					System.out.print(a + " ");
				}
				System.out.println();

			}
			return;
		}

		// traverse in each list
		for (int j = 0; j < ans.size(); j++) {
			if (ans.get(j).size() > 0) { // if the set of ans list contains any element then add current element as well

				ans.get(j).add(i); // adding current element
				solution(i + 1, n, k, ssf, ans); // and discover for next element
				ans.get(j).remove(ans.get(j).size() - 1); // removing the last added element for next solution

			} else { // else if set doesn't have any element in it then add current element in the
						// first empty set (as we don't want permutation)
				ans.get(j).add(i);
				solution(i + 1, n, k, ssf + 1, ans); // as we added one element in the empty set so set so far will get
														// increased by 1.
				ans.get(j).remove(ans.get(j).size() - 1);
				break; // this will help us in avoiding the permuation and adding element in only one
						// set
			}
		}
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int k = scn.nextInt();
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			ans.add(new ArrayList<>());
		}
		solution(1, n, k, 0, ans);
		scn.close();

	}

}

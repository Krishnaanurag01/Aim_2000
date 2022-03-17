package Bit_Manipulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Q6_Minimum_Number_Of_Software_Developers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;

        int nSkills = sc.nextInt() ;

        HashMap<String,Integer> map = new HashMap<>() ;

        // mapping all the skills with index in map so that we can create mask with it.
        for (int i = 0; i < nSkills ; i++) {
            String skill = sc.next() ;
            map.put(skill, i) ;
        }

        int applicants = sc.nextInt() ;

        // we will be given skills of each person in string but we will create mask of it with the help of "OR(|)" operation and store in below array.
        int[] skillsOfPersons = new int[applicants] ;

        for (int i = 0; i < skillsOfPersons.length; i++) {

			int totalSkills = sc.nextInt() ;

			for(int j = 0 ; j < totalSkills ; j++){
            String skill = sc.next() ;

            int skillMask = map.get(skill) ; // getting given skill mask from map
            // now we have to combine all the mask of skills in ith person.
            // so doing "OR" operation in previous mask.
            skillsOfPersons[i] = skillsOfPersons[i] | ( 1 << skillMask) ;
			}
        }

        // sending persons skills , total skills, current person ( intially 0 given), solution list, and mask (0 initially)
        solution( skillsOfPersons, nSkills, 0 , new ArrayList<Integer>()  , 0 ) ;
		
        // printing the optimal solution
		System.out.println(optimalSol);

        sc.close();
    }

    static ArrayList<Integer> optimalSol = new ArrayList<>() ;

    private static void solution(int[] skillsOfPersons, int nSkills, int cp, ArrayList<Integer> sol , int masksf) { // masksf = mask so far

        if(cp == skillsOfPersons.length ){ // when all persons visited then check

            if(masksf == (1 << nSkills ) - 1 ){ // this denotes when all bits of mask is 1 . explanation of (1<< nskills)-1 is : eg : nskills is 5 then  (1 << nskills) is 100000 (5 left shifted) and -1 gives 11111 so when masksf is 11111(contains all skills) then check

                // if optimal solution has 0 then it means it does not contains anything or when optimal solution size is larger than current solution then replace it with current solution
                if(optimalSol.size() == 0 || optimalSol.size() > sol.size() ){
                    optimalSol = new ArrayList<>(sol) ;
                }
            }

                return ;
        }

        // not taking current person so moving to next person
        solution(skillsOfPersons, nSkills, cp+1 , sol , masksf);

        // else taking current person

        sol.add(cp) ;

        // as we took current person so also adding current persons skills.
        solution(skillsOfPersons, nSkills, cp + 1, sol, masksf | skillsOfPersons[cp] );
        // removing current person (that is added at end)
        sol.remove(sol.size()-1) ;
    }











    // leetcode solution : giving correct output when same test case runs indivisually but error on submission

    /*

      public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        
        HashMap<String,Integer> map = new HashMap<>() ;
        
        for(int i = 0 ; i < req_skills.length ; i++){
            map.put( req_skills[i] , i ) ;
        }
        
        int[] sPerson = new int[people.size()] ;
        
        for(int i = 0; i < sPerson.length ; i++){
            for(String skill : people.get(i)){
                int mask = map.get(skill) ;
                sPerson[i] = sPerson[i] | ( 1 << mask ) ;
            }
        }
        
        for(int i : sPerson)
        System.out.print(i+"-") ;
        
        solution( sPerson, req_skills.length , 0 , new ArrayList<Integer>()  , 0 ) ;
        
        int[] ans = new int[optimalSol.size()] ;
        
        for(int i = 0 ; i < ans.length ; i++){
            ans[i] = optimalSol.get(i) ;
        }
		
        return ans ;
        
    }
    
    static ArrayList<Integer> optimalSol = new ArrayList<>() ;

    private static void solution(int[] skillsOfPersons, int nSkills, int cp, ArrayList<Integer> sol , int masksf) { // masksf = mask so far

        if(cp == skillsOfPersons.length ){ // when all persons visited then check

            if(masksf == (1 << nSkills ) - 1 ){ // this denotes when all bits of mask is 1 . explanation of (1<< nskills)-1 is : eg : nskills is 5 then  (1 << nskills) is 100000 (5 left shifted) and -1 gives 11111 so when masksf is 11111(contains all skills) then check

                // if optimal solution has 0 then it means it does not contains anything or when optimal solution size is larger than current solution then replace it with current solution
                if(optimalSol.size() == 0 || optimalSol.size() > sol.size() ){
                    optimalSol = new ArrayList<>(sol) ;
                }
            }

                return ;
        }

        // not taking current person so moving to next person
        solution(skillsOfPersons, nSkills, cp+1 , sol , masksf);

        // else taking current person

        sol.add(cp) ;

        // as we took current person so also adding current persons skills.
        solution(skillsOfPersons, nSkills, cp + 1, sol, masksf | skillsOfPersons[cp] );
        // removing current person (that is added at end)
        sol.remove(sol.size()-1) ;
    }

    */
    
}

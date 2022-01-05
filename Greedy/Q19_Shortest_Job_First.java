package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q19_Shortest_Job_First {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter the number of process : ");
        int n = Integer.parseInt(br.readLine()); // no of process

        System.out.println();

        int[][] processes = new int[n][3];

        for (int i = 0; i < processes.length; i++) {

            System.out.print("Enter the Process id : ");
            int id = Integer.parseInt(br.readLine());

            System.out.println();

            System.out.print("Enter the Arrival Time : ");
            int at = Integer.parseInt(br.readLine());

            System.out.println();

            System.out.print("Enter the burst time : ");
            int bt = Integer.parseInt(br.readLine());

            System.out.println();

            processes[i][0] = id;
            processes[i][1] = at;
            processes[i][2] = bt;

        }

        // System.out.println(Arrays.deepToString(processes));

        sjf(processes);
    }

    static class compAt implements Comparator<int[]>  {

        @Override
        public int compare(int[] o1, int[] o2) {
            
            if(o1[1] == o2[1]){
                if( o1[2] == o2[2] ){
                    return o1[0] - o2[0] ;
                }

                return o1[2] - o2[2] ;
            }

            return o1[1] - o2[1];
        }
    
        
    }

    public static void sjf(int[][] processes) {

        PriorityQueue<int[]> readyQueue = new PriorityQueue<>(new comp());

        Arrays.sort(processes, new compAt() );

        // System.out.println(Arrays.deepToString(processes));

        // int first_arrival = processes[0][1];
        int count = 0;
        
        // for (int i = 0; i < processes.length; i++) {
            
            //     if (processes[i][1] == first_arrival) {
                //         readyQueue.add(processes[i]);
        //         // processes[i][0] = -1; // for identification
        //         li = i;
        //         count++;
        //     } else {
            //         break;
            //     }
            // }
            
            readyQueue.add(processes[0]) ;
            processes[0][2] = processes[0][2] + processes[0][1] ;
            
            
            
            ArrayList<int[]> list = new ArrayList<>();
            
            // int next_arrival = readyQueue.peek()[1] ;
            
            int li = 1;
        count = 0;

        while (readyQueue.size() != 0 && count != processes.length) {

            int next_arrival = readyQueue.peek()[2];
            list.add(readyQueue.poll());
            boolean flag = false;
            count++;

            if (count == processes.length)
                break;

            for (int i = li ; i < processes.length; i++) {

                if (processes[i][1] <= next_arrival) {
                    readyQueue.add(processes[i]);
                    processes[i][2] = processes[i][2] + next_arrival ;
                    flag = true;
                } else {
                    break;
                }
            }

            if (flag == false ) {
                next_arrival++;
            }

        }

        for (int[] is : list) {
            System.out.print(is[0] + " ");
        }

    }

    static class comp implements Comparator<int[]> {

        @Override
        public int compare(int[] o1, int[] o2) {

            return o1[2] - o2[2];
        }

    }

}

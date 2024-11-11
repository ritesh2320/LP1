import java.util.*;

public class algoFCFS {
    public static void main(String[] args) {
        //first come first serve, the process which comes first shall be served first whatsoever.
        //
        int n;
        Scanner s = new Scanner(System.in);
        
        System.out.println("First Come First Serve Algorithm");
        System.out.println("Enter Number of Processes :");
        n= s.nextInt();
        int Process[] = new int[n];
        int Arrival[] = new int[n];
        int Burst[] = new int[n];
        int Waiting[] = new int[n];
        int Completion[] = new int[n];
        int TurnAround[] = new int[n];

        //input in process array
        for (int i = 0; i < n; i++) {
            // System.out.println("Enter Process Number :");
            Process[i] = i+1;
            System.out.println("Enter Arrival Time For Process "+(i+1)+" :");
            Arrival[i] = s.nextInt();
            System.out.println("Enter Burst Time :");
            Burst[i] = s.nextInt();
        }
        
        //display data w/ completion time =bursttime SUM,TurnAroundTime= CT - AT and waiting time= TAT - BT
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Process | Arrival | Burst | Completion | Turnaround | Waiting");
        System.out.println("---------------------------------------------------------------------");
        
        for (int i = 0; i < n; i++) {
            if(i == 0) Completion[0] = Burst[0] + Arrival[0]; //for 1st completion
            else Completion[i] = Math.max(Completion[i-1],Arrival[i]) + Burst[i];
            TurnAround[i] = Completion[i] - Arrival[i];

            Waiting[i] = TurnAround[i] - Burst[i];

            System.out.println(Process[i] + "\t  "+Arrival[i] + "\t "+Burst[i] + "\t\t"+Completion[i] + "\t\t"+TurnAround[i] + "\t"+Waiting[i]);
        }
        s.close();

    }
}

/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.Scanner;
public class Main
{
	public static void main(String[] args)
	{
		 Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of process :");
        int n = sc.nextInt();
        int pid[] = new int[n];
        int at[] = new int[n];
        int bt[] = new int[n];
        int ct[] = new int[n];
        int tat[] = new int[n];
        int wt[] = new int[n];
        int left[] = new int[n];

        for (int i = 0; i < n; i++) {
            pid[i] = i + 1;
            System.out.println("Process " + (i + 1) + " -");
            System.out.println("Arrival Time :");
            at[i] = sc.nextInt();
            System.out.println("Burst Time :");
            bt[i] = sc.nextInt();
            left[i] = bt[i];
            System.out.println();
        }
        int temp = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (at[j] > at[j + 1]) {
                    temp = at[j];
                    at[j] = at[j + 1];
                    at[j + 1] = temp;
                    temp = bt[j];
                    bt[j] = bt[j + 1];
                    bt[j + 1] = temp;
                    temp = pid[j];
                    pid[j] = pid[j + 1];
                    pid[j + 1] = temp;
                }
            }
        }
        int finale = 0, cut = 0;
        for (int i = 0; i < n; i++) {
            finale += bt[i];
        }
        while (finale > cut) {
            for (int i = 0; i < n; i++) {
                if (left[i] > 2) {
                    cut+=2;
                    left[i]-=2;
                } else if (left[i] != 0 && left[i] <= 2) {
                    cut+=left[i];
                    ct[i]=cut;
                    left[i]=0;
                }
            }
        }
        
        for(int x:ct)
            System.out.println(x);
        
        int sumtat = 0, sumwt = 0;
        for (int i = 0; i < n; i++) {
            tat[i] = ct[i] - at[i];
            wt[i] = tat[i] - bt[i];
            sumtat += tat[i];
            sumwt += wt[i];
        }

        float avg_wt = 0, avg_tat = 0;
        avg_tat = sumtat / n;
        avg_wt = sumwt / n;
        System.out.println("Average WT :" + avg_wt);
        System.out.println("Average TAT :" + avg_tat);
	}
}
